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

import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;
import com.wanzeler.controleacesso.domain.services.AutorizacaoPrestacaoDeServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class AutorizacaoPrestacaoDeServicoController {
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoService autorizacaoPrestacaoDeServicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AutorizacaoPrestacaoDeServico> insert(
			@Valid @RequestBody AutorizacaoPrestacaoDeServico autoriza){
		autoriza = autorizacaoPrestacaoDeServicoService.insert(autoriza);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(autoriza.getId()).toUri();
		return ResponseEntity.created(uri).body(autoriza); 
	}
}
