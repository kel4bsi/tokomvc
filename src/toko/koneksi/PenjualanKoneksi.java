/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import toko.service.PenjualanDao;
import toko.service.impl.PenjualanDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mas owa
 */
public class PenjualanKoneksi {
    private static Connection connection;
    private static PenjualanDao penjualanDao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/tokomvc");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static PenjualanDao getPenjualanDao() throws SQLException {
        if (penjualanDao == null) {
            penjualanDao = new PenjualanDaoImpl(getConnection());
        }
        return penjualanDao;
    }
}
