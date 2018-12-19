/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.controller;

import java.sql.SQLException;
import toko.model.PenjualanModel;
import toko.view.PenjualanView;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import toko.error.PenjualanException;
/**
 *
 * @author mas owa
 */
public class PenjualanController {
    private PenjualanModel model;

    public void setModel(PenjualanModel model) {
        this.model = model;
    }

    public void resetPenjualan(PenjualanView view) {
        model.resetPenjualan();
    }

    public boolean insertPenjualan(PenjualanView view) {

        JTable tblTransaksi = view.gettblTransaksi();
        
        String nik = view.gettxtNik().getText();
        Integer harga = 0;

        if (nik.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nik Belum Terisi!!!");
        } else if (nik.length() > 6) {
            JOptionPane.showMessageDialog(view, "Nik tidak boleh lebih dari 6 karakter");
        } else if (tblTransaksi.getRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Belum Ada Barang Yang Dipilih!!!");
        } else {
            for (int i = 0; i < tblTransaksi.getRowCount(); i++) {
                model.setNik(nik);
                model.setKode_brg((String) tblTransaksi.getValueAt(i, 0));
                model.setHarga(harga);

                try {
                    model.insertPenjualan();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Pada Program!!!",
                                throwable.getMessage()});
                }
            }
            return true;
        }
        return false;
    }

  /*  public void updatePenjualan(PenjualanView view) {

        if (view.gettblTransaksi().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Diupdate");
        } else {
            Integer no_penjualan = Integer.parseInt(view.get.gettxtNo_penjualan().getText());
            String nik = view.gettxtNik().getText();
            String kode_brg = view.gettxtKode_brg().getText();
            Integer harga = Integer.parseInt(view.getInputHarga().getText());

           if (nik.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nik Belum Terisi!!!");
        } else if (nik.length() > 6) {
            JOptionPane.showMessageDialog(view, "Nik tidak boleh lebih dari 6 karakter");
        } else if (tblTransaksi.getRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Belum Ada Buku Yang Dipilih!!!");
        } else {
                model.setNo_penjualan(no_penjualan);
                model.setKode_brg(kode_brg);
                model.setNik(nik);
                model.setHarga(harga);

                try {
                    model.updatePenjualan();
                    JOptionPane.showMessageDialog(view, "Data Penjualan berhasil diubah");
                    model.resetPenjualan();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
*/
    
   /* 
    public void deletePenjualan(PenjualanView view) {
        if (view.gettblTransaksi().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda Yakin Batal Meminjam Buku Ini?") == JOptionPane.OK_OPTION) {
                Integer no_penjualan = Integer.parseInt(view.gettxtNo_penjualan().getText());
                model.setNo_penjualan(no_penjualan);
                try {
                    model.deletePenjualan();
                    JOptionPane.showMessageDialog(view, "Data Penjualan berhasil dihapus");
                    model.resetPenjualan();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }*/
}

