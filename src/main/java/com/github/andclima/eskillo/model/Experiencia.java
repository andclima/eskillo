package com.github.andclima.eskillo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cargo;
    

    @Enumerated(value = EnumType.STRING)
    private TipoEmprego tipoEmprego;
    
    private String nomeEmpresa;

    @ManyToOne
    @JoinColumn(name = "idLocalidade")
    private Localidade localidade;

    private Date dataInicio;
    private Date dataFim;
    private boolean ocupacaoAtual;
    private String descricao;

}
