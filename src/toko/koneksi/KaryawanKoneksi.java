/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import toko.service.KaryawanDao;
import toko.service.impl.KaryawanDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mas owa
 */
public class KaryawanKoneksi {
    private static Connection connection;
    private static KaryawanDao karyawanDao;
    
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
    
    public static KaryawanDao getKaryawanDao() throws SQLException {
        if (karyawanDao == null) {
            karyawanDao = new KaryawanDaoImpl(getConnection());
        }
        return karyawanDao;
    }
}
