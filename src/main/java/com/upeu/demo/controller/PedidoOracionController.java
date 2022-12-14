/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.PedidoOracion;
import com.upeu.demo.service.PedidoOracionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franc
 */
@CrossOrigin(origins = {"http://localhost:4200"})/*Hare peticiones a tal ruta externa*/
@RestController
@RequestMapping("/api/pedido-oracion")
@Api(value = "Microservicios de gestion de Pedidos de oracion", description ="Microservicio de pedidos de oracion")
public class PedidoOracionController {
    
    @Autowired
private PedidoOracionService pedidoOracionService;

 @ApiOperation(value="Lista de pedidos de oracion")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de pedidos de oracion");
        result.put("data", pedidoOracionService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

 @ApiOperation(value="Obtiene datos de  pedidos de oracion")
    @GetMapping("/{id}")
    public ResponseEntity<PedidoOracion> findById(@PathVariable Long id) {
        PedidoOracion pedidoOracion = pedidoOracionService.findById(id);
        return ResponseEntity.ok(pedidoOracion);
    }


    @ApiOperation(value="Elimina un Pedido de oracion")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        PedidoOracion data = pedidoOracionService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe pedido de oracion con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            pedidoOracionService.deleteById(id);
            result.put("success", true);
            result.put("message", "pedido de oracion eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
@ApiOperation(value="Crea un nuevo pedido de oracion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PedidoOracion pedidoOracion) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Pedido de oracion creado correctamente registrado correctamente");
        result.put("data", pedidoOracionService.save(pedidoOracion));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica un Pedido de Oracion")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PedidoOracion pedidoOracion){
        HashMap<String, Object> result = new HashMap<>();
        PedidoOracion data = pedidoOracionService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            pedidoOracion.setPediId(id);
            pedidoOracionService.save(pedidoOracion);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", pedidoOracion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
