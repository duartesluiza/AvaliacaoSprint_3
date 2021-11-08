package com.mapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mapa.modelo.Localidade;


public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

	// findByLocalidade -> spring consegue gerar query automaticamente
	List<Localidade> findByRegiao(String regiao);

	@Query("SELECT e FROM Localidade e ORDER BY populacao DESC")
	List<Localidade> findByPopulacao(Long populacao);

	@Query("SELECT e FROM Localidade e ORDER BY area DESC")
	List<Localidade> findByArea(Long area);

}
