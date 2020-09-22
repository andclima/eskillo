package com.github.andclima.eskillo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeInstituicao;

    @ManyToOne
    @JoinColumn(name = "idTipoFormacao")
    private TipoFormacao tipoFormacao;

    @ManyToOne
    @JoinColumn(name = "idAreaEstudo")
    private AreaEstudo areaEstudo;

    private int anoInicio;
    private int anoFim;
    private boolean emAndamento;
    private String descricao;

}
