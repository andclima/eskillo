package com.github.andclima.eskillo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.andclima.eskillo.model.Curso;
import com.github.andclima.eskillo.model.Perfil;
import com.github.andclima.eskillo.repositories.CursoRepository;
import com.github.andclima.eskillo.repositories.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Perfil> lista() {
        return repository.findAll();
    }

    public Perfil busca(Long id) {
        Optional<Perfil> perfil = repository.findById(id);
        return perfil.orElse(null);
    }

    public Perfil adiciona(Perfil perfil) {
        perfil.setId(null);
        return repository.save(perfil);
    }

    public Perfil atualiza(Perfil perfil) {
        return repository.save(perfil);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public List<Curso> listaCursos(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getCursos();
        }
        return null;
    }

    public Curso buscaCurso(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Curso curso : perfil.getCursos()) {
                if (curso.getId().equals(id)) {
                    return curso;
                }
            }
        }
        return null;
    }

    public Curso adicionaCurso(Long idPerfil, Curso curso) {
        Curso novoCurso = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            curso.setId(null);
            novoCurso = cursoRepository.save(curso);
            perfil.getCursos().add(novoCurso);
            repository.save(perfil);
        }
        return novoCurso;
    }

    public Curso atualizaCurso(Long idPerfil, Curso curso) {
        Curso cursoAtualizado = null;
        Perfil perfil = busca(idPerfil);
        if (idPerfil != null) {
            int pos = perfil.getCursos().indexOf(curso);
            if (pos >= 0) {
                cursoAtualizado = cursoRepository.save(curso);
                perfil.getCursos().set(pos, curso);
                repository.save(perfil);
            }
        }
        return cursoAtualizado;
    }

    public void removeCurso(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (idPerfil != null) {
            Curso cursoEncontrado = null;
            for (Curso curso : perfil.getCursos()) {
                if (curso.getId().equals(id)) {
                    cursoEncontrado = curso;
                }
            }
            if (cursoEncontrado != null) {
                perfil.getCursos().remove(cursoEncontrado);
                repository.save(perfil);
                cursoRepository.deleteById(id);
            }
        }
    }

}
