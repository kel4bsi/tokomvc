/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import toko.service.StokDao;
import toko.service.impl.StokDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author mas owa
 */
public class StokKoneksi {
    private static Connection connection;
    private static StokDao stokDao;
    
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
    
    public static StokDao getStokDao() throws SQLException {
        if (stokDao == null) {
            stokDao = new StokDaoImpl(getConnection());
        }
        return stokDao;
    }
}
