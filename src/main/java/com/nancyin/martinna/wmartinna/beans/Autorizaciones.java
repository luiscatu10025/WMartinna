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
public class Autorizaciones {

    private List<Autorizacion> autorizaciones;
    private Boolean error;
    private String claveAcceso;

    public Autorizaciones() {
        error=false;
    }
    

    public List<Autorizacion> getAutorizaciones() {
        if (autorizaciones == null) {
            autorizaciones = new ArrayList<>();
        }
        return autorizaciones;
    }

    public void setAutorizaciones(List<Autorizacion> autorizaciones) {
        this.autorizaciones = autorizaciones;
    }

    @Override
    public String toString() {
        return "Autorizaciones{" + "autorizaciones=" + autorizaciones + '}';
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
    
    

}
