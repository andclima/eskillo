package com.github.andclima.eskillo.controller;

import java.util.List;

import com.github.andclima.eskillo.model.Localidade;
import com.github.andclima.eskillo.services.LocalidadeService;

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
public class LocalidadeController {

    @Autowired  
    private LocalidadeService service;

    @GetMapping("/localidades")
    public ResponseEntity<?> lista() {
        List<Localidade> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/localidades/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Localidade localidade = service.busca(id);
        if (localidade == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(localidade);
    }

    @PostMapping("/localidades")
    public ResponseEntity<?> post(@RequestBody Localidade localidade) {
        Localidade novaLocalidade = service.adiciona(localidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLocalidade);
    }

    @PutMapping("/localidades")
    public ResponseEntity<?> put(@RequestBody Localidade localidade) {
        Localidade localidadEncontrada = service.busca(localidade.getId());
        if (localidadEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        Localidade localidadeAtualizada = service.atualiza(localidade);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(localidadeAtualizada);
    }
    
    @DeleteMapping("/localidades/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Localidade localidade = service.busca(id);
        if (localidade == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}