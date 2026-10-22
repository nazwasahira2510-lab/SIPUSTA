/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author ASUS
 */
import model.Koleksi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import eksepsi.*;

public class KatalogPerpustakaan {

    private List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return daftar;
    }

    public void cetakStatus() {
        for (Koleksi k : daftar) {
            System.out.println(k.deskripsi());
            System.out.println("Layak dipinjam: "
                    + (k.layakDipinjam() ? "Ya" : "Tidak"));
            System.out.println("----------------------");
        }
    }

    public void urut(Comparator<Koleksi> comparator) {
        daftar.sort(comparator);
    }

    public void pinjam(String kode)
            throws PustakaException {

        for (Koleksi k : daftar) {
            if (k.getKodeKoleksi().equals(kode)) {

                if (k.isSedangDipinjam()) {
                    throw new KoleksiSedangDipinjamException(
                            "Koleksi sedang dipinjam orang lain.");
                }

                if (!k.layakDipinjam()) {
                    throw new KoleksiTidakLayakException(
                            "Koleksi belum boleh dipinjam "
                            + "karena tidak memenuhi aturan.");
                }

                k.setSedangDipinjam(true);
                System.out.println("Peminjaman berhasil: "
                        + k.getJudul());
                return;
            }
        }

        System.out.println("Kode koleksi tidak ditemukan.");
    }
}
