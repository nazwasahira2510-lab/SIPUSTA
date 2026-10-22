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
import java.util.Comparator;

public class UrutLayakLaluJudul
        implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {
        int hasil = Boolean.compare(
                b.layakDipinjam(),
                a.layakDipinjam()
        );

        if (hasil != 0) {
            return hasil;
        }

        return a.getJudul().compareToIgnoreCase(
                b.getJudul()
        );
    }
}

