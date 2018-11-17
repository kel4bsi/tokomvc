/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service;
import toko.entity.Penjualan;
import toko.error.PenjualanException;
import java.util.List;
/**
 *
 * @author 
 */
public interface PenjualanDao {
    public void insertPenjualan(Penjualan penjualan) throws PenjualanException;
    
    public void updatePenjualan(Penjualan penjualan) throws PenjualanException;
    
    public void updatePengembalian(Penjualan penjualan) throws PenjualanException;
    
    public void deletePenjualan(int no_penjualan) throws PenjualanException;
    
    public List<Penjualan> getPenjualan(String id_member) throws PenjualanException;
    
         
}
