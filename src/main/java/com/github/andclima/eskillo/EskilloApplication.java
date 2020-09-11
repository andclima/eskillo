package com.github.andclima.eskillo;

import java.util.Calendar;

import com.github.andclima.eskillo.model.AreaEstudo;
import com.github.andclima.eskillo.model.Experiencia;
import com.github.andclima.eskillo.model.Perfil;
import com.github.andclima.eskillo.model.Telefone;
import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.model.TipoTelefone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EskilloApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EskilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		AreaEstudo area1 = new AreaEstudo();
		area1.setId(1l);
		area1.setDescricao("Engenharia de Software");
		System.out.println(area1.toString());

		AreaEstudo area2 = new AreaEstudo(2l, "Gastronomia");
		System.out.println(area2.toString());

		TipoFormacao tipo1 = new TipoFormacao();
		tipo1.setId(1l);
		tipo1.setDescricao("Bacharelado");
		System.out.println(tipo1.toString());

		Perfil perfilAnderson = new Perfil();
		perfilAnderson.setId(10l);
		perfilAnderson.setNome("Anderson");
		perfilAnderson.setCargoAtual("Professor");
		perfilAnderson.setEmail("anderson.lima@grupocev.com");

		Experiencia experienciaICev = new Experiencia();
		experienciaICev.setId(1l);
		experienciaICev.setCargo("Professor");
		experienciaICev.setNomeEmpresa("iCEV");
		experienciaICev.setDataInicio(Calendar.getInstance().getTime());
		experienciaICev.setDataFim(null);
		experienciaICev.setOcupacaoAtual(true);
		perfilAnderson.getExperiencias().add(experienciaICev);

		Telefone telefone1 = new Telefone();
		telefone1.setTipo(TipoTelefone.CELULAR);
		telefone1.setNumero("(86) 99912-3456");
		perfilAnderson.getTelefones().add(telefone1);

		System.out.println(perfilAnderson.toString());

	}

}
