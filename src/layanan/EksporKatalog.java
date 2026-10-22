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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EksporKatalog {

    public void ekspor(KatalogPerpustakaan katalog)
            throws IOException {

        try (BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("katalog.txt"))) {

            writer.write(String.format(
                    "%-10s | %-32s | %-10s | %-20s%n",
                    "Kode", "Judul", "Tahun", "Status"));

            writer.write(
                    "--------------------------------------------------------------------------\n");

            for (Koleksi k : katalog.getDaftar()) {
                writer.write(String.format(
                        "%-10s | %-32s | %-10d | %-20s%n",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        // Tahun ditambahkan melalui getter.
                        k.getTahunTerbit(),
                        k.layakDipinjam()
                                ? "Layak" : "Tidak layak"));
            }
        }
    }
}
