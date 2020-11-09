package com.github.andclima.eskillo.repositories;

import java.util.List;

import com.github.andclima.eskillo.model.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
    @Transactional(readOnly = true)
    List<Perfil> findByEmail(String email);
    
}
