package com.uas.repository;

import com.uas.model.Transaksi;

import java.util.List;

public interface TransaksiRepository {

    public Transaksi buy();

    public void delete(int id);

    public List<Transaksi> findByUsername();

    public List<Transaksi> findById();

}
