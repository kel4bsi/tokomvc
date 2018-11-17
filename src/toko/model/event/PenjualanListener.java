/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model.event;
import toko.entity.Penjualan;
import toko.model.PenjualanModel;
/**
 *
 * @author mas owa
 */
public interface PenjualanListener {
    public void onChange(PenjualanModel model);

    public void onInsert(Penjualan penjualan);

    public void onUpdate(Penjualan penjualan);

    public void onDelete();
}
