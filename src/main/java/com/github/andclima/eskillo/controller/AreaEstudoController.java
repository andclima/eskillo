package com.github.andclima.eskillo.controller;

import java.util.List;

import com.github.andclima.eskillo.model.AreaEstudo;
import com.github.andclima.eskillo.services.AreaEstudoService;

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
public class AreaEstudoController {

    @Autowired  
    private AreaEstudoService service;

    @GetMapping("/areas-de-estudo")
    public ResponseEntity<?> lista() {
        List<AreaEstudo> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/areas-de-estudo/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        AreaEstudo areaEstudo = service.busca(id);
        if (areaEstudo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(areaEstudo);
    }

    @PostMapping("/areas-de-estudo")
    public ResponseEntity<?> post(@RequestBody AreaEstudo areaEstudo) {
        AreaEstudo area = service.adiciona(areaEstudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(area);
    }

    @PutMapping("/areas-de-estudo")
    public ResponseEntity<?> put(@RequestBody AreaEstudo areaEstudo) {
        AreaEstudo area = service.busca(areaEstudo.getId());
        if (area == null) {
            return ResponseEntity.notFound().build();
        }
        AreaEstudo retorno = service.atualiza(areaEstudo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }
    
    @DeleteMapping("/areas-de-estudo/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        AreaEstudo area = service.busca(id);
        if (area == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}