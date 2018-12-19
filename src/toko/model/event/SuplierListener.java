/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model.event;
import toko.entity.Suplier;
import toko.model.SuplierModel;
/**
 *
 * @author mas owa
 */
public interface SuplierListener {
    public void onChange(SuplierModel model);
    
    public void onInsert(Suplier suplier);
    
    public void onUpdate(Suplier suplier);
    
    public void onDelete();
}

