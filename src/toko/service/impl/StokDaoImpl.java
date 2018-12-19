/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service.impl;
import toko.entity.Stok;
import toko.error.StokException;
import toko.service.StokDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mas owa
 */
public class StokDaoImpl implements StokDao {
    private Connection connection;
    
    private final String insertStok = "INSERT INTO stok"
            + "(kode_brg, nama_brg, harga, tgl_masuk, jml_brg, jml_terjual)"
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updateStok = "UPDATE stok SET nama_brg=?, harga=?, jml_brg=?, jml_terjual=? WHERE kode_brg=?";
    
    private final String updatePenjualan = "UPDATE stok SET jml_brg=jml_brg-1, jml_terjual=jml_terjual+1 WHERE kode_brg=?";
    
        
    private final String deleteStok = "DELETE FROM stok WHERE kode_brg=?";
    
       
    private final String getById = "SELECT * FROM stok WHERE kode_brg=?";
    
    private final String selectAll = "SELECT * FROM stok";
    
    public StokDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertStok(Stok stok) throws StokException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertStok);
            statement.setString(1, stok.getKode_brg());
            statement.setString(2, stok.getNama_brg());
            statement. setInt (3, stok.getHarga());
             statement.setDate(4, new Date(stok.getTgl_masuk().getTime()));
            statement.setInt(5, stok.getJml_brg());
             statement.setInt(6, stok.getJml_terjual());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new StokException(exception.getMessage());
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
    public void updateStok(Stok stok) throws StokException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateStok);
            statement.setString(1, stok.getNama_brg());
            statement. setInt (2, stok.getHarga());
             statement.setInt(3, stok.getJml_brg());
            statement.setString(4, stok.getKode_brg());
            statement.setInt(5, stok.getJml_terjual());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new StokException(exception.getMessage());
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
    
    public void updatePenjualan(String kode_brg) throws StokException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePenjualan);
            statement.setString(1, kode_brg);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new StokException(exception.getMessage());
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
    public void deleteStok(String kode_brg) throws StokException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteStok);
            statement.setString(1, kode_brg);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new StokException(exception.getMessage());
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
    public Stok getStok(String kode_brg) throws StokException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, kode_brg);
            
            ResultSet result = statement.executeQuery();
            Stok stok = null;
            if (result.next()) {
                stok = new Stok();
                stok.setNama_brg(result.getString("nama_brg"));
                stok.setHarga(result.getInt("harga"));
                stok.setTgl_masuk(result.getDate("tgl_masuk"));
                stok.setJml_brg(result.getInt("jml_brg"));
                stok.setJml_terjual(result.getInt("jml_terjual"));
                 } else {
                throw new StokException("Data Stok Tidak Ada!!!");
            }
            connection.commit();
            return stok;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new StokException(exception.getMessage());
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
    public List<Stok> selectAllStok() throws StokException {
        Statement statement = null;
        List<Stok> list = new ArrayList<Stok>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Stok stok = new Stok();
                stok.setKode_brg(result.getString("kode_brg"));
                stok.setNama_brg(result.getString("nama_brg"));
                stok.setHarga(result.getInt("harga"));
                stok.setTgl_masuk(result.getDate("tgl_masuk"));
                stok.setJml_brg(result.getInt("jml_brg"));
                stok.setJml_terjual(result.getInt("jml_terjual"));
                                list.add(stok);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new StokException(exception.getMessage());
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

    public void updatePinjamStok(String kode_brg) throws StokException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updatePengembalian(String kode_brg) throws StokException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Stok> top10StokFavorit() throws StokException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Stok> top10StokBaru() throws StokException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
