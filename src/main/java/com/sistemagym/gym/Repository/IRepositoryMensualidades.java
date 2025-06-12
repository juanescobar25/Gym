package com.sistemagym.gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemagym.gym.models.Mensualidades;

@Repository
public interface IRepositoryMensualidades extends JpaRepository <Mensualidades, Integer> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
