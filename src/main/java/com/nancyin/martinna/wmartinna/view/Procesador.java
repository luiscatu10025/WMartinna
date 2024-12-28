/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.view;

import com.nancyin.martinna.wmartinna.beans.Autorizacion;
import com.nancyin.martinna.wmartinna.control.Orquestar;
import com.nancyin.martinna.wmartinna.models.FacturaModel;
import com.nancyin.martinna.wmartinna.models.NotaCreditoModel;
import com.nancyin.martinna.wmartinna.models.RetencionModel;
import com.nancyin.martinna.wmartinna.utils.XlsUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 91894
 */
@ManagedBean
@SessionScoped
public class Procesador implements Serializable {

    private List<String> keys;
    private List<Autorizacion> factura;
    private List<Autorizacion> notaCredito;
    private List<Autorizacion> retencion;
    private List<Autorizacion> otros;
    private Autorizacion autorizacion;

    @PostConstruct
    public void init() {
       
    }

    public String restore() {
        keys = new ArrayList<>();
        factura = new ArrayList<>();
        notaCredito = new ArrayList<>();
        retencion = new ArrayList<>();
        otros = new ArrayList<>();
        autorizacion = null;
        return "index";
    }

    public String procesar() {
        Orquestar h = new Orquestar();
        h.setKeys(keys);
        h.start();
        factura = h.getaFactura();
        notaCredito = h.getaNotaCredito();
        retencion = h.getaRetencion();
        otros = h.getaOtros();
        return "tablas";

    }

    public void downloadFacturaXls() {
        ServletOutputStream out = null;
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            XlsUtils xlsUtils = new XlsUtils(new FacturaModel(factura));
            xlsUtils.toXls();

            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType("application/xls");
            response.setCharacterEncoding("ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + xlsUtils.getFileName());
            out = response.getOutputStream();
            out.write(xlsUtils.getData());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void downloadNotaCreditoXls() {
        ServletOutputStream out = null;
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            XlsUtils xlsUtils = new XlsUtils(new NotaCreditoModel(notaCredito));
            xlsUtils.toXls();

            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType("application/xls");
            response.setCharacterEncoding("ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + xlsUtils.getFileName());
            out = response.getOutputStream();
            out.write(xlsUtils.getData());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void downloadRetencionXls() {
        ServletOutputStream out = null;
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            XlsUtils xlsUtils = new XlsUtils(new RetencionModel(retencion));
            xlsUtils.toXls();

            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType("application/xls");
            response.setCharacterEncoding("ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + xlsUtils.getFileName());
            out = response.getOutputStream();
            out.write(xlsUtils.getData());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void downloadXml() {
        ServletOutputStream out = null;
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();

            String xml = autorizacion.getXml();
            String xmlReturn;
            if (autorizacion.getTipoComprobante().equalsIgnoreCase("01")) {
                xmlReturn = xml.replaceAll("<factura", "<?xml-stylesheet href=\"./faces/resources/xsl/factura.xsl\" type=\"text/xsl\"?><factura");
            } else if (autorizacion.getTipoComprobante().equalsIgnoreCase("04")) {
                xmlReturn = xml.replaceAll("<notaCredito", "<?xml-stylesheet href=\"./faces/resources/xsl/notac.xsl\" type=\"text/xsl\"?><notaCredito");
            } else if (autorizacion.getTipoComprobante().equalsIgnoreCase("07")) {
                xmlReturn = xml.replaceAll("<comprobanteRetencion", "<?xml-stylesheet href=\"./faces/resources/xsl/retencion.xsl\" type=\"text/xsl\"?><comprobanteRetencion");
            } else {
                xmlReturn = xml;
            }

            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType("text/xml");
            response.setCharacterEncoding("ISO-8859-1");
            response.setHeader("Content-Disposition", "filename=file.xml");
            out = response.getOutputStream();
            out.write(xmlReturn.getBytes());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<Autorizacion> getFactura() {
        return factura;
    }

    public void setFactura(List<Autorizacion> factura) {
        this.factura = factura;
    }

    public List<Autorizacion> getNotaCredito() {
        return notaCredito;
    }

    public void setNotaCredito(List<Autorizacion> notaCredito) {
        this.notaCredito = notaCredito;
    }

    public List<Autorizacion> getRetencion() {
        return retencion;
    }

    public void setRetencion(List<Autorizacion> retencion) {
        this.retencion = retencion;
    }

    public List<Autorizacion> getOtros() {
        return otros;
    }

    public void setOtros(List<Autorizacion> otros) {
        this.otros = otros;
    }

    public Autorizacion getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Autorizacion autorizacion) {
        this.autorizacion = autorizacion;
    }

}
