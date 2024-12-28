/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.models;

import com.nancyin.martinna.wmartinna.beans.Autorizacion;
import java.util.List;

/**
 *
 * @author 91894
 */
public class FacturaModel implements ModeloTabla {

    private List<Autorizacion> data;
    private String[] columnNames;

    public FacturaModel(List<Autorizacion> data) {
        this.data = data;
        columnNames = new String[]{"numeroAutorizacion", "fechaAutorizacion", "rucEmisor",
            "razonSocialEmisor", "serieComprobante", "tipoComprobante",
            "fechaEmision", "totalSinImpuestos", "baseCero", "baseIva",
            "iva", "importeTotal"};
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public String[] getColumnNames() {
        return columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Autorizacion item = data.get(row);
        switch (col) {
            case 0:
                return item.getNumeroAutorizacion();
            case 1:
                return item.getFechaAutorizacion();
            case 2:
                return item.getRucEmisor();
            case 3:
                return item.getRazonSocialEmisor();
            case 4:
                return item.getSerieComprobante();
            case 5:
                return item.getTipoComprobante();
            case 6:
                return item.getFechaEmision();
            case 7:
                try {
                return new Double(item.getTotalSinImpuestos());
            } catch (Exception e) {
                return new Double("0");
            }
            case 8:
                try {
                return new Double(item.getBaseCero());
            } catch (Exception e) {
                return new Double("0");
            }
            case 9:
                try {
                return new Double(item.getBaseIva());
            } catch (Exception e) {
                return new Double("0");
            }
            case 10:
                try {
                return new Double(item.getIva());
            } catch (Exception e) {
                return new Double("0");
            }
            case 11:
                try {
                return new Double(item.getImporteTotal());
            } catch (Exception e) {
                return new Double("0");
            }
            default:
                return "";
        }
    }

}
