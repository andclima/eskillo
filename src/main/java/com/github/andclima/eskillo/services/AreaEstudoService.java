package com.github.andclima.eskillo.services;

import java.util.List;
import java.util.Optional;

import com.github.andclima.eskillo.model.AreaEstudo;
import com.github.andclima.eskillo.repositories.AreaEstudoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaEstudoService {

    @Autowired
    private AreaEstudoRepository repository;

    public List<AreaEstudo> lista() {
        return repository.findAll();
    }

    public AreaEstudo busca(Long id) {
        Optional<AreaEstudo> tipo = repository.findById(id);
        return tipo.orElse(null);
    }

    public AreaEstudo adiciona(AreaEstudo areaEstudo) {
        areaEstudo.setId(null);
        return repository.save(areaEstudo);
    }
    
    public AreaEstudo atualiza(AreaEstudo areaEstudo) {
        return repository.save(areaEstudo);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
