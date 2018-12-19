/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  
 package toko.model;

import toko.koneksi.StokKoneksi;
import toko.entity.Stok;
import toko.error.StokException;
import toko.model.event.StokListener;
import toko.service.StokDao;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author mas owa
 */
public class StokModel {
    private String kode_brg, nama_brg;
    private Date tgl_masuk;
    private int jml_brg,jml_terjual,harga;
    private StokListener listener;

    public String getKode_brg() {
        return kode_brg;
    }
    public void setKode_brg(String kode_brg) {
        this.kode_brg = kode_brg;
        fireOnChange();
    }
    
    public String getNama_brg() {
        return nama_brg;
    }
    public void setNama_brg(String nama_brg) {
        this.nama_brg = nama_brg;
        fireOnChange();
    }
    
    
   public Date getTgl_masuk() {
        return tgl_masuk;
    }
    public void setTgl_masuk(Date tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
        fireOnChange();
    }
    
    public int getJml_brg() {
        return jml_brg;
    }
    public void setJml_brg(int jml_brg) {
        this.jml_brg = jml_brg;
        fireOnChange();
    }
public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
        fireOnChange();
    }
    

    
      public int getJml_terjual() {
        return jml_terjual;
    }
    public void setJml_terjual(int jml_terjual) {
        this.jml_terjual = jml_terjual;
        fireOnChange();
    }
    
    public StokListener getListener() {
        return listener;
    }
    public void setListener(StokListener listener) {
        this.listener = listener;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Stok stok) {
        if (listener != null) {
            listener.onInsert(stok);
        }
    }

    protected void fireOnUpdate(Stok stok) {
        if (listener != null) {
            listener.onUpdate(stok);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void resetStok() {
        setKode_brg("");
        setNama_brg("");
        setJml_brg(0);
        setTgl_masuk(new Date());
    }
    
    public void resetpenjualan() {
        setKode_brg("");
    }

    public void getStok() throws SQLException, StokException {
        StokDao dao = StokKoneksi.getStokDao();

        fireOnInsert(dao.getStok(getKode_brg()));
    }
    
    public void insertStok() throws SQLException, StokException {
        StokDao dao = StokKoneksi.getStokDao();

        Stok stok = new Stok();
        stok.setKode_brg(kode_brg);
        stok.setNama_brg(nama_brg);
         stok.setTgl_masuk(tgl_masuk);
        stok.setJml_brg(jml_brg);
        stok.setHarga(harga);

         stok.setJml_terjual(jml_terjual);
        dao.insertStok(stok);

        fireOnInsert(stok);
    }
    
    public void updateStok() throws SQLException, StokException {
        StokDao dao = StokKoneksi.getStokDao();

        Stok stok = new Stok();
        stok.setKode_brg(kode_brg);
        stok.setNama_brg(nama_brg);
        stok.setTgl_masuk(tgl_masuk);
        stok.setJml_brg(jml_brg);
        stok.setJml_terjual(jml_terjual);
        
        dao.updateStok(stok);

        fireOnUpdate(stok);
    }
    
    public void updatePenjualan() throws SQLException, StokException {
        StokDao dao = StokKoneksi.getStokDao();

        dao.updatePenjualan(getKode_brg());
    }
    
   
    public void deleteStok() throws SQLException, StokException {
        StokDao dao = StokKoneksi.getStokDao();

        dao.deleteStok(kode_brg); 

        fireOnDelete();
    }

    public void updatepenjualan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void resetPenjualan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
   
    
    
    
    
     

       