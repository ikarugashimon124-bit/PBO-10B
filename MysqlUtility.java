/* Nama File    : MysqlUtility.java
 * Deskripsi    : kelas untuk mengelola koneksi dengan basis data MySQL
 * Pembuat      : Mutiara Ayu Pramono - 24060123140131
 * Tanggal      : 17 Juni 2026
 */

package jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtility {

    /******************ATRIBUT*****************/
    private static Connection koneksi;

    /******************METHOD******************/
    //mengembalikan koneksi ke database, membuat baru jika belum ada
    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //sesuaikan host, port, nama db
                String url = "jdbc:mysql://localhost:3306/jdbc_mhs?useSSL=false&serverTimezone=UTC";
                //sesuaikan username dan password
                String user = "root";
                String password = "";
                koneksi = DriverManager.getConnection(url, user, password);
                if (koneksi != null) {
                    System.out.println("Koneksi berhasil");
                }
            } catch (ClassNotFoundException cne) {
                System.out.println("Gagal load driver : " + cne.getMessage());
            } catch (SQLException sqle) {
                System.out.println("Gagal Koneksi : " + sqle.getMessage());
            }
        }
        return koneksi;
    }
}
