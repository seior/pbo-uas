package com.uas.repository.impl;

import com.uas.app.Database;
import com.uas.model.StatusPemesanan;
import com.uas.repository.StatusPemesananRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusPemesananRepositoryImpl implements StatusPemesananRepository {

    private Connection connection;

    public StatusPemesananRepositoryImpl() {
        this.connection = Database.getConnection();
    }

    @Override
    public StatusPemesanan save(StatusPemesanan statusPemesanan) {
        String sql = "insert into status_pemesanan (id_transaksi, status_pembayaran, status_pemesanan) values (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, statusPemesanan.getIdTransaksi());
            stmt.setString(2, statusPemesanan.getStatusPembayaran());
            stmt.setString(3, statusPemesanan.getStatusPemesanan());

            stmt.executeUpdate();

            stmt.close();

            return statusPemesanan;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public StatusPemesanan update(StatusPemesanan statusPemesanan) {
        String sql = "update status_pemesanan set status_pemesanan = ? where id_transaksi = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, statusPemesanan.getStatusPemesanan());
            stmt.setString(2, statusPemesanan.getIdTransaksi());

            stmt.executeUpdate();

            stmt.close();

            return statusPemesanan;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "delete from status_pemesanan where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, Integer.parseInt(id));

            stmt.execute();

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public StatusPemesanan findByIdTransaksi(String id) {
        String sql = "select * from status_pemesanan where id_transaksi = ?";
        StatusPemesanan statusPemesanan = new StatusPemesanan();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, id);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                statusPemesanan.setId(resultSet.getString(1));
                statusPemesanan.setIdTransaksi(resultSet.getString(2));
                statusPemesanan.setStatusPembayaran(resultSet.getString(3));
                statusPemesanan.setStatusPemesanan(resultSet.getString(4));
            }

            stmt.close();
            resultSet.close();

            return statusPemesanan;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
