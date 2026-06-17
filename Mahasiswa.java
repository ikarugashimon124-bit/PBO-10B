/* Nama File    : Mahasiswa.java
 * Deskripsi    : persistent object sebagai model bagi tabel mahasiswa
 * Pembuat      : Mutiara Ayu Pramono - 24060123140131
 * Tanggal      : 17 Juni 2026
 */

package jdbc.model;

public class Mahasiswa {

    /******************ATRIBUT*****************/
    private int id;
    private String nama;

    /******************METHOD******************/
    //konstruktor default
    public Mahasiswa() {
    }

    //konstruktor dengan id dan nama
    public Mahasiswa(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    //mengembalikan nilai id
    public int getId() {
        return id;
    }

    //mengeset nilai id
    public void setId(int id) {
        this.id = id;
    }

    //mengembalikan nilai nama
    public String getNama() {
        return nama;
    }

    //mengeset nilai nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "id=" + id + ", nama=" + nama + '}';
    }
}
