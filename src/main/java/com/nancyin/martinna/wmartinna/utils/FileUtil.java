/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luisc
 */
public class FileUtil {

    private List<String> list;

    public FileUtil() {
        list = new ArrayList<>();
    }

    private void addKey(String key) {
        boolean encontrado = false;
        for (String s : list) {
            if (s.equals(key)) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            list.add(key);
        }
    }

    public void getAKeys(String file) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] cols = linea.split("\t");
                for (String s : cols) {
                    if (s.length() == 49 && s.matches("[0-9]+")) {
                        addKey(s);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No se puede obtener las claves en el archivo plano, puede que el archivo no exista", e);
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getAKeys(InputStream file) {

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            Scanner obj = new Scanner(file);
            while (obj.hasNextLine()) {
                String linea = obj.nextLine();
                String[] cols = linea.split("\t");
                for (String s : cols) {
                    if (s.length() == 49 && s.matches("[0-9]+")) {
                        addKey(s);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("No se puede obtener las claves en el archivo plano, puede que el archivo no exista", e);
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != file) {
                    file.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<String> getList() {
        return list;
    }

//    public static void main(String[] args) {
//        FileUtil fileUtil = new FileUtil();
//        fileUtil.getAKeys("/home/luisc/Descargas/100299.txt");
//        for(String s:fileUtil.list){
//            System.out.println(s);
//        }
//        
//
//    }
}
