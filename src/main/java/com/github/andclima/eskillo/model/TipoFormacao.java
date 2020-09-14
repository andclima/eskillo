package com.github.andclima.eskillo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TipoFormacao {

    private Long id;
    
    @EqualsAndHashCode.Exclude 
    private String descricao;

}