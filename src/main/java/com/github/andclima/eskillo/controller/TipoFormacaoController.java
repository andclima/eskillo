package com.github.andclima.eskillo.controller;

import java.util.List;

import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.services.TipoFormacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoFormacaoController {

    @Autowired  // injecao de dependência
    private TipoFormacaoService service;

    @GetMapping("/tipos-de-formacao")
    public ResponseEntity<?> lista() {
        List<TipoFormacao> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/tipos-de-formacao/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        TipoFormacao tipoFormacao = service.busca(id);
        if (tipoFormacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(tipoFormacao);
    }

    @PostMapping("/tipos-de-formacao")
    public ResponseEntity<?> post(@RequestBody TipoFormacao tipoFormacao) {
        TipoFormacao tipo = service.adiciona(tipoFormacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipo);
    }

    @PutMapping("/tipos-de-formacao")
    public ResponseEntity<?> put(@RequestBody TipoFormacao tipoFormacao) {
        TipoFormacao tipo = service.busca(tipoFormacao.getId());
        if (tipo == null) {
            return ResponseEntity.notFound().build();
        }
        TipoFormacao retorno = service.atualiza(tipoFormacao);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }
    
    @DeleteMapping("/tipos-de-formacao/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        TipoFormacao tipo = service.busca(id);
        if (tipo == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}