/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;

import toko.koneksi.PenjualanKoneksi;
import toko.entity.Penjualan;
import toko.error.PenjualanException;
import toko.model.event.PenjualanListener;
import toko.service.PenjualanDao;
import java.sql.SQLException;

/**
 *
 * @author mas owa
 */
public class PenjualanModel {
    private String nik, kode_brg;
    private int no_penjualan, harga;
    private PenjualanListener listener;

    public PenjualanListener getListener() {
        return listener;
    }

    public void setListener(PenjualanListener listener) {
        this.listener = listener;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
        fireOnChange();
    }

    public String getKode_brg() {
        return kode_brg;
    }

    public void setKode_brg(String kode_brg) {
        this.kode_brg = kode_brg;
        fireOnChange();
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
        fireOnChange();
    }

    public int getNo_penjualan() {
        return no_penjualan;
    }

    public void setNo_penjualan(int no_penjualan) {
        this.no_penjualan = no_penjualan;
        fireOnChange();
    }


    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Penjualan penjualan) {
        if (listener != null) {
            listener.onInsert(penjualan);
        }
    }

    protected void fireOnUpdate(Penjualan penjualan) {
        if (listener != null) {
            listener.onUpdate(penjualan);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void resetPenjualanKasir() {
        setNik("");
    }

    public void resetPenjualan() {
        setNo_penjualan(0);
        setNik("");
        setKode_brg("");
         setHarga(0);
    }

    public void insertPenjualan() throws SQLException, PenjualanException {
        PenjualanDao dao = PenjualanKoneksi.getPenjualanDao();

        Penjualan penjualan = new Penjualan();
        penjualan.setNik(nik);
        penjualan.setKode_brg(kode_brg);
         penjualan.setHarga(harga);
       dao.insertPenjualan(penjualan);
    }
    
    public void updatePenjualan() throws SQLException, PenjualanException {
        PenjualanDao dao = PenjualanKoneksi.getPenjualanDao();

        Penjualan penjualan = new Penjualan();
        penjualan.setNo_penjualan(no_penjualan);
        penjualan.setNik(nik);
        penjualan.setKode_brg(kode_brg);
        penjualan.setHarga(harga);
        dao.updatePenjualan(penjualan);

        fireOnUpdate(penjualan);
    }


    public void deletePenjualan() throws SQLException, PenjualanException {
        PenjualanDao dao = PenjualanKoneksi.getPenjualanDao();

        dao.deletePenjualan(no_penjualan);

        fireOnDelete();
    }
}

