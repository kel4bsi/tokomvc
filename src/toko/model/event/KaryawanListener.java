/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model.event;
import toko.entity.Karyawan;
import toko.model.KaryawanModel;
/**
 *
 * @author mas owa
 */
public interface KaryawanListener {
    public void onChange(KaryawanModel model);
    
    public void onInsert(Karyawan karyawan);
    
    public void onUpdate(Karyawan karyawan);
    
    public void onDelete();
}

