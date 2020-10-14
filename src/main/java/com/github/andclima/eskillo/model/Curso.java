package com.github.andclima.eskillo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"organizacao", "cargaHoraria", "dataInicio", "dataFim", "descricao"})
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String organizacao;
    private int cargaHoraria;
    private Date dataInicio;
    private Date dataFim;
    private String descricao;

}
