package com.sistemagym.gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemagym.gym.models.Valoraciones;

@Repository
public interface IRepositoryValoraciones extends JpaRepository<Valoraciones, Integer>{
    //Van consultas personalizadas
}
