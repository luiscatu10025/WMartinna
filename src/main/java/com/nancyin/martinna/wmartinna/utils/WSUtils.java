/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.utils;

import com.nancyin.martinna.wmartinna.beans.Autorizacion;
import com.nancyin.martinna.wmartinna.control.Processor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author luisc
 */
public class WSUtils {

    public Autorizacion consultar(String claveAcceso) {

        try {
            System.out.println("Consultando " + claveAcceso);
            URL url = new URL(Contantes.WS_CONSULTACOMPROBANTE);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ec=\"http://ec.gob.sri.ws.autorizacion\">\n<soapenv:Header/>\n<soapenv:Body>\n<ec:autorizacionComprobante>\n<!--Optional:-->\n<claveAccesoComprobante>" + claveAcceso + "</claveAccesoComprobante>\n" + "</ec:autorizacionComprobante>\n" + "</soapenv:Body>\n" + "</soapenv:Envelope>";

            byte[] buffer = new byte[xmlInput.length()];
            buffer = xmlInput.getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            String SOAPAction = "";

            httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "text/xml");
            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();

            out.write(b);
            out.close();

            InputStream inputStream = httpConn.getInputStream();
            Processor p = new Processor();
            Autorizacion a = null;
            try {
                a = p.procesar(inputStream);
            } catch (NancysException e) {
                a = new Autorizacion();
                a.setClaveAcceso(claveAcceso);
                e.printStackTrace(System.out);
            }
//            System.out.println(a);

            return a;

        } catch (Exception ex) {
//            LOG.error("Error al procesar solicitud", ex);
            ex.printStackTrace(System.out);
            return null;

        } 
    }

//    public static void main(String... args) {
//        WSUtils m = new WSUtils();
//        try {
//            m.consultar("0102202101179009320400120011000011337080113370819");
//        } catch (Exception ex) {
//            Logger.getLogger(WSUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
