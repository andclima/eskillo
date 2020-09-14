package com.github.andclima.eskillo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"numero", "tipo"})
public class Telefone {

    private Long id;
    private String numero;
    private TipoTelefone tipo;
    
}