/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.models;

/**
 *
 * @author 91894
 */
public interface ModeloTabla {

    public int getColumnCount();

    public String getColumnName(int col);

    public String[] getColumnNames();

    public int getRowCount();

    public Object getValueAt(int row, int col);

}
