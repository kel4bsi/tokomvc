/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.controller;

import toko.model.KaryawanModel;
import toko.view.DataKaryawanView;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import toko.error.KaryawanException;
/**
 *
 * @author mas owa
 */
public class KaryawanController {
    private KaryawanModel model;

    public void setModel(KaryawanModel model) {
        this.model = model;
    }

    public void resetKaryawan(DataKaryawanView view) {
        model.resetKaryawan();
    }
    
    public void insertKaryawan(DataKaryawanView view) {

        String nik = view.gettxtNik().getText();
        String nama_karyawan = view.gettxtNama_karyawan().getText();
        String alamat = view.gettxtAlamat().getText();
        String no_telp = view.gettxtNo_telp().getText();
        String email = view.gettxtEmail().getText();
        Date tgl_daftar = new Date();
        
        
        if (nik.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Karyawan Belum Terisi!!!");
        } else if (nik.length() > 6) {
            JOptionPane.showMessageDialog(view, "ID Karyawan tidak boleh lebih dari 6 karakter");
        } else if (nama_karyawan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Karyawan Belum Terisi!!!");
        } else if (nama_karyawan.length() > 35) {
            JOptionPane.showMessageDialog(view, "Nama Karyawan tidak boleh lebih dari 35 karakter");
        } else if (alamat.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat Karyawan Belum Terisi!!!");
        } else if (alamat.length() > 75) {
            JOptionPane.showMessageDialog(view, "Alamat Karyawan tidak boleh lebih dari 75 karakter");
        } else if (no_telp.length() > 18) {
            JOptionPane.showMessageDialog(view, "Nomor no_telp tidak boleh lebih dari 18 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid!!!");
        } else if (email.length() > 25) {
            JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 25 karakter");
        } else {
            model.setNik(nik);
            model.setTgl_daftar(tgl_daftar);
            model.setNama_karyawan(nama_karyawan);
            model.setAlamat(alamat);
            model.setEmail(email);
            model.setNo_telp(no_telp);

            try {
                model.insertKaryawan();
                JOptionPane.showMessageDialog(view, "Data Karyawan Berhasil Tersimpan");
                model.resetKaryawan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi Kesalahan Program !!!",
                            throwable.getMessage()});
            }
        }
    }
 
    public void updateKaryawan(DataKaryawanView view) {

        if (view.gettblKaryawan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Diubah");
        } else {
            String nik = view.gettxtNik().getText();
            String nama_karyawan = view.gettxtNama_karyawan().getText();
            String alamat = view.gettxtAlamat().getText();
            String no_telp = view.gettxtNo_telp().getText();
            String email = view.gettxtEmail().getText();

            if (nik.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Karyawan Belum Terisi!!!");
        } else if (nik.length() > 6) {
            JOptionPane.showMessageDialog(view, "ID Karyawan tidak boleh lebih dari 6 karakter");
        } else if (nama_karyawan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Karyawan Belum Terisi!!!");
        } else if (nama_karyawan.length() > 35) {
            JOptionPane.showMessageDialog(view, "Nama Karyawan tidak boleh lebih dari 35 karakter");
        } else if (alamat.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat Karyawan Belum Terisi!!!");
        } else if (alamat.length() > 75) {
            JOptionPane.showMessageDialog(view, "Alamat Karyawan tidak boleh lebih dari 75 karakter");
        } else if (no_telp.length() > 18) {
            JOptionPane.showMessageDialog(view, "Nomor no_telp tidak boleh lebih dari 18 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid!!!");
        } else if (email.length() > 25) {
            JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 25 karakter");
            } else {
                model.setNik(nik);
                model.setNama_karyawan(nama_karyawan);
                model.setAlamat(alamat);
                model.setEmail(email);
                model.setNo_telp(no_telp);

                try {
                    model.updateKaryawan();
                    JOptionPane.showMessageDialog(view, "Data Karyawan Berhasil Terupdate");
                    model.resetKaryawan();
                } catch (SQLException | KaryawanException | HeadlessException throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program !!!",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void deleteKaryawan(DataKaryawanView view) {

        if (view.gettblKaryawan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih Record Yang Akan Dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Karyawan ini?") == JOptionPane.OK_OPTION) {
                String nik = view.gettxtNik().getText();
                model.setNik(nik);
                try {
                    model.deleteKaryawan();
                    JOptionPane.showMessageDialog(view, "Data Karyawan Berhasil Terhapus!!!");
                    model.resetKaryawan();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi Kesalahan Program !!!",
                                throwable.getMessage()});
                }
            }
        }
    }
    
}

