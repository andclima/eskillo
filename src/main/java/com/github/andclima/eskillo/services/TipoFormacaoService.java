package com.github.andclima.eskillo.services;

import java.util.List;
import java.util.Optional;

import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.repositories.TipoFormacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoFormacaoService {

    @Autowired
    private TipoFormacaoRepository repository;

    public List<TipoFormacao> lista() {
        return repository.findAll();
    }

    public TipoFormacao busca(Long id) {
        Optional<TipoFormacao> tipoFormacao = repository.findById(id);
        return tipoFormacao.orElse(null);
    }

    public TipoFormacao adiciona(TipoFormacao tipoFormacao) {
        tipoFormacao.setId(null);
        return repository.save(tipoFormacao);
    }
    
    public TipoFormacao atualiza(TipoFormacao tipoFormacao) {
        return repository.save(tipoFormacao);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
