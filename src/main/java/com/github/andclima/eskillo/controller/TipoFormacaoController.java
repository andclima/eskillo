package com.github.andclima.eskillo.controller;

import java.util.List;

import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.services.TipoFormacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoFormacaoController {

    @Autowired
    private TipoFormacaoService service;

    @GetMapping("/tipos-formacao")
    public List<TipoFormacao> lista() {
        return service.lista();
    }

    @GetMapping("/tipos-formacao/{id}")
    public TipoFormacao get(@PathVariable Long id) {
        return service.busca(id);
    }

    @PostMapping("/tipos-formacao")
    public String post(@RequestBody TipoFormacao tipoFormacao) {
        service.adiciona(tipoFormacao);
        return "Registro adicionado com sucesso!";
    }

    @PutMapping("/tipos-formacao")
    public String put(@RequestBody TipoFormacao tipoFormacao) {
        service.atualiza(tipoFormacao);
        return "Registro atualizado com sucesso";
    }
    
    @DeleteMapping("/tipos-formacao")
    public String delete(@RequestBody TipoFormacao tipoFormacao) {
        service.remove(tipoFormacao);
        return "Registro removido com sucesso";
    }
    
}
