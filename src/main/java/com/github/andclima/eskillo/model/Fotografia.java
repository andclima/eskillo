package com.github.andclima.eskillo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Fotografia implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name = "idPerfil")
    private Perfil perfil;

    private byte[] fotografia;
    private String tipoArquivo;
    
}
