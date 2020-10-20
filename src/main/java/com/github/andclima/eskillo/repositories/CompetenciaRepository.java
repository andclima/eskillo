package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.Competencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    
}
