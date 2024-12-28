/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.beans;

/**
 *
 * @author Luis C.
 */
public class Mensaje {

    private String identificador;
    private String mensaje;
    private String informacionAdicional;
    private String tipo;

    public Mensaje() {
        identificador = "";
        mensaje = "";
        informacionAdicional = "";
        tipo = "";
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "identificador=" + identificador + ", mensaje=" + mensaje + ", informacionAdicional=" + informacionAdicional + ", tipo=" + tipo + '}';
    }
    

}
