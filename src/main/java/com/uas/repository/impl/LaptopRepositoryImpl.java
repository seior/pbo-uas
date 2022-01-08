/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uas.repository.impl;

import com.uas.app.Database;
import com.uas.model.Laptop;
import com.uas.model.LaptopToko;
import com.uas.repository.LaptopRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author seior
 */
public class LaptopRepositoryImpl implements LaptopRepository {

    private final Connection connection;

    public LaptopRepositoryImpl() {
        this.connection = Database.getConnection();
    }

    @Override
    public Laptop save(Laptop laptop) {
        String sql = "insert into laptop (harga, nama, kondisi, tipe, deskripsi, username)values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, laptop.getHarga());
            stmt.setString(2, laptop.getNama());
            stmt.setString(3, laptop.getKondisi());
            stmt.setString(4, laptop.getTipe());
            stmt.setString(5, laptop.getDeskripsi());
            stmt.setString(6, laptop.getUsername());

            stmt.executeUpdate();

            ResultSet id = stmt.getGeneratedKeys();

            if (id.next()) {
                laptop.setId(id.toString());
            }

            stmt.close();
            id.close();

            return laptop;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Laptop update(Laptop laptop) {
        String sql = "update laptop set harga = ?, nama = ?, kondisi = ?, tipe = ?, deskripsi = ? where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, laptop.getHarga());
            stmt.setString(2, laptop.getNama());
            stmt.setString(3, laptop.getKondisi());
            stmt.setString(4, laptop.getTipe());
            stmt.setString(5, laptop.getDeskripsi());
            stmt.setString(6, laptop.getId());

            stmt.executeUpdate();

            stmt.close();

            return laptop;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Laptop> findAll(String username) {
        String sql = "select * from laptop where username = ?";
        List<Laptop> laptops = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Laptop laptop = new Laptop();

                laptop.setId(String.valueOf(result.getInt(1)));
                laptop.setHarga(result.getString(2));
                laptop.setNama(result.getString(3));
                laptop.setTerjual(result.getString(4));
                laptop.setKondisi(result.getString(5));
                laptop.setTipe(result.getString(6));
                laptop.setDeskripsi(result.getString(7));
                laptop.setUsername(result.getString(8));

                laptops.add(laptop);
            }

            stmt.close();
            result.close();

            return laptops;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<LaptopToko> findAllToko() {
        String sql = "select l.username ,l.harga, l.nama, l.terjual, l.kondisi, l.tipe, l.deskripsi, t.nama_toko, l.id from laptop l" +
                " join toko t on (l.username = t.username)";

        List<LaptopToko> laptops = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                LaptopToko laptop = new LaptopToko();

                laptop.setId(result.getString(9));
                laptop.setUsername(result.getString(1));
                laptop.setHarga(result.getString(2));
                laptop.setNama(result.getString(3));
                laptop.setTerjual(result.getString(4));
                laptop.setKondisi(result.getString(5));
                laptop.setTipe(result.getString(6));
                laptop.setDeskripsi(result.getString(7));
                laptop.setNamaToko(result.getString(8));

                laptops.add(laptop);
            }

            stmt.close();
            result.close();

            return laptops;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Laptop findById(String id) {
        String sql = "select * from laptop where id = ?";
        Laptop laptop = new Laptop();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, id);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {

                laptop.setId(String.valueOf(result.getInt(1)));
                laptop.setHarga(result.getString(2));
                laptop.setNama(result.getString(3));
                laptop.setTerjual(result.getString(4));
                laptop.setKondisi(result.getString(5));
                laptop.setTipe(result.getString(6));
                laptop.setDeskripsi(result.getString(7));
                laptop.setUsername(result.getString(8));
            }

            result.close();

            return laptop;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from laptop where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, id);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public void buy(String id, String stok) {
        String sql = "update laptop set stok = ? where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, stok);
            stmt.setString(2, id);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
    }

}
