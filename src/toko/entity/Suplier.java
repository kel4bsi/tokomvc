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
public class Suplier {
    
    private String id_suplier, nama_suplier, alamat_suplier, no_telp_suplier, email_suplier;
    
    public Suplier(){
    }
    
    public Suplier(String id_suplier, String nama_suplier, String alamat_suplier, String no_telp_suplier, String email_suplier) {
        this.id_suplier = id_suplier;
        this.nama_suplier = nama_suplier;
        this.alamat_suplier = alamat_suplier;
        this.no_telp_suplier = no_telp_suplier;
        this.email_suplier = email_suplier;
            }

    public String getId_suplier() {
        return id_suplier;
    }
    public void setId_suplier(String id_suplier) {
        this.id_suplier = id_suplier;
    }
    
    public String getNama_suplier() {
        return nama_suplier;
    }
    public void setNama_suplier(String nama_suplier) {
        this.nama_suplier = nama_suplier;
    }
    
    public String getAlamat_suplier() {
        return alamat_suplier;
    }
    public void setAlamat_suplier(String alamat_suplier) {
        this.alamat_suplier = alamat_suplier;
    }
    
    public String getNo_telp_suplier() {
        return no_telp_suplier;
    }
    public void setNo_telp_suplier(String no_telp_suplier) {
        this.no_telp_suplier = no_telp_suplier;
    }
    
    public String getEmail_suplier() {
        return email_suplier;
    }
    public void setEmail_suplier(String email_suplier) {
        this.email_suplier = email_suplier;
    }
}
