/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model.event;
import toko.entity.Stok;
import toko.model.StokModel;

/**
 *
 * @author mas owa
 */
public interface StokListener {
    public void onChange(StokModel model);

    public void onInsert(Stok stok);

    public void onUpdate(Stok stok);

    public void onDelete();
}

