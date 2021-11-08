package com.mapa.controller.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.mapa.modelo.Localidade;
import com.mapa.repository.LocalidadeRepository;

//Defini quais campos que vão chegar do cliente p/ a API


@Valid
public class LocalidadeForm {
	

	
	@NotNull @NotEmpty @Length(min = 2)
	private String nome;
	@NotNull @NotEmpty @Length(min = 2)
	private String regiao;
	@NotNull @NotEmpty @Length(min = 2)
	private Long populacao;
	@NotNull @NotEmpty @Length(min = 2)
	private String capital;
	@NotNull @NotEmpty @Length(min = 2)
	private Long area;
	
	
	

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRegiao() {
		return regiao;
	}

	
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}





	public Localidade converter(LocalidadeRepository localidadeRepository) {
		List<Localidade> localidade = localidadeRepository.findByRegiao(regiao);
		return new Localidade(nome, regiao, populacao, capital, area);
	}


	public Localidade atualizar(Long id, LocalidadeRepository localidadeRepository) {
		Localidade localidade = localidadeRepository.getOne(id);
		
		localidade.setNome(this.nome);
		localidade.setRegiao(this.regiao);
		localidade.setPopulacao(this.populacao);
		localidade.setCapital(this.capital);
		localidade.setArea(this.area);
		
		return localidade;
	}
	
	

}
