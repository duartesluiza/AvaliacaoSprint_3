package com.mapa.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mapa.modelo.Localidade;

//Nessa classe só terei os tipos primitivos do Java

public class LocalidadeDto {

	private Long id;
	private String nome;
	private String regiao;
	private Long populacao;
	private String capital;
	private Long area;

	
	public LocalidadeDto(Localidade localidade) {
		this.id = localidade.getId();
		this.nome = localidade.getNome();
		this.regiao = localidade.getRegiao();
		this.populacao = localidade.getPopulacao();
		this.capital = localidade.getCapital();
		this.area = localidade.getArea();

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public String getCapital() {
		return capital;
	}

	public Long getArea() {
		return area;
	}

	// Metodo recebe a lista de Localidades,converte e devolve a lista de
	// LocalidadesDto
	public static List<LocalidadeDto> converter(List<Localidade> localidades) {
		return localidades.stream().map(LocalidadeDto::new).collect(Collectors.toList());
	}

}
