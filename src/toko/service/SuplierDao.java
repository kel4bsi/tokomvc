/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service;

import toko.entity.Suplier;
import toko.error.SuplierException;
import java.util.List;
/**
 *
 * @author mas owa
 */
public interface SuplierDao {
   public void insertSuplier(Suplier suplier) throws SuplierException;
    
    public void updateSuplier(Suplier suplier) throws SuplierException;
    
    public void deleteSuplier(String id_suplier) throws SuplierException;
    
    public Suplier getSuplier(String id_suplier) throws SuplierException;
    
    public int selectCount(Suplier suplier) throws SuplierException;
    
    public List<Suplier> selectAllSuplier() throws SuplierException; 
}

