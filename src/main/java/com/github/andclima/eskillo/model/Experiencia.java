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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"cargo", "tipoEmprego", "nomeEmpresa", "localidade", "dataInicio", "dataFim", })
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Americas/Fortaleza")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Americas/Fortaleza")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    
    private boolean ocupacaoAtual;
    private String descricao;

}
