package com.sistemagym.gym.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.sistemagym.gym.Repository.IRepositoryProductos;
import com.sistemagym.gym.models.Productos;

@Service
public class ProductosServices {

    @Autowired
    IRepositoryProductos repository;

    
    //Metodo Guardar
    public Productos guardarProductos(Productos datoProductos)throws Exception{
        try {
            return this.repository.save(datoProductos);
        } catch (Exception e) {
            throw new Exception("Error al guardar el producto: " + e.getMessage());
        }
    }

    //Metodos para buscar todos los productos
    public List<Productos> buscarTodosLosproductos() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al buscar los productos: " + e.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Productos buscarProductosPorId(Integer idProducto) throws Exception{
        try {
            Optional<Productos> productoBuscado = this.repository.findById(idProducto);
            if (productoBuscado.isPresent()) {
                return productoBuscado.get();
            } else {
                throw new Exception("El producto buscado no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar el producto por ID: " + e.getMessage());
        }
    }


    //metodo para modificar por ID
    public Productos modificarProductoPorId(Integer id, Productos datosProducto) throws Exception{
        try {
            Optional<Productos> productoBuscado = this.repository.findById(id);
            if (productoBuscado.isPresent()) {
                productoBuscado.get().setNombre(datosProducto.getNombre());
                productoBuscado.get().setCantidad(datosProducto.getCantidad());
                productoBuscado.get().setPrecio(datosProducto.getPrecio());
                return this.repository.save(productoBuscado.get());
            } else {
                throw new Exception("El producto no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al modificar el producto por ID: " + e.getMessage());
        }
    }

    //metodo para eliminar por ID
    public boolean eliminarProducto(Integer id) throws Exception {
        try {
            Optional<Productos> productoBuscado = this.repository.findById(id);
            if (productoBuscado.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("El producto no se encuentra en la base de datos");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el producto: " + e.getMessage());
        }
    }


}
