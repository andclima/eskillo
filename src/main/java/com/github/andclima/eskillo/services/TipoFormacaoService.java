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
    TipoFormacaoRepository repository;

    public List<TipoFormacao> lista() {
        return repository.findAll();
    }

    public void adiciona(TipoFormacao tipoFormacao) {
        tipoFormacao.setId(null);
        repository.save(tipoFormacao);
    }
    
    public void atualiza(TipoFormacao tipoFormacao) {
        repository.save(tipoFormacao);
    }

    public void remove(TipoFormacao tipoFormacao) {
        repository.delete(tipoFormacao);
    }

    public TipoFormacao busca(Long id) {
        Optional<TipoFormacao> tipoFormacao = repository.findById(id);
        return tipoFormacao.orElse(null);
    }

}
