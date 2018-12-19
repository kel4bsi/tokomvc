/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;

import toko.entity.Karyawan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author mas owa
 */
public class TabelKaryawanModel extends AbstractTableModel{
    private List<Karyawan> list = new ArrayList<Karyawan>();
    
    public void setList(List<Karyawan> list) {
        this.list = list;
    }

    public Karyawan set(int index, Karyawan element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Karyawan remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Karyawan get(int index) {
        return list.get(index);
    }

    public boolean add(Karyawan e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Nik";
            case 1 : return "Nama Karyawan";
            case 2 : return "Alamat";
            case 3 : return "No.Telp";
            case 4 : return "Email";
            case 5 : return "Tgl. Daftar";
            default: return null;
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getNik();
            case 1 : return list.get(rowIndex).getNama_karyawan();
            case 2 : return list.get(rowIndex).getAlamat();
            case 3 : return list.get(rowIndex).getNo_telp();
            case 4 : return list.get(rowIndex).getEmail();
            case 5 : return list.get(rowIndex).getTgl_daftar();
            default: return null;
        }
    }
}
