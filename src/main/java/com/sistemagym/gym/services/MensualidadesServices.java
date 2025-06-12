package com.sistemagym.gym.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemagym.gym.Repository.IRepositoryMensualidades;
import com.sistemagym.gym.models.Mensualidades;

@Service
public class MensualidadesServices {
    @Autowired IRepositoryMensualidades repository;

    // Metodo para guardar una mensualidad
    public Mensualidades guardarMensualidad(Mensualidades datoMensualidad) throws Exception {
        try {
            return this.repository.save(datoMensualidad);
        } catch (Exception e) {
            throw new Exception("Error al guardar la mensualidad: " + e.getMessage());
        }
    }

    //Metodo para buscar todas las mensualidades
    public List<Mensualidades> buscarTodasLasMensualidades() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al buscar las mensualidades: " + e.getMessage());
        }
    }

    // Metodo para buscar una mensualidad por ID
    public Mensualidades buscarMensualidadPorId(Integer idMensualidad) throws Exception {
        try {
            Optional<Mensualidades> mensualidadBuscada = this.repository.findById(idMensualidad);
            if (mensualidadBuscada.isPresent()) {
                return mensualidadBuscada.get();
            } else {
                throw new Exception("La mensualidad buscada no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar la mensualidad por ID: " + e.getMessage());
        }
    }

    //Metodo eliminar por ID
    public boolean eliminarMensualidad(Integer id) throws Exception {
        try {
            Optional<Mensualidades> mensualidadBuscada = this.repository.findById(id);
            if (mensualidadBuscada.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("La mensualidad no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar la mensualidad: " + e.getMessage());
        }
    }
}
