/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import toko.service.SuplierDao;
import toko.service.impl.SuplierDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mas owa
 */
public class SuplierKoneksi {
    private static Connection connection;
    private static SuplierDao suplierDao;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/tokomvc");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static SuplierDao getSuplierDao() throws SQLException {
        if (suplierDao == null) {
            suplierDao = new SuplierDaoImpl(getConnection());
        }
        return suplierDao;
    }
}

