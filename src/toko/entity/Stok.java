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
public class Stok {
    private String kode_brg, nama_brg;
    private int jml_brg, harga;
    private Date tgl_masuk;
   
    public Stok() {
    }

    public Stok(String kode_brg, String nama_brg,
                int jml_brg, int harga, Date tgl_masuk) {
        this.kode_brg = kode_brg;
        this.nama_brg = nama_brg;
         this.jml_brg = jml_brg;
        this.harga = harga;
      this.tgl_masuk = tgl_masuk;
    }

    public String getKode_brg() {
        return kode_brg;
    }
    public void setKode_brg(String kode_brg) {
        this.kode_brg = kode_brg;
    }
    
    public String getNama_brg() {
        return nama_brg;
    }
    public void setNama_brg(String nama_brg) {
        this.nama_brg = nama_brg;
    }
    
    
    public Date getTgl_masuk() {
        return tgl_masuk;
    }
    public void setTgl_masuk(Date tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }
        
    public int getJml_brg() {
        return jml_brg;
    }
    public void setJml_brg(int jml_brg) {
        this.jml_brg = jml_brg;
    }

    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
    


}
