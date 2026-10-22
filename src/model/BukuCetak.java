/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class BukuCetak extends Koleksi
        implements Terarsip {

    private int jumlahHalaman;
    private String nomorRak;
    private String lantai;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahun,
                     int halaman, String rak, String lantai,
                     boolean diperbaiki) {
        super(kode, judul, tahun);
        this.jumlahHalaman = halaman;
        this.nomorRak = rak;
        this.lantai = lantai;
        this.sedangDiperbaiki = diperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Halaman: " + jumlahHalaman
                + " | Rak: " + nomorRak;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }
}
