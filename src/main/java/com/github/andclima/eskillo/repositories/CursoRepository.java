package com.github.andclima.eskillo.repositories;

import com.github.andclima.eskillo.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
