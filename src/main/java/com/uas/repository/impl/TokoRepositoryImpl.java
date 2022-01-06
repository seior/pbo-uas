/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uas.repository.impl;

import com.uas.app.Database;
import com.uas.exception.NotFoundException;
import com.uas.model.Toko;
import com.uas.repository.TokoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seior
 */
public class TokoRepositoryImpl implements TokoRepository {

    private Connection connection;

    public TokoRepositoryImpl() {
        connection = Database.getConnection();
    }

    @Override
    public Toko save(Toko toko) {
        String sql = "insert into toko (username, password, nama_toko, alamat) values (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, toko.getUsername());
            stmt.setString(2, toko.getPassword());
            stmt.setString(3, toko.getNamaToko());
            stmt.setString(4, toko.getAlamat());

            stmt.executeUpdate();

            stmt.close();

            return toko;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Toko FindByUsername(String username) throws NotFoundException {
        String sql = "select * from toko where username = ?";
        Toko toko = new Toko();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                toko.setUsername(result.getString(1));
                toko.setPassword(result.getString(2));
                toko.setNamaToko(result.getString(3));
                toko.setAlamat(result.getString(4));
                toko.setRating(result.getFloat(5));

            } else {
                throw new NotFoundException("user not found");
            }

            stmt.close();
            result.close();

            return toko;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Boolean login(Toko toko) {
        // check account if exist
        try {
            Toko result = this.FindByUsername(toko.getUsername());
            if (Objects.equals(result.getPassword(), toko.getPassword())) {
                return true;
            } else {
                return false;
            }

        } catch (NotFoundException e) {
            return false;
        }

    }

}
