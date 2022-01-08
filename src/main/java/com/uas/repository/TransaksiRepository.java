package com.uas.repository;

import com.uas.model.Transaksi;
import com.uas.model.TransaksiToko;

import java.util.List;

public interface TransaksiRepository {

    public Transaksi buy(Transaksi transaksi);

    public void delete(int id);

    public List<Transaksi> findAll(String username);

    public List<TransaksiToko> findAllTransaksiToko(String username);

}
