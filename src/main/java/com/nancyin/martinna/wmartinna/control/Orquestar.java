/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.control;

import com.nancyin.martinna.wmartinna.beans.Autorizacion;
import com.nancyin.martinna.wmartinna.utils.WSUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisc
 */
public class Orquestar {

    private List<String> keys;
    private List<Autorizacion> autorizacioneses = new ArrayList<>();
    private List<Autorizacion> aFactura;
    private List<Autorizacion> aNotaCredito;
    private List<Autorizacion> aRetencion;
    private List<Autorizacion> aOtros;

    public void start() {
        //To change body of generated methods, choose Tools | Templates.

        WSUtils sUtils = new WSUtils();
        for (String s : keys) {
            autorizacioneses.add(sUtils.consultar(s));
        }

        aFactura = new ArrayList<>();
        aNotaCredito = new ArrayList<>();
        aRetencion = new ArrayList<>();
        aOtros = new ArrayList<>();

        for (Autorizacion a : autorizacioneses) {
            switch (a.getTipoComprobante()) {
                case "01":
                    aFactura.add(a);
                    break;
                case "04":
                    aNotaCredito.add(a);
                    break;
                case "07":
                    aRetencion.add(a);
                    break;
                default:
                    aOtros.add(a);
                    break;

            }
        }
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<Autorizacion> getAutorizacioneses() {
        return autorizacioneses;
    }

    public void setAutorizacioneses(List<Autorizacion> autorizacioneses) {
        this.autorizacioneses = autorizacioneses;
    }

    public List<Autorizacion> getaFactura() {
        return aFactura;
    }

    public void setaFactura(List<Autorizacion> aFactura) {
        this.aFactura = aFactura;
    }

    public List<Autorizacion> getaNotaCredito() {
        return aNotaCredito;
    }

    public void setaNotaCredito(List<Autorizacion> aNotaCredito) {
        this.aNotaCredito = aNotaCredito;
    }

    public List<Autorizacion> getaRetencion() {
        return aRetencion;
    }

    public void setaRetencion(List<Autorizacion> aRetencion) {
        this.aRetencion = aRetencion;
    }

    public List<Autorizacion> getaOtros() {
        return aOtros;
    }

    public void setaOtros(List<Autorizacion> aOtros) {
        this.aOtros = aOtros;
    }

    
}
