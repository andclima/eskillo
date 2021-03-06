package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.Localidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
    
}
