/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;

import toko.entity.Stok;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author mas owa
 */
public class TabelStokModel extends AbstractTableModel{
    private List<Stok> list = new ArrayList<Stok>();
    
    public void setList(List<Stok> list) {
        this.list = list;
    }

    public Stok set(int index, Stok element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Stok remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Stok get(int index) {
        return list.get(index);
    }

    public boolean add(Stok e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Kode Barang";
            case 1 : return "Nama Barang";
            case 2 : return "Harga";
            case 3 : return "Tgl.masuk";
            case 4 : return "Jml. Barang";
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
            case 0 : return list.get(rowIndex).getKode_brg();
            case 1 : return list.get(rowIndex).getNama_brg();
            case 2 : return list.get(rowIndex).getHarga();
            case 3 : return list.get(rowIndex).getTgl_masuk();
            case 4 : return list.get(rowIndex).getJml_brg();
            default: return null;
        }
    }
}
