/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service.impl;
import toko.entity.Admin;
import toko.error.AdminException;
import toko.service.AdminDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author mas owa
 */
public class AdminDaoImpl implements AdminDao{
     private Connection connection;
    
    private final String selectCount = "SELECT COUNT(*) FROM admin WHERE username=? AND password=?";
    
    private final String updateAdmin = "UPDATE admin SET password=? WHERE username=?";
    
    private final String getById = "SELECT * FROM admin WHERE id_admin=?";

    public AdminDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int selectCount(Admin admin) throws AdminException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectCount);
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            resultSet = statement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                rowCount = resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AdminException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        return rowCount;
    }

    @Override
    public Admin getAdmin(int id_admin) throws AdminException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id_admin);
            
            ResultSet result = statement.executeQuery();
            Admin admin = null;
            if (result.next()) {
                admin = new Admin();
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));
            } else {
                throw new AdminException("Data Admin Tidak Ada!!!");
            }
            connection.commit();
            return admin;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AdminException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
}
