package com.github.andclima.eskillo;

import com.github.andclima.eskillo.model.AreaEstudo;
import com.github.andclima.eskillo.model.Localidade;
import com.github.andclima.eskillo.model.TipoCompetencia;
import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.services.AreaEstudoService;
import com.github.andclima.eskillo.services.LocalidadeService;
import com.github.andclima.eskillo.services.TipoCompetenciaService;
import com.github.andclima.eskillo.services.TipoFormacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EskilloApplication implements CommandLineRunner {

	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private TipoCompetenciaService tipoCompetenciaService;

	@Autowired
	private TipoFormacaoService tipoFormacaoService;

	@Autowired
	private AreaEstudoService areaEstudoService;

	public static void main(String[] args) {
		SpringApplication.run(EskilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Popula o banco de dados com dados de exemplo

		Localidade localidade = new Localidade(null, "Teresina", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Parnaíba", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Recife", "PE");
		localidadeService.adiciona(localidade);

		TipoFormacao tipoFormacao = new TipoFormacao(null, "Bacharelado");
		tipoFormacaoService.adiciona(tipoFormacao);
		tipoFormacao = new TipoFormacao(null, "Mestrado");
		tipoFormacaoService.adiciona(tipoFormacao);
		tipoFormacao = new TipoFormacao(null, "Doutorado");
		tipoFormacaoService.adiciona(tipoFormacao);

		TipoCompetencia tipoCompetencia = new TipoCompetencia(null, "Javascript");
		tipoCompetenciaService.adiciona(tipoCompetencia);
		tipoCompetencia = new TipoCompetencia(null, "Front-end");
		tipoCompetenciaService.adiciona(tipoCompetencia);
		tipoCompetencia = new TipoCompetencia(null, "Oracle");
		tipoCompetenciaService.adiciona(tipoCompetencia);

		AreaEstudo areaEstudo = new AreaEstudo(null, "Engenharia de Software");
		areaEstudoService.adiciona(areaEstudo);
		areaEstudo = new AreaEstudo(null, "Administração");
		areaEstudoService.adiciona(areaEstudo);
		areaEstudo = new AreaEstudo(null, "Direito");
		areaEstudoService.adiciona(areaEstudo);

	}

}
