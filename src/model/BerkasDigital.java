/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class BerkasDigital extends Koleksi {

    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahun,
                         double ukuran, String tautan) {
        super(kode, judul, tahun);
        this.ukuranMB = ukuran;
        this.tautanUnduh = tautan;
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Ukuran: " + ukuranMB + " MB"
                + " | Unduh: " + tautanUnduh;
    }
}
