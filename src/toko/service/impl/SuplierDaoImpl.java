/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service.impl;
import toko.entity.Suplier;
import toko.error.SuplierException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import toko.service.SuplierDao;
/**
 *
 * @author mas owa
 */
public class SuplierDaoImpl implements SuplierDao {
    private final Connection connection;
    
    private final String insertSuplier = "INSERT INTO suplier"
            + "(id_suplier, nama_suplier, alamat_suplier, no_telp_suplier, email_suplier)"
            + "VALUES (?,?,?,?,?)";
    
    private final String updateSuplier = "UPDATE suplier SET nama_suplier=?, alamat_suplier=?, no_telp_suplier=?, email_suplier=? WHERE id_suplier=?";
    
    private final String deleteSuplier = "DELETE FROM suplier WHERE id_suplier=?";
    
    private final String getById = "SELECT * FROM suplier WHERE id_suplier=?";
    
    private final String selectAll = "SELECT * FROM suplier";
    
    private final String selectCount = "SELECT COUNT(*) FROM suplier WHERE id_suplier = ?";

    public SuplierDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insertSuplier(Suplier suplier) throws SuplierException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertSuplier);
            statement.setString(1, suplier.getId_suplier());
            statement.setString(2, suplier.getNama_suplier());
            statement.setString(3, suplier.getAlamat_suplier());
            statement.setString(4, suplier.getNo_telp_suplier());
            statement.setString(5, suplier.getEmail_suplier());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new SuplierException(exception.getMessage());
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

    public void updateSuplier(Suplier suplier) throws SuplierException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateSuplier);
            statement.setString(1, suplier.getNama_suplier());
            statement.setString(2, suplier.getAlamat_suplier());
            statement.setString(3, suplier.getNo_telp_suplier());
            statement.setString(4, suplier.getEmail_suplier());
            statement.setString(5, suplier.getId_suplier());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new SuplierException(exception.getMessage());
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

    public void deleteSuplier(String id_suplier) throws SuplierException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteSuplier);
            statement.setString(1, id_suplier);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new SuplierException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public Suplier getSuplier(String id_suplier) throws SuplierException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id_suplier);
            
            ResultSet result = statement.executeQuery();
            Suplier suplier = null;
            if (result.next()) {
                suplier = new Suplier();
                suplier.setNama_suplier(result.getString("nama_suplier"));
                suplier.setAlamat_suplier(result.getString("alamat_suplier"));
                suplier.setNo_telp_suplier(result.getString("no_telp_suplier"));
                suplier.setEmail_suplier(result.getString("email_suplier"));
            } else {
                throw new SuplierException("Data Suplier Tidak Ada!!!");
            }
            connection.commit();
            return suplier;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new SuplierException(exception.getMessage());
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
    
    public List<Suplier> selectAllSuplier() throws SuplierException {
        Statement statement = null;
        List<Suplier> list = new ArrayList<Suplier>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Suplier suplier = new Suplier();
                suplier.setId_suplier(result.getString("id_suplier"));
                suplier.setNama_suplier(result.getString("nama_suplier"));
                suplier.setAlamat_suplier(result.getString("alamat_suplier"));
                suplier.setNo_telp_suplier(result.getString("no_telp_suplier"));
                suplier.setEmail_suplier(result.getString("email_suplier"));
                                
                list.add(suplier);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new SuplierException(exception.getMessage());
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

    public int selectCount(Suplier suplier) throws SuplierException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectCount);
            statement.setString(1, suplier.getId_suplier());
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
            throw new SuplierException(exception.getMessage());
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
}

