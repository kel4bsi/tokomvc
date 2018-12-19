/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.controller;

import toko.model.StokModel;
import toko.view.*;
import toko.error.StokException;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author mas owa
 */
public class StokController {
    private StokModel model;

    public void setModel(StokModel model) {
        this.model = model;
    }

    public void resetStok(DataStokView view) {
        model.resetStok();
    }

    public void getStok(PenjualanView view) {
        String Kode_brg = view.gettxtKode_brg().getText();

        if (Kode_brg.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode Stok masih kosong");
        } else if (Kode_brg.length() > 12) {
            JOptionPane.showMessageDialog(view, "Kode Stok tidak boleh lebih dari 10 karakter");
        } else {
            model.setKode_brg(Kode_brg);

            try {
                model.getStok();
                JOptionPane.showMessageDialog(view, "Data Stok Tersimpan");
                model.resetPenjualan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi Kesalahan Program",
                            throwable.getMessage()});
            }
        }
    }

    public void insertStok(DataStokView view) {
        Integer jml_brg;
        String kode_brg        = view.gettxtKode_brg().getText();
        Date tgl_masuk   = new Date();
        jml_brg                = Integer.parseInt(view.gettxtJml_brg().getText());
       Integer harga           = Integer.parseInt(view.gettxtHarga().getText());
        Integer jml_terjual    = 0;

        if (kode_brg.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode Stok Belum Terisi!!!");
        } else if (kode_brg.length() > 12) {
            JOptionPane.showMessageDialog(view, "Kode Stok tidak boleh lebih dari 12 karakter");
        } else if (String.valueOf(jml_brg).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah Stok Belum Terisi!!!");
        } else if (String.valueOf(jml_brg).length() > 4) {
            JOptionPane.showMessageDialog(view, "Jumlah Stok tidak boleh lebih dari 4 digit");
        }  else if (String.valueOf(jml_terjual).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah terjual Belum Terisi!!!");
        } else if (String.valueOf(jml_terjual).length() > 4) {
            JOptionPane.showMessageDialog(view, "Jumlah terjual tidak boleh lebih dari 4 digit");
        }  else {
            model.setKode_brg(kode_brg);
            model.setTgl_masuk(tgl_masuk);
            String nama_brg = null;
            model.setNama_brg(nama_brg);
            model.setJml_brg(jml_brg);
             model.setHarga(harga);
             model.setJml_terjual(jml_terjual);

            try {
                model.insertStok();
                JOptionPane.showMessageDialog(view, "Data Stok Berhasil Tersimpan!!!");
                model.resetStok();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi Kesalahan Program!!!",
                            throwable.getMessage()});
            }
        }
    }
 

   public void updateStok(DataStokView view) {

        if (view.gettblStok().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Diubah");
        } else {
        
        String kode_brg        = view.gettxtKode_brg().getText();
        Date tgl_masuk   = new Date();
        String nama_brg       = view.gettxtNama_brg().getText();
        
        Integer jml_brg        = Integer.parseInt(view.gettxtJml_brg().getText());
        
        if (kode_brg.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode Stok Belum Terisi!!!");
        } else if (kode_brg.length() > 10) {
            JOptionPane.showMessageDialog(view, "Kode Stok tidak boleh lebih dari 10 karakter");
        } else if (nama_brg.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Judul Stok Belum Terisi!!!");
        } else if (nama_brg.length() > 45) {
            JOptionPane.showMessageDialog(view, "Judul Stok tidak boleh lebih dari 45 karakter");
        } else if (String.valueOf(jml_brg).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah Stok Belum Terisi!!!");
        } else if (String.valueOf(jml_brg).length() > 4) {
            JOptionPane.showMessageDialog(view, "Jumlah Stok tidak boleh lebih dari 4 digit");
        } else {
                model.setKode_brg(kode_brg);
                model.setNama_brg(nama_brg);
                
                model.setTgl_masuk(tgl_masuk);
                model.setJml_brg(jml_brg);
                
                try {
                    model.updateStok();
                    JOptionPane.showMessageDialog(view, "Data Stok Berhasil Terupdate!!!");
                    model.resetStok();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
    public void updatePenjualan(PenjualanView view) {

        JTable tblTransaksi = view.gettblTransaksi();
        int rowCounts = tblTransaksi.getRowCount();
        String nik = view.gettxtNik().getText();

        if (rowCounts == 0) {
            JOptionPane.showMessageDialog(view, "Belum Ada Stok Yang Tersimpan");
        } else if (nik.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nik Belum Terisi!!!");
        } else if (nik.length() > 6) {
            JOptionPane.showMessageDialog(view, "Nik tidak boleh lebih dari 6 karakter");
        } else {
            for (int i = 0; i < tblTransaksi.getRowCount(); i++) {
                String Kode_brg = (String) tblTransaksi.getValueAt(i, 0);
                model.setKode_brg(Kode_brg);

                try {
                    model.updatepenjualan();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program",
                                throwable.getMessage()});
                }
            }
            JOptionPane.showMessageDialog(view, "Data Stok Berhasil Terupdate");
        }
    }
    
   

    
    public void deleteStok(DataStokView view) {

        if (view.gettblStok().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Dihapus");
        } else {

            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Stok ini?") == JOptionPane.OK_OPTION) {
                String Kode_brg = view.gettxtKode_brg().getText();
                model.setKode_brg(Kode_brg);
                try {
                    model.deleteStok();
                    JOptionPane.showMessageDialog(view, "Data Stok Berhasil Terhapus!!!");
                    model.resetStok();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
   
}
