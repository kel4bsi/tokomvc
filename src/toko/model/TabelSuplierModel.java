/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;

import toko.entity.Suplier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author mas owa
 */
public class TabelSuplierModel extends AbstractTableModel{
    private List<Suplier> list = new ArrayList<Suplier>();
    
    public void setList(List<Suplier> list) {
        this.list = list;
    }

    public Suplier set(int index, Suplier element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Suplier remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Suplier get(int index) {
        return list.get(index);
    }

    public boolean add(Suplier e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "ID Suplier";
            case 1 : return "Nama suplier";
            case 2 : return "Alamat";
            case 3 : return "No.Telp";
            case 4 : return "Email";
            default: return null;
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_suplier();
            case 1 : return list.get(rowIndex).getNama_suplier();
            case 2 : return list.get(rowIndex).getAlamat_suplier();
            case 3 : return list.get(rowIndex).getNo_telp_suplier();
            case 4 : return list.get(rowIndex).getEmail_suplier();
            default: return null;
        }
    }
}

