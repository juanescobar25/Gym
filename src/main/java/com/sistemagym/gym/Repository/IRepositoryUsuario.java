package com.sistemagym.gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemagym.gym.models.Usuario;

@Repository
public interface IRepositoryUsuario extends JpaRepository<Usuario, Integer> {
  // van las consultas personnalizadas
    
}
