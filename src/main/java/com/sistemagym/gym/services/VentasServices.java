package com.sistemagym.gym.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemagym.gym.Repository.IRepositoryVentas;
import com.sistemagym.gym.models.Ventas;

@Service
public class VentasServices {

    @Autowired
    IRepositoryVentas repository;


    // Metodo para guardar una venta
    public Ventas guardarVenta(Ventas datoVentas) throws Exception{
        try {
            return this.repository.save(datoVentas);
        } catch (Exception e) {
            throw new Exception("Error al guardar la venta: " + e.getMessage());
        }
    }

    //Metodo para buscar todas las ventas
    public List<Ventas> buscarTodasLasVentas() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al buscar las ventas: " + e.getMessage());
        }
    }

    //Metodo para buscar una venta por ID
    public Ventas busarventasPorId(Integer idVentas) throws Exception{
        try {
            Optional<Ventas> ventaBuscada=this.repository.findById(idVentas);
            if (ventaBuscada. isPresent()) {
                return ventaBuscada.get();
            } else {
                throw new Exception("La venta buscada no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar la venta por ID: " + e.getMessage());
        }
    }

    //Metodo para eliminar por ID
    public boolean eliminarVenta(Integer id) throws Exception{
        try {
            Optional<Ventas> ventaBuscada = this.repository.findById(id);
            if (ventaBuscada.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("La venta no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar la venta: " + e.getMessage());
        }
    }

    
}
