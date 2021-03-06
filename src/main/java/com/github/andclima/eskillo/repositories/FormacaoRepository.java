package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.Formacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Long> {
    
}
