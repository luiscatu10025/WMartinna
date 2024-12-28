/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.utils;


import com.nancyin.martinna.wmartinna.models.ModeloTabla;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author luisc
 */
public class XlsUtils {

    private String rutaArchivo;
    private XSSFWorkbook libro;
    private String fileName;
    private ModeloTabla model;


    public XlsUtils(ModeloTabla model) {
        this.model = model;
    }

    public void toXls() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
        fileName = "Report" + sdf.format(new Date()) + ".xlsx";
        String hoja = "Report";

        libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        //cabecera de la hoja de excel
        String[] header = model.getColumnNames();

        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        XSSFRow row = hoja1.createRow(0);//se crea las filas
        for (int j = 0; j < header.length; j++) {
            XSSFCell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
            cell.setCellStyle(style); // se añade el style crea anteriormente 
            cell.setCellValue(header[j]);//se añade el contenido					

        }

        int rowIndex = 1;
        try {
            CellStyle cellStylemdy = libro.createCellStyle();
            for (int i = 0; i < model.getRowCount(); i++) {
                row = hoja1.createRow(rowIndex);//se crea las filas
                for (int j = 0; j < header.length; j++) {
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    Object data = model.getValueAt(i, j);
                    if (data != null) {
                        if (data instanceof java.lang.String) {
                            String s = (String) data;
                            cell.setCellValue(s);
                        } else if (data instanceof java.lang.Double) {
                            Double d = (Double) data;
                            cell.setCellValue(d);
                        } else if (data instanceof BigDecimal) {
                            Double d = (Double) ((BigDecimal) data).doubleValue();
                            cell.setCellValue(d);
                        } else if (data instanceof java.lang.Integer) {
                            Integer integ = (Integer) data;
                            cell.setCellType(CellType.NUMERIC);
                            cell.setCellValue(integ);
                        } else if (data instanceof java.lang.Short) {
                            Short shor = (Short) data;
                            cell.setCellType(CellType.NUMERIC);
                            cell.setCellValue(shor);
                        } else if (data instanceof java.util.Date) {
                            Date date = (Date) data;

                            SimpleDateFormat FORMATTER;
                            FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
                            String date11 = FORMATTER.format(date);
                            cellStylemdy.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
                            cell.setCellStyle(cellStylemdy);
                            cell.setCellValue(FORMATTER.parse(date11));
                        }
                    } else {
                        cell.setCellType(CellType.BLANK);

                    }

                }
                rowIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String toFile() {
        File file;
        file = new File(rutaArchivo + "/" + fileName);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            return "Archivo " + file.getAbsolutePath() + " creado    ...!!";

        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se puede generar archivo xls", e);
        } catch (IOException e) {
            throw new RuntimeException("No se puede generar archivo xls", e);
        }

    }

    public void writeOutputStream(OutputStream fileOuS) {
        try {
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getData() {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try {
            libro.write(arrayOutputStream);
            byte[] data = arrayOutputStream.toByteArray();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

}
