package com.sistemagym.gym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemagym.gym.models.Usuario;
import com.sistemagym.gym.services.UsuarioServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {
    
    @Autowired
    UsuarioServices usuarioServices;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosPeticion){
        try {
            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.usuarioServices.guardarUsuario(datosPeticion));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //buscar todos
    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.usuarioServices.buscarTodosUsuarios());
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.usuarioServices.buscarusuarioPorId(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //metodo para modificar por id
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Usuario datos){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.usuarioServices.modificarusaurio(id, datos));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }

    //metodo para eliminar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.usuarioServices.eliminarUsuario(id));
        } catch (Exception e) {
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
        }
    }
    
}
