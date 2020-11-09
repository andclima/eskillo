package com.github.andclima.eskillo;

import java.text.SimpleDateFormat;

import com.github.andclima.eskillo.model.AreaEstudo;
import com.github.andclima.eskillo.model.Competencia;
import com.github.andclima.eskillo.model.Curso;
import com.github.andclima.eskillo.model.Experiencia;
import com.github.andclima.eskillo.model.Formacao;
import com.github.andclima.eskillo.model.Localidade;
import com.github.andclima.eskillo.model.Perfil;
import com.github.andclima.eskillo.model.Telefone;
import com.github.andclima.eskillo.model.TipoCompetencia;
import com.github.andclima.eskillo.model.TipoEmprego;
import com.github.andclima.eskillo.model.TipoFormacao;
import com.github.andclima.eskillo.model.TipoTelefone;
import com.github.andclima.eskillo.services.AreaEstudoService;
import com.github.andclima.eskillo.services.LocalidadeService;
import com.github.andclima.eskillo.services.PerfilService;
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

	@Autowired
	private PerfilService perfilService;

	public static void main(String[] args) {
		SpringApplication.run(EskilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Localidade localidade = new Localidade(null, "Teresina", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Parnaíba", "PI");
		localidadeService.adiciona(localidade);
		localidade = new Localidade(null, "Caruaru", "PE");
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

		Perfil perfil = new Perfil();
		perfil.setNome("Fulano de Tal");
		perfil.setCargoAtual("Professor");
		perfil.setSobre("De boa!");
		perfil.setEndereco("Rua Cafundó de Judas, 100");
		perfil.setComplemento("Apto 101");
		perfil.setBairro("Centro");
		perfil.setCidade("Teresina");
		perfil.setUf("PI");
		perfil.setEmail("fulano@gmail.com");
		perfil.setVisibilidadePerfil(true);
		perfil.setLocalidade(localidadeService.busca(1l));	// Teresina
		perfil.setSenha("senha-secreta");
		Perfil novo = perfilService.adiciona(perfil);

		Curso curso1 = new Curso();
		curso1.setDescricao("Administrador de banco de dados Oracle Exemplo");
		curso1.setOrganizacao("Organizações Tabajaras 1");
		curso1.setCargaHoraria(40);
		curso1.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"));
		curso1.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2020"));
		perfilService.adicionaCurso(novo.getId(), curso1);

		Curso curso2 = new Curso();
		curso2.setDescricao("WebDesign com HTML5 e CSS3");
		curso2.setOrganizacao("Tapioca Design");
		curso2.setCargaHoraria(32);
		curso2.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("05/11/2019"));
		curso2.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2019"));
		perfilService.adicionaCurso(novo.getId(), curso2);

		Experiencia experiencia1 = new Experiencia();
		experiencia1.setCargo("Professor");
		experiencia1.setTipoEmprego(TipoEmprego.TEMPO_INTEGRAL);
		experiencia1.setNomeEmpresa("Faculdade do Saber");
		experiencia1.setLocalidade(localidadeService.busca(1l));	// Teresina
		experiencia1.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2018"));
		experiencia1.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2019"));
		experiencia1.setOcupacaoAtual(false);
		experiencia1.setDescricao("Disciplina: Algoritmo e Lógica de Programação");
		perfilService.adicionaExperiencia(novo.getId(), experiencia1);

		Experiencia experiencia2 = new Experiencia();
		experiencia2.setCargo("Gerente de Projetos");
		experiencia2.setTipoEmprego(TipoEmprego.TEMPO_INTEGRAL);
		experiencia2.setNomeEmpresa("Organizações Tabajaras");
		experiencia2.setLocalidade(localidadeService.busca(2l));	// Parnaíba
		experiencia2.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("05/10/2019"));
		experiencia2.setDataFim(null);
		experiencia2.setOcupacaoAtual(true);
		experiencia2.setDescricao("Projetos de cooperativas agrícolas");
		perfilService.adicionaExperiencia(novo.getId(), experiencia2);

		Formacao formacao1 = new Formacao();
		formacao1.setNomeInstituicao("Faculdade Menina Bonita");
		formacao1.setTipoFormacao(tipoFormacaoService.busca(1l));	// Bacharelado
		formacao1.setAreaEstudo(areaEstudoService.busca(1l));	// Engenharia de Software
		formacao1.setAnoInicio(2016);
		formacao1.setAnoFim(2019);
		formacao1.setEmAndamento(false);
		formacao1.setDescricao("Dissertação: As tranças do Rei Careca aplicadas à Engenharia de Requisitos");
		perfilService.adicionaFormacao(novo.getId(), formacao1);

		Competencia competencia1 = new Competencia();
		competencia1.setTipoCompetencia(tipoCompetenciaService.busca(1l));	// JavaScript
		perfilService.adicionaCompetencia(novo.getId(), competencia1);

		Competencia competencia2 = new Competencia();
		competencia2.setTipoCompetencia(tipoCompetenciaService.busca(2l));	// Front-end
		perfilService.adicionaCompetencia(novo.getId(), competencia2);

		Competencia competencia3 = new Competencia();
		competencia3.setTipoCompetencia(tipoCompetenciaService.busca(3l));	// Oracle
		perfilService.adicionaCompetencia(novo.getId(), competencia3);

		Telefone telefone1 = new Telefone();
		telefone1.setNumero("(86) 91234-5678");
		telefone1.setTipo(TipoTelefone.CELULAR);
		perfilService.adicionaTelefone(novo.getId(), telefone1);

		Telefone telefone2 = new Telefone();
		telefone2.setNumero("(86) 3123-9876");
		telefone2.setTipo(TipoTelefone.FIXO_RESIDENCIAL);
		perfilService.adicionaTelefone(novo.getId(), telefone2);

	}

}
