package com.mapa.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@NotNull
@Entity
public class Localidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	@Column
	private String regiao;
	@Column
	private Long populacao;
	@Column
	private String capital;
	@Column
	private Long area;

	@OneToMany(mappedBy = "localidades")
	private List<Localidade> localidades = new ArrayList<>();

	public Localidade() {

	}

	public Localidade(String nome, String regiao, Long populacao, String capital, Long area) {

		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;

	}

	@Override
	public int hashCode() {
		return Objects.hash(area, capital, id, localidades, nome, populacao, regiao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidade other = (Localidade) obj;
		return Objects.equals(area, other.area) && Objects.equals(capital, other.capital)
				&& Objects.equals(id, other.id) && Objects.equals(localidades, other.localidades)
				&& Objects.equals(nome, other.nome) && Objects.equals(populacao, other.populacao)
				&& Objects.equals(regiao, other.regiao);
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Localidade> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidade> localidades) {
		this.localidades = localidades;
	}

}
