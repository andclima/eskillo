package com.github.andclima.eskillo.model;

import java.io.Serializable;

import javax.persistence.Column;
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
public class AreaEstudo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // 1. Atributos básicos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAreaEstudo")
    private Long id;

    @EqualsAndHashCode.Exclude
    private String descricao;

}
