package com.github.andclima.eskillo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Formacao {

    private Long id;
    private TipoFormacao tipoFormacao;
    private AreaEstudo areaEstudo;
    private int anoInicio;
    private int anoFim;
    private boolean emAndamento;
    private String descricao;
    
}
