/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author luisc
 */
public class Contantes {

    public static Properties PROPS;

    public static String APP_NAME = "Martinna";
    public static String VERSION = "V2.0";
    public static String WS_CONSULTACOMPROBANTE;

    static {

        WS_CONSULTACOMPROBANTE = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";

    }

}
