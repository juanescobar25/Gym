package com.sistemagym.gym.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemagym.gym.Repository.IRepositoryValoraciones;
import com.sistemagym.gym.models.Valoraciones;



@Service
public class ValoracionesService {

    @Autowired
    IRepositoryValoraciones repository;

    //Metodo Guardar
    public Valoraciones guardarValoraciones(Valoraciones datoValoraciones) throws Exception{
        try {
            return this.repository.save(datoValoraciones);
        } catch (Exception e) {
            throw new Exception("Error al guardar la valoracion: " + e.getMessage());
        }
    }

    //Metodo para buscar todas las valoraciones
    public List<Valoraciones> buscarTodasLasValoraciones() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al buscar las valoraciones: " + e.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Valoraciones buscarValoracionPorId(Integer idValoracion)throws Exception{
        try {
            Optional<Valoraciones> valoracionBuscada = this.repository.findById(idValoracion);
            if (valoracionBuscada.isPresent()) {
                return valoracionBuscada.get();
            } else {
                throw new Exception("La valoracion buscada no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar la valoracion por ID: " + e.getMessage());
        }
    }

    //Metodo eliminar por ID

    public boolean eliminarValoracion(Integer id) throws Exception{
        try {
            Optional<Valoraciones> valoracionBuscada = this.repository.findById(id);
            if (valoracionBuscada.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("La valoracion no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar la valoracion por ID: " + e.getMessage());
        }
    }

    


}
//4480876