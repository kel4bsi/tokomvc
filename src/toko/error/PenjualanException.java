/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.error;

/**
 *
 * @author mas owa
 */
public class PenjualanException extends Exception{
     public PenjualanException() {
    }

    /**
     * Constructs an instance of
     * <code>PinjamException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PenjualanException(String msg) {
        super(msg);
    }
}
