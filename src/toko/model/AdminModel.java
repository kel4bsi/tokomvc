/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;

/**
 *
 * @author mas owa
 */

public class AdminModel {
    private int id_admin;
    private String username, password;

    public int getId_admin() {
        return id_admin;
    }
    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String Username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
