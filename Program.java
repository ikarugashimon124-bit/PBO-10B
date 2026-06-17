/* Nama File    : Program.java
 * Deskripsi    : program utama untuk mensimulasikan CRUD mahasiswa
 * Pembuat      : Mutiara Ayu Pramono - 24060123140131
 * Tanggal      : 17 Juni 2026
 */

package jdbc.program;

import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;
import java.util.ArrayList;
import java.util.List;

public class Program {

    static MysqlMahasiswaService service = new MysqlMahasiswaService();

    public static void main(String[] args) {
        List<Mahasiswa> listmhs = new ArrayList<>();
        System.out.println("");

        //insert
        System.out.println("===insert");
        Mahasiswa mhsAdd = new Mahasiswa(5, "Haryo");
        service.add(mhsAdd);
        System.out.println("berhasil insert: " + mhsAdd);
        displayAll();

        //update
        System.out.println("===update");
        Mahasiswa mhsUpdate = service.getById(5);
        System.out.println("Akan diupdate data lama: " + mhsUpdate);
        mhsUpdate.setNama("Dinaya");
        System.out.println("dengan data baru: " + mhsUpdate);
        service.update(mhsUpdate);
        displayAll();

        //delete
        System.out.println("===delete");
        System.out.println("akan di delete: " + service.getById(5));
        service.delete(5);
        displayAll();
    }

    //menampilkan semua data mahasiswa ke layar
    static void displayAll() {
        List<Mahasiswa> list = service.getAll();
        System.out.println("===displayAll");
        for (Mahasiswa mhs : list) {
            System.out.println(mhs);
        }
        System.out.println("");
    }
}
