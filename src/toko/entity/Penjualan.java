/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.entity;
/**
 *
 * @author mas owa
 */
public class Penjualan {
    private String nik, kode_brg;
    private int no_penjualan, harga;

    public Penjualan() {
    }

    public Penjualan(String nik, String kode_brg, int no_penjualan, int harga) {
        this.nik = nik;
        this.kode_brg = kode_brg;
        this.no_penjualan = no_penjualan;
        this.harga = harga;
    }



    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKode_brg() {
        return kode_brg;
    }

    public void setKode_brg(String kode_brg) {
        this.kode_brg = kode_brg;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int getNo_penjualan() {
        return no_penjualan;
    }

    public void setNo_penjualan(int no_penjualan) {
        this.no_penjualan = no_penjualan;
    }
}

