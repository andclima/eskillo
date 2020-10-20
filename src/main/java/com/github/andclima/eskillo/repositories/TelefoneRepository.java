package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.Telefone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}
