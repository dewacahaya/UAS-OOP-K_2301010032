/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos_coffeeshop;

/**
 *
 * @author Pongo
 */
public class Produk {
    private int idProduk;
    private String namaProduk;
    private double harga;
    private String tipe;

    public Produk(int id, String nama, double harga, String tipe) {
        this.idProduk = id;
        this.namaProduk = nama;
        this.harga = harga;
        this.tipe = tipe;
    }

    public int getIdProduk() { return idProduk; }
    public String getNamaProduk() { return namaProduk; }
    public double getHarga() { return harga; }
    public String getTipe() { return tipe; }

    public void setNamaProduk(String nama) { this.namaProduk = nama; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setTipe(String tipe) { this.tipe = tipe; }
}

