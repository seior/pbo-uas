/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uas.repository;

import com.uas.exception.NotFoundException;
import com.uas.model.Toko;

import java.util.List;

/**
 *
 * @author seior
 */
public interface TokoRepository {

    public Toko save(Toko toko);

    public Toko FindByUsername(String username) throws NotFoundException;

    public Boolean login(Toko toko);

    public List<Toko> findAll();

}
