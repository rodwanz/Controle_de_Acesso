package com.wanzeler.controleacesso.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;
import com.wanzeler.controleacesso.domain.repositories.AutorizacaoUsoDeVagaRepository;
import com.wanzeler.controleacesso.domain.services.AutorizacaoUsoDeVagaService;

@RestController
@RequestMapping(value = "/vagas")
public class AutorizacaoUsoVagaController {
	
	@Autowired
	private AutorizacaoUsoDeVagaRepository vagaRepository;
	
	@Autowired
	private AutorizacaoUsoDeVagaService vagaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AutorizacaoUsoDeVaga vagaLivre(@Valid @RequestBody 
			AutorizacaoUsoDeVaga vaga){
		return vagaService.insert(vaga); 
	}
	
	@GetMapping
	public List<AutorizacaoUsoDeVaga> buscandoTodosOsCadastros(){
		return vagaRepository.findAll();		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AutorizacaoUsoDeVaga> buscandoVagaPorId(@PathVariable Long id) {
		return vagaRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
