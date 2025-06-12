package com.sistemagym.gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemagym.gym.models.Productos;

@Repository
public interface IRepositoryProductos extends JpaRepository <Productos, Integer> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
