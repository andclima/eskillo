package com.github.andclima.eskillo.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.andclima.eskillo.dto.PerfilDTO;
import com.github.andclima.eskillo.model.Curso;
import com.github.andclima.eskillo.model.Perfil;
import com.github.andclima.eskillo.services.PerfilService;

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
public class PerfilController {

    @Autowired
    private PerfilService service;

    // Listar
    @GetMapping("/perfis")
    public ResponseEntity<?> lista() {
        List<PerfilDTO> lista = new ArrayList<>();
        for (Perfil perfil:service.lista()) {
            lista.add(convertePerfilParaDto(perfil));
        }
        return ResponseEntity.ok().body(lista);
    }

    // Buscar
    // http://localhost:8080/perfis/123
    @GetMapping("/perfis/{id}")
    public ResponseEntity<?> busca(@PathVariable Long id) {
        Perfil perfil = service.busca(id);
        // Se não encontrar um perfil com o código informado, ele retornar o status 404 (não encontrado - not found)
        if (perfil == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // daqui ele vai embora
        }
        return ResponseEntity.ok().body(convertePerfilParaDto(perfil));
    }

    // Adicionar
    @PostMapping("/perfis")
    public ResponseEntity<?> adiciona(@RequestBody PerfilDTO dto) {
        Perfil perfil = converteDtoParaPerfil(dto);
        Perfil novoPerfil = service.adiciona(perfil);
        PerfilDTO novoDTO = convertePerfilParaDto(novoPerfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDTO);
    }

    // Atualizar
    @PutMapping("/perfis")
    public ResponseEntity<?> atualiza(@RequestBody PerfilDTO dto) {
        Perfil perfil = converteDtoParaPerfil(dto);
        Perfil perfilEncontrado = service.busca(perfil.getId());
        if (perfilEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        Perfil registro = service.atualiza(perfil);
        PerfilDTO registroDTO = convertePerfilParaDto(registro);
        return ResponseEntity.ok().body(registroDTO);
    }

    // Remover
    @DeleteMapping("/perfis/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Perfil perfil = service.busca(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.ok().build();
    }

    /*
     * 
     * IMPLEMENTAR AS OPERAÇÕES SOBRE CURSOS
     * 
    **/

    // Listar cursos de um perfil
    // GET - http://localhost:8080/perfis/123/cursos
    @GetMapping("/perfis/{idPerfil}/cursos")
    public ResponseEntity<?> listaCursos(@PathVariable Long idPerfil) {
        List<Curso> lista = service.listaCursos(idPerfil);
        return ResponseEntity.ok().body(lista);
    }

    // Obter um curso de um perfil
    // GET - http://localhost:8080/perfis/123/cursos/10
    @GetMapping("/perfis/{idPerfil}/cursos/{id}")
    public ResponseEntity<?> buscaCurso(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Curso curso = service.buscaCurso(idPerfil, id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(curso);
    }


    // Adicionar curso a um perfil
    // POST - http://localhost:8080/perfis/123/cursos
    @PostMapping("/perfis/{idPerfil}/cursos")
    public ResponseEntity<?> adicionaCurso(@PathVariable Long idPerfil, @RequestBody Curso curso) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Curso novoCurso = service.adicionaCurso(idPerfil, curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }


    // Atualizar curso de um perfil
    // PUT - http://localhost:8080/perfis/123/cursos
    @PutMapping("/perfis/{idPerfil}/cursos")
    public ResponseEntity<?> atualizaCurso(@PathVariable Long idPerfil, @RequestBody Curso curso) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Curso cursoAtualizado = service.atualizaCurso(idPerfil, curso);
        return ResponseEntity.status(HttpStatus.OK).body(cursoAtualizado);
    }

    // Remover um curso de um perfil
    // DELETE - http://localhost:8080/perfis/123/cursos/10
    @DeleteMapping("/perfis/{idPerfil}/cursos/{id}")
    public ResponseEntity<?> removeCurso(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        Curso curso = service.buscaCurso(idPerfil, id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        service.removeCurso(idPerfil, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    
    private Perfil converteDtoParaPerfil(PerfilDTO dto) {
        Perfil perfil = new Perfil();
        perfil.setId(dto.getId());
        perfil.setNome(dto.getNome());
        perfil.setSobre(dto.getSobre());
        perfil.setCargoAtual(dto.getCargoAtual());
        perfil.setEmail(dto.getEmail());
        perfil.setLocalidade(dto.getLocalidade());
        perfil.setEndereco(dto.getEndereco());
        perfil.setComplemento(dto.getComplemento());
        perfil.setBairro(dto.getBairro());
        perfil.setCidade(dto.getCidade());
        perfil.setUf(dto.getUf());
        perfil.setDataNascimento(dto.getDataNascimento());
        return perfil;
    }

    private PerfilDTO convertePerfilParaDto(Perfil perfil) {
        PerfilDTO dto = new PerfilDTO();
        dto.setId(perfil.getId());
        dto.setNome(perfil.getNome());
        dto.setSobre(perfil.getSobre());
        dto.setCargoAtual(perfil.getCargoAtual());
        dto.setEmail(perfil.getEmail());
        dto.setLocalidade(perfil.getLocalidade());
        dto.setEndereco(perfil.getEndereco());
        dto.setComplemento(perfil.getComplemento());
        dto.setBairro(perfil.getBairro());
        dto.setCidade(perfil.getCidade());
        dto.setUf(perfil.getUf());
        dto.setDataNascimento(perfil.getDataNascimento());
        return dto;
    }

}
