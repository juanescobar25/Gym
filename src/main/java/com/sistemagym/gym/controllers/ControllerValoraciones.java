package com.sistemagym.gym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemagym.gym.models.Valoraciones;
import com.sistemagym.gym.services.ValoracionesService;

@RestController
@RequestMapping("/valoraciones")    
public class ControllerValoraciones {

    @Autowired
    ValoracionesService valoracionesService;

    // Guardar valoracion
    @PostMapping
    public ResponseEntity<?> Valoraciones (@RequestBody Valoraciones datosPeticion){
        try {
            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.valoracionesService.guardarValoraciones(datosPeticion));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    // Buscar todas las valoraciones
    @GetMapping
    public ResponseEntity<?> buscarValoraciones(){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.valoracionesService.buscarTodasLasValoraciones());
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    // Buscar valoracion por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarValoracionesId(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.valoracionesService.buscarValoracionPorId(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    // Eliminar valoracion por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.valoracionesService.eliminarValoracion(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }
}
