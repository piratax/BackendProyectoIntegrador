/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.Meditacion;
import java.util.List;

public interface MeditacionService {

    public List<Meditacion> findAll();

    public Meditacion findById(Long id);

    public Meditacion save(Meditacion meditacion);

    public void delete(Meditacion meditacion);

    public void deleteById(Long id);
}
