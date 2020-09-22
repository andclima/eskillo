package com.github.andclima.eskillo;

import com.github.andclima.eskillo.model.Localidade;
import com.github.andclima.eskillo.model.Perfil;
import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.services.TipoFormacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EskilloApplication implements CommandLineRunner {

	@Autowired
	private TipoFormacaoService service;


	public static void main(String[] args) {
		SpringApplication.run(EskilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Quantidade de registros: " + service.lista().size());

		
		// AreaEstudo area1 = new AreaEstudo();
		// area1.setId(1l);
		// area1.setDescricao("Engenharia de Software");
		
		// AreaEstudo area2 = new AreaEstudo(2l, "Gastronomia");
		// System.out.println(area2.toString());

		// TipoFormacao tipo1 = new TipoFormacao();
		// tipo1.setId(1l);
		// tipo1.setDescricao("Bacharelado");
		// System.out.println(tipo1.toString());

		// Perfil perfilAnderson = new Perfil();
		// perfilAnderson.setId(10l);
		// perfilAnderson.setNome("Anderson");
		// perfilAnderson.setCargoAtual("Professor");
		// perfilAnderson.setEmail("anderson.lima@grupocev.com");

		// Formacao formacao1 = new Formacao();
		// formacao1.setId(1l);
		// formacao1.setTipoFormacao(tipo1);
		// formacao1.setAreaEstudo(area1);
		// formacao1.setAnoInicio(2020);
		// formacao1.setAnoFim(2022);
		// formacao1.setNomeInstituicao("iCEV");
		// formacao1.setEmAndamento(true);

		// perfilAnderson.getFormacoes().add(formacao1);

		// Experiencia exp1 = new Experiencia();
		// exp1.setId(1l);
		// exp1.setCargo("Professor");
		// exp1.setNomeEmpresa("iCEV");
		// exp1.setLocalidade(new Localidade(1l, "Teresina", "PI"));
		// exp1.setOcupacaoAtual(true);

		// perfilAnderson.getExperiencias().add(exp1);

	}

}
