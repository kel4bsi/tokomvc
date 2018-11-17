/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.entity;
import java.util.Date;

/**
 *
 * @author mas owa
 */
public class Karyawan {
    
    private String nik, nama_karyawan, alamat, no_telp, email;
    private Date tgl_daftar;

    public Karyawan(){
    }
    
    public Karyawan(String nik, String nama_karyawan, String alamat, String no_telp, String email, Date tgl_daftar) {
        this.nik = nik;
        this.nama_karyawan = nama_karyawan;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.email = email;
        this.tgl_daftar = tgl_daftar;
    }

    public String getNik() {
        return nik;
    }
    public void setNik(String nik) {
        this.nik = nik;
    }
    
    public String getNama_karyawan() {
        return nama_karyawan;
    }
    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }
    
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getNo_telp() {
        return no_telp;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getTgl_daftar() {
        return tgl_daftar;
    }
    public void setTgl_daftar(Date tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }
    
}
