package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.TipoCompetencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCompetenciaRepository extends JpaRepository<TipoCompetencia, Long> {
    
}
