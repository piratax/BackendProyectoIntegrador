/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;
import com.upeu.demo.entity.PedidoOracion;
import java.util.List;

/**
 *
 * @author franc
 */
public interface PedidoOracionService {
     public List<PedidoOracion> findAll();

    public PedidoOracion findById(Long id);

    public PedidoOracion save(PedidoOracion pedidoOracion);

    public void delete(PedidoOracion pedidoOracion);

    public void deleteById(Long id);
}
