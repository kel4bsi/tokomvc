/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service;

import toko.entity.Karyawan;
import toko.error.KaryawanException;
import java.util.List;
/**
 *
 * @author mas owa
 */
public interface KaryawanDao {
   public void insertKaryawan(Karyawan karyawan) throws KaryawanException;
    
    public void updateKaryawan(Karyawan karyawan) throws KaryawanException;
    
    public void deleteKaryawan(String nik) throws KaryawanException;
    
    public Karyawan getKaryawan(String nik) throws KaryawanException;
    
    public int selectCount(Karyawan karyawan) throws KaryawanException;
    
    public List<Karyawan> selectAllKaryawan() throws KaryawanException; 
}

