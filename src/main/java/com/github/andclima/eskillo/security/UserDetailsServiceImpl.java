package com.github.andclima.eskillo.security;

import java.util.List;

import com.github.andclima.eskillo.model.Perfil;
import com.github.andclima.eskillo.repositories.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PerfilRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        List<Perfil> lista = repository.findByEmail(email);
        if (lista.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        Perfil perfil = lista.get(0);
        return new UserDetailsPerfil(perfil.getId(), perfil.getEmail(), perfil.getSenha(), null);
    }
    
}
