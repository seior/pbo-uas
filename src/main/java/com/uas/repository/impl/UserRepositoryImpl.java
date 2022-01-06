package com.uas.repository.impl;

import com.uas.app.Database;
import com.uas.exception.NotFoundException;
import com.uas.model.Toko;
import com.uas.model.User;
import com.uas.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {

    private Connection connection;

    public UserRepositoryImpl() {
        this.connection = Database.getConnection();
    }


    @Override
    public User save(User user) {
        String sql = "insert into user (username, password, nama, alamat, no_telp, jk, role) values (?, ?, ?, ?, ?, ?, ?)";


        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getNama());
            stmt.setString(4, user.getAlamat());
            stmt.setString(5, user.getNoTelp());
            stmt.setString(6, user.getJk());
            stmt.setString(7, user.getRole());

            stmt.executeUpdate();

            stmt.close();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public User findByUsername(String username) throws NotFoundException {
        String sql = "select * from user where username = ?";
        User user = new User();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                user.setUsername(result.getString(1));
                user.setPassword(result.getString(2));
                user.setNama(result.getString(3));
                user.setAlamat(result.getString(4));
                user.setNoTelp(result.getString(5));
                user.setJk(result.getString(6));
                user.setRole(result.getString(7));
            } else {
                throw new NotFoundException("user not found");
            }

            stmt.close();
            result.close();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Boolean login(User user) {
        // check account if exist
        try {
            User result = this.findByUsername(user.getUsername());
            if (Objects.equals(result.getPassword(), user.getPassword())) {
                return true;
            } else {
                return false;
            }

        } catch (NotFoundException e) {
            return false;
        }
    }
}
