package com.uas.repository;

import com.uas.model.StatusPemesanan;

public interface StatusPemesananRepository {

    public StatusPemesanan save(StatusPemesanan statusPemesanan);

    public StatusPemesanan update(StatusPemesanan statusPemesanan);

    public void delete(String id);

    public StatusPemesanan findByIdTransaksi(String id);

}
