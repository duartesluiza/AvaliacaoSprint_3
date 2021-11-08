package com.mapa.controller;

import java.util.List;

import com.mapa.controller.dto.LocalidadeDto;

public class ResponseLocalidades {

	private String mensagem;
	private List<LocalidadeDto> localidades;

	public ResponseLocalidades(String mensagem, List<LocalidadeDto> localidades) {
		this.mensagem = mensagem;
		this.localidades = localidades;
	}

	public ResponseLocalidades() {

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<LocalidadeDto> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<LocalidadeDto> localidades) {
		this.localidades = localidades;
	}

}
