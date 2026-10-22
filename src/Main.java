/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */

import model.*;
import layanan.*;
import eksepsi.PustakaException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        KatalogPerpustakaan katalog =
                new KatalogPerpustakaan();

        // 1. Menambahkan enam data wajib
        katalog.tambah(new BukuCetak(
                "BK-001", "Java How to Program", 2022,
                620, "A-12", "Lantai 1", false));

        katalog.tambah(new BukuCetak(
                "BK-002", "Basis Data Relasional", 2021,
                410, "B-04", "Lantai 1", true));

        katalog.tambah(new Majalah(
                "MJ-001", "Info Teknologi Edisi 88", 2026,
                88, "Agustus", "M-01", "Lantai 2", true));

        katalog.tambah(new Majalah(
                "MJ-002", "Info Teknologi Edisi 87", 2026,
                87, "Juli", "M-02", "Lantai 2", false));

        katalog.tambah(new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java", 2024,
                15, "unduh.polmed.ac.id/bd001"));

        katalog.tambah(new BerkasDigital(
                "BD-002", "Jurnal Rekayasa Perangkat", 2025,
                8, "unduh.polmed.ac.id/bd002"));

        // 2. Menampilkan katalog
        System.out.println("=== DAFTAR KOLEKSI ===");
        katalog.cetakStatus();

        // 3. Menguji interface Terarsip
        BukuCetak buku = new BukuCetak(
                "BK-003", "Contoh Arsip", 2023,
                100, "C-01", "Lantai 1", false);

        System.out.println(buku.ringkasanArsip());

        // 4. Mengurutkan koleksi
        System.out.println("\n=== KATALOG TERURUT ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // 5. Menguji peminjaman
        System.out.println("\n=== UJI PEMINJAMAN ===");

        try {
            katalog.pinjam("BK-001");
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println(e.getMessage());
        }

        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println(e.getMessage());
        }

        // 6. Mengekspor katalog
        System.out.println("\n=== EKSPOR KATALOG ===");

        try {
            EksporKatalog ekspor = new EksporKatalog();
            ekspor.ekspor(katalog);
            System.out.println(
                    "Katalog berhasil disimpan ke katalog.txt");
        } catch (IOException e) {
            System.out.println(
                    "Gagal menyimpan katalog: " + e.getMessage());
        }
    }
}
