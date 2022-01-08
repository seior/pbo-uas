/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uas.repository;

import com.uas.model.Laptop;
import com.uas.model.LaptopToko;

import java.util.List;

/**
 *
 * @author seior
 */
public interface LaptopRepository {

    public Laptop save(Laptop laptop);

    public Laptop update(Laptop laptop);

    public List<Laptop> findAll(String username);

    public List<LaptopToko> findAllToko();

    public Laptop findById(String id);

    public void deleteById(String id);

    public void buy(String id, String stok);

}
