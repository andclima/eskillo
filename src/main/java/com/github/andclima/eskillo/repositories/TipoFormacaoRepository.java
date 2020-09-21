package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.TipoFormacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFormacaoRepository extends JpaRepository<TipoFormacao, Long> {
    
}