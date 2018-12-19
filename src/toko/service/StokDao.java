/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service;

import toko.entity.Stok;
import toko.error.StokException;
import java.util.List;
/**
 *
 * @author mas owa
 */
public interface StokDao {
    public void insertStok(Stok stok) throws StokException;
    public void updateStok(Stok stok) throws StokException;
    
    public void updatePenjualan(String kode_brg) throws StokException;
    
    public void deleteStok(String kode_brg) throws StokException;
    
    public Stok getStok(String kode_brg) throws StokException;
    
     public List<Stok> selectAllStok() throws StokException;

   }

