/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.controller;

import toko.model.SuplierModel;
import toko.view.DataSuplierView;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import toko.error.SuplierException;
/**
 *
 * @author mas owa
 */
public class SuplierController {
    private SuplierModel model;

    public void setModel(SuplierModel model) {
        this.model = model;
    }

    public void resetSuplier(DataSuplierView view) {
        model.resetSuplier();
    }
    
    public void insertSuplier(DataSuplierView view) {

        String id_suplier = view.gettxtId_suplier().getText();
        String nama_suplier = view.gettxtNama_suplier().getText();
        String alamat_suplier = view.gettxtAlamat_suplier().getText();
        String no_telp_suplier = view.gettxtNo_telp_suplier().getText();
        String email_suplier = view.gettxtEmail_suplier().getText();
        Date tgl_daftar = new Date();
        
        
        if (id_suplier.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Suplier Belum Terisi!!!");
        } else if (id_suplier.length() > 6) {
            JOptionPane.showMessageDialog(view, "ID Suplier tidak boleh lebih dari 6 karakter");
        } else if (nama_suplier.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Suplier Belum Terisi!!!");
        } else if (nama_suplier.length() > 35) {
            JOptionPane.showMessageDialog(view, "Nama Suplier tidak boleh lebih dari 35 karakter");
        } else if (alamat_suplier.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat_suplier Suplier Belum Terisi!!!");
        } else if (alamat_suplier.length() > 75) {
            JOptionPane.showMessageDialog(view, "Alamat_suplier Suplier tidak boleh lebih dari 75 karakter");
        } else if (no_telp_suplier.length() > 18) {
            JOptionPane.showMessageDialog(view, "Nomor no_telp_suplier tidak boleh lebih dari 18 digit");
        } else if (!email_suplier.contains("@") || !email_suplier.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email_suplier Tidak Valid!!!");
        } else if (email_suplier.length() > 25) {
            JOptionPane.showMessageDialog(view, "Email_suplier tidak boleh lebih dari 25 karakter");
        } else {
            model.setId_suplier(id_suplier);
            model.setNama_suplier(nama_suplier);
            model.setAlamat_suplier(alamat_suplier);
            model.setEmail_suplier(email_suplier);
            model.setNo_telp_suplier(no_telp_suplier);

            try {
                model.insertSuplier();
                JOptionPane.showMessageDialog(view, "Data Suplier Berhasil Tersimpan");
                model.resetSuplier();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi Kesalahan Program !!!",
                            throwable.getMessage()});
            }
        }
    }
 
    public void updateSuplier(DataSuplierView view) {

        if (view.gettblSuplier().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Diubah");
        } else {
            String id_suplier = view.gettxtId_suplier().getText();
            String nama_suplier = view.gettxtNama_suplier().getText();
            String alamat_suplier = view.gettxtAlamat_suplier().getText();
            String no_telp_suplier = view.gettxtNo_telp_suplier().getText();
            String email_suplier = view.gettxtEmail_suplier().getText();

            if (id_suplier.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Suplier Belum Terisi!!!");
        } else if (id_suplier.length() > 6) {
            JOptionPane.showMessageDialog(view, "ID Suplier tidak boleh lebih dari 6 karakter");
        } else if (nama_suplier.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Suplier Belum Terisi!!!");
        } else if (nama_suplier.length() > 35) {
            JOptionPane.showMessageDialog(view, "Nama Suplier tidak boleh lebih dari 35 karakter");
        } else if (alamat_suplier.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat_suplier Suplier Belum Terisi!!!");
        } else if (alamat_suplier.length() > 75) {
            JOptionPane.showMessageDialog(view, "Alamat_suplier Suplier tidak boleh lebih dari 75 karakter");
        } else if (no_telp_suplier.length() > 18) {
            JOptionPane.showMessageDialog(view, "Nomor no_telp_suplier tidak boleh lebih dari 18 digit");
        } else if (!email_suplier.contains("@") || !email_suplier.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email_suplier Tidak Valid!!!");
        } else if (email_suplier.length() > 25) {
            JOptionPane.showMessageDialog(view, "Email_suplier tidak boleh lebih dari 25 karakter");
            } else {
                model.setId_suplier(id_suplier);
                model.setNama_suplier(nama_suplier);
                model.setAlamat_suplier(alamat_suplier);
                model.setEmail_suplier(email_suplier);
                model.setNo_telp_suplier(no_telp_suplier);

                try {
                    model.updateSuplier();
                    JOptionPane.showMessageDialog(view, "Data Suplier Berhasil Terupdate");
                    model.resetSuplier();
                } catch (SQLException | SuplierException | HeadlessException throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program !!!",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void deleteSuplier(DataSuplierView view) {

        if (view.gettblSuplier().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Suplier ini?") == JOptionPane.OK_OPTION) {
                String id_suplier = view.gettxtId_suplier().getText();
                model.setId_suplier(id_suplier);
                try {
                    model.deleteSuplier();
                    JOptionPane.showMessageDialog(view, "Data Suplier Berhasil Terhapus!!!");
                    model.resetSuplier();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program !!!",
                                throwable.getMessage()});
                }
            }
        }
    }
    
}

