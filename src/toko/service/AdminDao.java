/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service;

import toko.entity.Admin;
import toko.error.AdminException;
/**
 *
 * @author mas owa
 */
public interface AdminDao {
    public int selectCount(Admin admin) throws AdminException;
    
    public Admin getAdmin(int id_admin) throws AdminException;
}

