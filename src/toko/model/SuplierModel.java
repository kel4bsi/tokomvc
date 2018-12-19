/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;
import toko.koneksi.SuplierKoneksi;
import toko.entity.Suplier;
import toko.error.SuplierException;
import toko.model.event.SuplierListener;
import java.sql.SQLException;
import toko.service.SuplierDao;
/**
 *
 * @author mas owa
 */
public class SuplierModel {
    private String id_suplier, nama_suplier, alamat_suplier, no_telp_suplier, email_suplier;
    private SuplierListener listener;

    public SuplierListener getListener() {
        return listener;
    }
    public void setListener(SuplierListener listener) {
        this.listener = listener;
    }
            
    public String getId_suplier() {
        return id_suplier;
    }
    public void setId_suplier(String id_suplier) {
        this.id_suplier = id_suplier;
        fireOnChange();
    }

    public String getNama_suplier() {
        return nama_suplier;
    }
    public void setNama_suplier(String nama_suplier) {
        this.nama_suplier = nama_suplier;
        fireOnChange();
    }
    
    public String getAlamat_suplier() {
        return alamat_suplier;
    }
    public void setAlamat_suplier(String alamat_suplier) {
        this.alamat_suplier = alamat_suplier;
        fireOnChange();
    }

    public String getEmail_suplier() {
        return email_suplier;
    }
    public void setEmail_suplier(String email_suplier) {
        this.email_suplier = email_suplier;
        fireOnChange();
    }
    
    public String getNo_telp_suplier() {
        return no_telp_suplier;
    }
    public void setNo_telp_suplier(String no_telp_suplier) {
        this.no_telp_suplier = no_telp_suplier;
        fireOnChange();
    }
    
 protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Suplier suplier) {
        if (listener != null) {
            listener.onInsert(suplier);
        }
    }
    
    protected void fireOnUpdate(Suplier suplier) {
        if (listener != null) {
            listener.onUpdate(suplier);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetSuplier() {
        setId_suplier("");
        setNama_suplier("");
        setAlamat_suplier("");
        setNo_telp_suplier("");
        setEmail_suplier("");
    }
    
    public void insertSuplier() throws SQLException, SuplierException {
        SuplierDao dao = SuplierKoneksi.getSuplierDao();
        
        Suplier suplier = new Suplier();
        suplier.setId_suplier(id_suplier);
        suplier.setNama_suplier(nama_suplier);
        suplier.setAlamat_suplier(alamat_suplier);
        suplier.setNo_telp_suplier(no_telp_suplier);
        suplier.setEmail_suplier(email_suplier);
        dao.insertSuplier(suplier);
        
        fireOnInsert(suplier);
    }
    
    public void updateSuplier() throws SQLException, SuplierException {
        SuplierDao dao = SuplierKoneksi.getSuplierDao();
        Suplier suplier = new Suplier();
        suplier.setId_suplier(id_suplier);
        suplier.setNama_suplier(nama_suplier);
        suplier.setAlamat_suplier(alamat_suplier);
        suplier.setNo_telp_suplier(no_telp_suplier);
        suplier.setEmail_suplier(email_suplier);
        dao.updateSuplier(suplier);
        
        fireOnUpdate(suplier);
    }
    
    public void deleteSuplier() throws SQLException, SuplierException {
        SuplierDao dao = SuplierKoneksi.getSuplierDao();
        
        dao.deleteSuplier(id_suplier);
        
        fireOnDelete();
    }

   
}

