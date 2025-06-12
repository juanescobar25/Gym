package com.sistemagym.gym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemagym.gym.models.Productos;
import com.sistemagym.gym.services.ProductosServices;

@RestController
@RequestMapping("/productos")
public class ControllerProductos {
    
    @Autowired
    ProductosServices productosServices;

    //Guardar producto

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Productos datosPeticion) {
        try {
            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.productosServices.guardarProductos(datosPeticion));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //Buscar todos los productos
    @GetMapping
    public ResponseEntity<?> buscarProductos(){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.productosServices.buscarTodosLosproductos());
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //Buscar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProductoId(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.productosServices.buscarProductosPorId(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //Modificar producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable Integer id, @RequestBody Productos datos){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.productosServices.modificarProductoPorId(id, datos));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //Eliminar producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.productosServices.eliminarProducto(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

}
