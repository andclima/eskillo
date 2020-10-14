package com.github.andclima.eskillo.dto;

import java.util.Date;

import com.github.andclima.eskillo.model.Localidade;

import lombok.Data;

@Data
public class PerfilDTO {

    private Long id;
    private String nome;
    private String sobre;
    private String cargoAtual;
    private Localidade localidade;
    private String email;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Date dataNascimento;
    private boolean visibilidadePerfil;
    
}
