/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;
import toko.koneksi.KaryawanKoneksi;
import toko.entity.Karyawan;
import toko.error.KaryawanException;
import toko.model.event.KaryawanListener;
import java.sql.SQLException;
import java.util.Date;
import toko.service.KaryawanDao;
/**
 *
 * @author mas owa
 */
public class KaryawanModel {
    private String nik, nama_karyawan, alamat, no_telp, email;
    private Date tgl_daftar;
    
    private KaryawanListener listener;

    public KaryawanListener getListener() {
        return listener;
    }
    public void setListener(KaryawanListener listener) {
        this.listener = listener;
    }
            
    public String getNik() {
        return nik;
    }
    public void setNik(String nik) {
        this.nik = nik;
        fireOnChange();
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }
    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
        fireOnChange();
    }
    
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    public String getNo_telp() {
        return no_telp;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
        fireOnChange();
    }
    
    public Date getTgl_daftar() {
        return tgl_daftar;
    }
    public void setTgl_daftar(Date tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Karyawan karyawan) {
        if (listener != null) {
            listener.onInsert(karyawan);
        }
    }
    
    protected void fireOnUpdate(Karyawan karyawan) {
        if (listener != null) {
            listener.onUpdate(karyawan);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetKaryawan() {
        setNik("");
        setNama_karyawan("");
        setAlamat("");
        setNo_telp("");
        setEmail("");
        setTgl_daftar(new Date());
    }
    
    public void insertKaryawan() throws SQLException, KaryawanException {
        KaryawanDao dao = KaryawanKoneksi.getKaryawanDao();
        
        Karyawan karyawan = new Karyawan();
        karyawan.setNik(nik);
        karyawan.setNama_karyawan(nama_karyawan);
        karyawan.setAlamat(alamat);
        karyawan.setNo_telp(no_telp);
        karyawan.setEmail(email);
        karyawan.setTgl_daftar(tgl_daftar);
        
        dao.insertKaryawan(karyawan);
        
        fireOnInsert(karyawan);
    }
    
    public void updateKaryawan() throws SQLException, KaryawanException {
        KaryawanDao dao = KaryawanKoneksi.getKaryawanDao();
        Karyawan karyawan = new Karyawan();
        karyawan.setNik(nik);
        karyawan.setNama_karyawan(nama_karyawan);
        karyawan.setAlamat(alamat);
        karyawan.setNo_telp(no_telp);
        karyawan.setEmail(email);
        karyawan.setTgl_daftar(tgl_daftar);
        dao.updateKaryawan(karyawan);
        
        fireOnUpdate(karyawan);
    }
    
    public void deleteKaryawan() throws SQLException, KaryawanException {
        KaryawanDao dao = KaryawanKoneksi.getKaryawanDao();
        
        dao.deleteKaryawan(nik);
        
        fireOnDelete();
    }
}

