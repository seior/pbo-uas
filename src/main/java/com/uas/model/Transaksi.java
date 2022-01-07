package com.uas.model;

public class Transaksi {

    private String id;
    private String idLaptop;
    private String jasaPengiriman;
    private String alamat;
    private String pembayaran;
    private String totalBayar;
    private String Username;

    public Transaksi() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(String idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getJasaPengiriman() {
        return jasaPengiriman;
    }

    public void setJasaPengiriman(String jasaPengiriman) {
        this.jasaPengiriman = jasaPengiriman;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
