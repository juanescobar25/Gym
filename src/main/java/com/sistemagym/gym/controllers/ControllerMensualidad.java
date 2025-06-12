package com.sistemagym.gym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemagym.gym.models.Mensualidades;
import com.sistemagym.gym.services.MensualidadesServices;

@RestController
@RequestMapping("/mensualidades")
public class ControllerMensualidad {

    @Autowired
    MensualidadesServices mensualidadesServices;

    //guardar
    @PostMapping
    public ResponseEntity<?> guardarMensualidad(@RequestBody Mensualidades datosPeticion) {
        try {
            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this. mensualidadesServices.guardarMensualidad(datosPeticion));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //buscar todas las mensualidades
    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.mensualidadesServices.buscarTodasLasMensualidades());
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //buscar mensualidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.mensualidadesServices.buscarMensualidadPorId(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //eliminar mensualidad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.mensualidadesServices.eliminarMensualidad(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }
    
}
