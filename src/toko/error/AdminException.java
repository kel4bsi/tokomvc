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
public class AdminException extends Exception{
    /**
     * Creates a new instance of
     * <code>AdminException</code> without detail message.
     */
    public AdminException() {
    }

    /**
     * Constructs an instance of
     * <code>AdminException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public AdminException(String msg) {
        super(msg);
    }
}
