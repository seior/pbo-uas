/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uas.repository;

import com.uas.model.Laptop;
import java.util.List;

/**
 *
 * @author seior
 */
public interface LaptopRepository {

    public Laptop save(Laptop laptop);

    public Laptop update(Laptop laptop);

    public List<Laptop> findAll(String username);

    public Laptop findById(String id);
    
    public void deleteById(String id);

    public void buy(String id, String stok);

}
