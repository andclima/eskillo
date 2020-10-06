package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.AreaEstudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaEstudoRepository extends JpaRepository<AreaEstudo, Long> {
    
}
