package com.sistemagym.gym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemagym.gym.models.Ventas;
import com.sistemagym.gym.services.VentasServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ventas")
public class ControllerVentas {
    
    @Autowired 
    VentasServices ventasServices;

    // Guardar venta
    @PostMapping
    public ResponseEntity<?> guardarVenta(@RequestBody Ventas datosPeticion){
        try {
            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ventasServices.guardarVenta(datosPeticion));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    // Buscar todas las ventas
    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ventasServices.buscarTodasLasVentas());
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    // Buscar venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ventasServices.busarventasPorId(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ventasServices.eliminarVenta(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

}
