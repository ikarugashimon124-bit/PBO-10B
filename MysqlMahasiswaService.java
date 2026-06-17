/* Nama File    : MysqlMahasiswaService.java
 * Deskripsi    : service untuk mengelola operasi CRUD tabel mahasiswa
 * Pembuat      : Mutiara Ayu Pramono - 24060123140131
 * Tanggal      : 17 Juni 2026
 */

package jdbc.service;

import jdbc.model.Mahasiswa;
import jdbc.utilities.MysqlUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlMahasiswaService {

    /******************ATRIBUT*****************/
    Connection koneksi = null;

    /******************METHOD******************/
    //konstruktor mengambil koneksi dari MysqlUtility
    public MysqlMahasiswaService() {
        koneksi = MysqlUtility.getConnection();
    }

    //membuat objek mahasiswa baru kosong
    public Mahasiswa makeMhsObject() {
        return new Mahasiswa();
    }

    //menambahkan data mahasiswa ke database
    public void add(Mahasiswa mhs) {
        try {
            String query = "INSERT INTO mahasiswa(id, nama) VALUES(?, ?)";
            PreparedStatement ps = koneksi.prepareStatement(query);
            ps.setInt(1, mhs.getId());
            ps.setString(2, mhs.getNama());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Gagal insert : " + sqle.getMessage());
        }
    }

    //mengupdate data mahasiswa di database berdasarkan id
    public void update(Mahasiswa mhs) {
        try {
            String query = "UPDATE mahasiswa SET nama=? WHERE id=?";
            PreparedStatement ps = koneksi.prepareStatement(query);
            ps.setString(1, mhs.getNama());
            ps.setInt(2, mhs.getId());
            ps.executeUpdate();
            System.out.println("Berhasil update");
        } catch (SQLException sqle) {
            System.out.println("Gagal update : " + sqle.getMessage());
        }
    }

    //menghapus data mahasiswa dari database berdasarkan id
    public void delete(int id) {
        try {
            String query = "DELETE FROM mahasiswa WHERE id=?";
            PreparedStatement ps = koneksi.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Berhasil delete");
        } catch (SQLException sqle) {
            System.out.println("Gagal delete : " + sqle.getMessage());
        }
    }

    //mengambil data mahasiswa dari database berdasarkan id
    public Mahasiswa getById(int id) {
        Mahasiswa mhs = null;
        try {
            String query = "SELECT * FROM mahasiswa WHERE id=?";
            PreparedStatement ps = koneksi.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mhs = new Mahasiswa();
                mhs.setId(rs.getInt("id"));
                mhs.setNama(rs.getString("nama"));
            }
        } catch (SQLException sqle) {
            System.out.println("Gagal getById : " + sqle.getMessage());
        }
        return mhs;
    }

    //mengambil semua data mahasiswa dari database
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> listmhs = new ArrayList<>();
        try {
            String query = "SELECT * FROM mahasiswa";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setId(rs.getInt("id"));
                mhs.setNama(rs.getString("nama"));
                listmhs.add(mhs);
            }
        } catch (SQLException sqle) {
            System.out.println("Gagal getAll : " + sqle.getMessage());
        }
        return listmhs;
    }
}
