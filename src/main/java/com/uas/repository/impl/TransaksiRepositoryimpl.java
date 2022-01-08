package com.uas.repository.impl;

import com.uas.app.Database;
import com.uas.model.Transaksi;
import com.uas.model.TransaksiToko;
import com.uas.repository.TransaksiRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiRepositoryimpl implements TransaksiRepository {
    private Connection connection;

    public TransaksiRepositoryimpl() {
        this.connection = Database.getConnection();
    }


    @Override
    public Transaksi buy(Transaksi transaksi) {
        String sql = "insert into transaksi (id_laptop, jasa_pengiriman, alamat, pembayaran, total_bayar, username) values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, transaksi.getIdLaptop());
            stmt.setString(2, transaksi.getJasaPengiriman());
            stmt.setString(3, transaksi.getAlamat());
            stmt.setString(4, transaksi.getPembayaran());
            stmt.setString(5, transaksi.getTotalBayar());
            stmt.setString(6, transaksi.getUsername());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                transaksi.setId(generatedKeys.getString(1));
            }

            generatedKeys.close();
            stmt.close();

            return transaksi;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from transaksi where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Transaksi> findAll(String username) {
        String sql = "select * from transaksi where username = ?";
        List<Transaksi> transaksis = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Transaksi transaksi = new Transaksi();

                transaksi.setId(resultSet.getString(1));
                transaksi.setIdLaptop(resultSet.getString(2));
                transaksi.setJasaPengiriman(resultSet.getString(3));
                transaksi.setAlamat(resultSet.getString(4));
                transaksi.setPembayaran(resultSet.getString(5));
                transaksi.setTotalBayar(resultSet.getString(6));
                transaksi.setUsername(resultSet.getString(7));

                transaksis.add(transaksi);
            }

            stmt.close();
            resultSet.close();

            return transaksis;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<TransaksiToko> findAllTransaksiToko(String username) {
        String sql = "select t.id, t.id_laptop, t.pembayaran, t.total_bayar, t.jasa_pengiriman, t.alamat, t.username as pembeli " +
                "from transaksi t join laptop l on (t.id_laptop = l.id) where l.username = ?";

        List<TransaksiToko> transaksiTokos = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                TransaksiToko transaksiToko = new TransaksiToko();

                transaksiToko.setId(resultSet.getString(1));
                transaksiToko.setIdLaptop(resultSet.getString(2));
                transaksiToko.setPembayaran(resultSet.getString(3));
                transaksiToko.setTotalBayar(resultSet.getString(4));
                transaksiToko.setJasaPengiriman(resultSet.getString(5));
                transaksiToko.setAlamat(resultSet.getString(6));
                transaksiToko.setPembeli(resultSet.getString(7));

                transaksiTokos.add(transaksiToko);
            }

            stmt.close();
            resultSet.close();

            return transaksiTokos;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
