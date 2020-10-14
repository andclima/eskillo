package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
}
