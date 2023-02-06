package com.wanzeler.controleacesso.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;
import com.wanzeler.controleacesso.domain.services.AutorizacaoUsoDeVagaService;

@RestController
@RequestMapping(value = "/vagas")
public class AutorizacaoUsoVagaController {
	
	@Autowired
	private AutorizacaoUsoDeVagaService vagaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AutorizacaoUsoDeVaga> insert(@Valid @RequestBody AutorizacaoUsoDeVaga vaga){
		vaga = vagaService.insert(vaga);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).body(vaga); 
	}
}
