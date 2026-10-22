/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ASUS
 */
package model;
public class Majalah extends Koleksi
        implements Terarsip {

    private int edisi;
    private String bulanTerbit;
    private String nomorRak;
    private String lantai;
    private boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahun,
                   int edisi, String bulan, String rak,
                   String lantai, boolean terbaru) {
        super(kode, judul, tahun);
        this.edisi = edisi;
        this.bulanTerbit = bulan;
        this.nomorRak = rak;
        this.lantai = lantai;
        this.edisiTerbaru = terbaru;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Edisi: " + edisi
                + " | Bulan: " + bulanTerbit
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
