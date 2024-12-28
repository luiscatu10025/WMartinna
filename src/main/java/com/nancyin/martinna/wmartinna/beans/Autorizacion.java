/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis C.
 */
public class Autorizacion {

    private String estado;
    private String claveAcceso;
    private String numeroAutorizacion;
    private String fechaAutorizacion;
    private String ambiente;
    private String comprobante;
    private String rucEmisor;
    private String razonSocialEmisor;
    private String serieComprobante;
    private String tipoComprobante;
    private String fechaEmision;
    private String baseCero;
    private String baseIva;
    private String iva;
    private String importeTotal;
    private String totalSinImpuestos;
    //para nota de credito
    private String numDocModificado;
    private String valorModificacion;
    private String motivo;
    //para retencion
    private String periodoFiscal;
    
    //para todos
    private String xml;
    

    private List<Mensaje> mensajes;

    public Autorizacion() {
        estado = "";
        numeroAutorizacion = "";
        fechaAutorizacion = "";
        ambiente = "";
        comprobante = "";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public List<Mensaje> getMensajes() {
        if (mensajes == null) {
            mensajes = new ArrayList<>();
        }
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public String getRucEmisor() {
        return rucEmisor;
    }

    public void setRucEmisor(String rucEmisor) {
        this.rucEmisor = rucEmisor;
    }

    public String getRazonSocialEmisor() {
        return razonSocialEmisor;
    }

    public void setRazonSocialEmisor(String razonSocialEmisor) {
        this.razonSocialEmisor = razonSocialEmisor;
    }

    public String getSerieComprobante() {
        return serieComprobante;
    }

    public void setSerieComprobante(String serieComprobante) {
        this.serieComprobante = serieComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getBaseCero() {
        return baseCero;
    }

    public void setBaseCero(String baseCero) {
        this.baseCero = baseCero;
    }

    public String getBaseIva() {
        return baseIva;
    }

    public void setBaseIva(String baseIva) {
        this.baseIva = baseIva;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(String totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public String getNumDocModificado() {
        return numDocModificado;
    }

    public void setNumDocModificado(String numDocModificado) {
        this.numDocModificado = numDocModificado;
    }

    public String getValorModificacion() {
        return valorModificacion;
    }

    public void setValorModificacion(String valorModificacion) {
        this.valorModificacion = valorModificacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getPeriodoFiscal() {
        return periodoFiscal;
    }

    public void setPeriodoFiscal(String periodoFiscal) {
        this.periodoFiscal = periodoFiscal;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
    
    

    @Override
    public String toString() {
        return "Autorizacion{" + "estado=" + estado + ", numeroAutorizacion=" + numeroAutorizacion + ", fechaAutorizacion=" + fechaAutorizacion + ", ambiente=" + ambiente + ", comprobante=" + comprobante + ", rucEmisor=" + rucEmisor + ", razonSocialEmisor=" + razonSocialEmisor + ", serieComprobante=" + serieComprobante + ", tipoComprobante=" + tipoComprobante + ", fechaEmision=" + fechaEmision + ", baseCero=" + baseCero + ", baseIva=" + baseIva + ", iva=" + iva + ", importeTotal=" + importeTotal + ", mensajes=" + mensajes + '}';
    }

}
