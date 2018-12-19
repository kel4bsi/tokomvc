/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service.impl;
import toko.entity.Penjualan;
import toko.error.PenjualanException;
import toko.service.PenjualanDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mas owa
 */
public class PenjualanDaoImpl implements PenjualanDao{
   private Connection connection;
    
    private final String insertPenjualan = "INSERT INTO penjualan"
            + "(nik, kode_brg,  harga)"
            + "VALUES (?,?,?)";
    
    private final String updatePenjualan = "UPDATE penjualan SET nik=?, kode_brg=?,  harga=? WHERE no_penjualan=?";
    
    private final String updatePengembalian = "UPDATE penjualan SET harga=? WHERE no_penjualan=?";
    
    private final String deletePenjualan = "DELETE FROM penjualan WHERE no_penjualan=?";
    
    private final String getByNik = "SELECT * FROM penjualan WHERE nik=? AND tgl_kembali IS NULL";
    
    private final String chartPenjualan = "SELECT date(tgl_pinjam) AS tgl_pinjam, COUNT(no_penjualan) AS transaksi, SUM(harga) AS harga FROM penjualan GROUP BY date(tgl_pinjam) LIMIT 30";
    
    private final String selectAll = "SELECT * FROM penjualan";
    
    public PenjualanDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    public void insertPenjualan(Penjualan penjualan) throws PenjualanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPenjualan);
            statement.setString(1, penjualan.getNik());
            statement.setString(2, penjualan.getKode_brg());
            statement.setInt(3, penjualan.getHarga());
            
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
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

    public void updatePenjualan(Penjualan penjualan) throws PenjualanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePenjualan);
            statement.setString(1, penjualan.getNik());
            statement.setString(2, penjualan.getKode_brg());
            statement.setInt(3, penjualan.getHarga());
            statement.setInt(4, penjualan.getNo_penjualan());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
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

    
    public void deletePenjualan(int no_penjualan) throws PenjualanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePenjualan);
            statement.setInt(1, no_penjualan);
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
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

    public List<Penjualan> getPenjualan(String nik) throws PenjualanException {
        PreparedStatement statement = null;
        List<Penjualan> list = new ArrayList<Penjualan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNik);
            statement.setString(1, nik);
            
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Penjualan penjualan = new Penjualan();
                penjualan.setNo_penjualan(result.getInt("no_penjualan"));
                penjualan.setNik(result.getString("nik"));
                penjualan.setKode_brg(result.getString("kode_brg"));
                penjualan.setHarga(result.getInt("harga"));
                list.add(penjualan);
            }
            connection.commit();
            return list;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public List<Penjualan> selectAllPenjualan() throws PenjualanException {
        Statement statement = null;
        List<Penjualan> list = new ArrayList<Penjualan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Penjualan penjualan = new Penjualan();
                penjualan.setNo_penjualan(result.getInt("no_penjualan"));
                penjualan.setNik(result.getString("nik"));
                penjualan.setKode_brg(result.getString("kode_brg"));
                penjualan.setHarga(result.getInt("harga"));
                list.add(penjualan);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
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

    @Override
    public void updatePengembalian(Penjualan penjualan) throws PenjualanException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       
}
