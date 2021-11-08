package com.mapa.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mapa.controller.dto.LocalidadeDto;
import com.mapa.controller.form.LocalidadeForm;
import com.mapa.modelo.Localidade;
import com.mapa.repository.LocalidadeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/localidades")
@Api(value = "API REST Localidades")
@CrossOrigin(origins="*")
public class LocalidadesController {

	// Injeção de dependências -> JpaRepository
	@Autowired
	private LocalidadeRepository localidadeRepository;

	
	@GetMapping("/localidades")
	@ApiOperation(value="Retorna uma lista de localidades")
	public List<LocalidadeDto> lista() { // peguei a lista de topicos e converti para topicosDto
		List<Localidade> localidades = localidadeRepository.findAll();
		return LocalidadeDto.converter(localidades);
		

	}
	
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna uma localidade unica")
	public LocalidadeDto detalhar(@PathVariable Long id) {
		Localidade localidade = localidadeRepository.getOne(id);
		return new LocalidadeDto(localidade);
	}

	
	
	@PostMapping
	@Transactional // ---> dispara commit no banco de dados
	@ApiOperation(value="Salva uma localidade")
	public ResponseEntity<LocalidadeDto> cadastrar(@RequestBody LocalidadeForm form, UriComponentsBuilder uriBuilder) {

		Localidade localidade = form.converter(localidadeRepository);
		localidadeRepository.save(localidade);

		URI uri = uriBuilder.path("/localidades/{id}").buildAndExpand(localidade.getId()).toUri();

		// devolve codigo 201 c/ cabeçalho location e corpo da resposta sendo
		// representação do recurso recem criado
		return ResponseEntity.created(uri).body(new LocalidadeDto(localidade));

	}

	
	
	@PutMapping("/{id}")
	@Transactional
	@ApiOperation(value="Atualiza uma localidade")
	public ResponseEntity<LocalidadeDto> atualizar(@PathVariable Long id, @RequestBody LocalidadeForm form) {
		Localidade localidade = form.atualizar(id, localidadeRepository);

		return ResponseEntity.ok(new LocalidadeDto(localidade));
	}

	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	@ApiOperation(value="Deleta uma localidade")
	public ResponseEntity<LocalidadeDto> excluir(@PathVariable Long id) {
		localidadeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma regiao unica")
	public ResponseLocalidades lista(String regiao) {

		ResponseLocalidades responseLocalidades;
		if (regiao == null) {
			List<Localidade> localidades = localidadeRepository.findAll();
			responseLocalidades = new ResponseLocalidades("Sucesso!", LocalidadeDto.converter(localidades));

			return responseLocalidades;

		} else if (validaRegiao(regiao)) {
			List<Localidade> localidades = localidadeRepository.findByRegiao(regiao);

			responseLocalidades = new ResponseLocalidades("Sucesso!", LocalidadeDto.converter(localidades));

			return responseLocalidades;
		}

		responseLocalidades = new ResponseLocalidades("Parâmetro inválido!", null);
		return responseLocalidades;

	}

	public boolean validaRegiao(String regiao) {
		if (regiao.equalsIgnoreCase("Norte") || regiao.equalsIgnoreCase("Sul") || regiao.equalsIgnoreCase("Nordeste")
				|| regiao.equalsIgnoreCase("Sudeste") || regiao.equalsIgnoreCase("Centro-Oeste")) {
			return true;

		}
		return false;
	}
	
	
	
	@GetMapping("/populacao")
	@ApiOperation(value="Filtra a populacao de forma decrescente")

	public List<LocalidadeDto> lista(@PathVariable Long populacao) {

		if (populacao != 0) {
			List<Localidade> localidades = localidadeRepository.findByPopulacao(populacao);
			return LocalidadeDto.converter(localidades);

		} else {
			List<Localidade> localidades = localidadeRepository.findAll();
			return LocalidadeDto.converter(localidades);

		}

	}

	@GetMapping("/area")
	@ApiOperation(value = "Filtra a area de forma decrescente")

	public List<LocalidadeDto> lista2(@PathVariable Long area) {

		if (area != 0) {
			List<Localidade> localidades = localidadeRepository.findByArea(area);
			return LocalidadeDto.converter(localidades);

		} else {
			List<Localidade> localidades = localidadeRepository.findAll();
			return LocalidadeDto.converter(localidades);

		}
	}

}
			
				
		
		
		
	
	
	

	
	
	
