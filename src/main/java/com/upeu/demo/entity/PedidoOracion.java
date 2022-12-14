/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author franc
 */

@Data
@Entity
@Table(name = "pedidoOracion")
public class PedidoOracion implements Serializable{

    @Id
    @Column(name = "pedi_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pediId;

    @Column(name = "pedi_Descripcion")
    private String pediDesc;

    @Column(name = "pedi_estado")
    private String pediEst;

  
}
