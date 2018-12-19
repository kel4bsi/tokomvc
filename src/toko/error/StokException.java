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
public class StokException extends Exception {
    /**
     * Creates a new instance of
     * <code>StokException</code> without detail message.
     */
    public StokException() {
    }

    /**
     * Constructs an instance of
     * <code>StokException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public StokException(String msg) {
        super(msg);
    }
}
