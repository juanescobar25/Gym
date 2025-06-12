package com.sistemagym.gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemagym.gym.models.Ventas;

@Repository
public interface IRepositoryVentas extends JpaRepository<Ventas, Integer> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
