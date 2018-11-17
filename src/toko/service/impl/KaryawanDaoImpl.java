/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.service.impl;
import toko.entity.Karyawan;
import toko.error.KaryawanException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import toko.service.KaryawanDao;
/**
 *
 * @author mas owa
 */
public class KaryawanDaoImpl implements KaryawanDao {
    private final Connection connection;
    
    private final String insertKaryawan = "INSERT INTO karyawan"
            + "(nik, nama_karyawan, alamat, no_telp, email, tgl_daftar)"
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updateKaryawan = "UPDATE karyawan SET nama_karyawan=?, alamat=?, no_telp=?, email=? WHERE nik=?";
    
    private final String deleteKaryawan = "DELETE FROM karyawan WHERE nik=?";
    
    private final String getById = "SELECT * FROM karyawan WHERE nik=?";
    
    private final String selectAll = "SELECT * FROM karyawan";
    
    private final String selectCount = "SELECT COUNT(*) FROM karyawan WHERE nik = ?";

    public KaryawanDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insertKaryawan(Karyawan karyawan) throws KaryawanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertKaryawan);
            statement.setString(1, karyawan.getNik());
            statement.setString(2, karyawan.getNama_karyawan());
            statement.setString(3, karyawan.getAlamat());
            statement.setString(4, karyawan.getNo_telp());
            statement.setString(5, karyawan.getEmail());
            statement.setDate(6, new Date(karyawan.getTgl_daftar().getTime()));
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new KaryawanException(exception.getMessage());
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

    public void updateKaryawan(Karyawan karyawan) throws KaryawanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateKaryawan);
            statement.setString(1, karyawan.getNama_karyawan());
            statement.setString(2, karyawan.getAlamat());
            statement.setString(3, karyawan.getNo_telp());
            statement.setString(4, karyawan.getEmail());
            statement.setString(5, karyawan.getNik());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new KaryawanException(exception.getMessage());
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

    public void deleteKaryawan(String nik) throws KaryawanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteKaryawan);
            statement.setString(1, nik);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new KaryawanException(exception.getMessage());
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

    public Karyawan getKaryawan(String nik) throws KaryawanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, nik);
            
            ResultSet result = statement.executeQuery();
            Karyawan karyawan = null;
            if (result.next()) {
                karyawan = new Karyawan();
                karyawan.setNama_karyawan(result.getString("nama_karyawan"));
                karyawan.setAlamat(result.getString("alamat"));
                karyawan.setNo_telp(result.getString("no_telp"));
                karyawan.setEmail(result.getString("email"));
            } else {
                throw new KaryawanException("Data Karyawan Tidak Ada!!!");
            }
            connection.commit();
            return karyawan;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new KaryawanException(exception.getMessage());
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
    
    public List<Karyawan> selectAllKaryawan() throws KaryawanException {
        Statement statement = null;
        List<Karyawan> list = new ArrayList<Karyawan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setNik(result.getString("nik"));
                karyawan.setNama_karyawan(result.getString("nama_karyawan"));
                karyawan.setAlamat(result.getString("alamat"));
                karyawan.setNo_telp(result.getString("no_telp"));
                karyawan.setEmail(result.getString("email"));
                karyawan.setTgl_daftar(result.getDate("tgl_daftar"));
                
                list.add(karyawan);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new KaryawanException(exception.getMessage());
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

    public int selectCount(Karyawan karyawan) throws KaryawanException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectCount);
            statement.setString(1, karyawan.getNik());
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
            throw new KaryawanException(exception.getMessage());
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

