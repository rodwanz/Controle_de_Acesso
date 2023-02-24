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

import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;
import com.wanzeler.controleacesso.domain.repositories.AutorizacaoPrestacaoDeServicoRepository;
import com.wanzeler.controleacesso.domain.services.AutorizacaoPrestacaoDeServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class AutorizacaoPrestacaoDeServicoController {
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoRepository autorizacaoPrestacaoDeServicoRepository;
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoService autorizacaoPrestacaoDeServicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AutorizacaoPrestacaoDeServico autorizaServico(@Valid @RequestBody 
			AutorizacaoPrestacaoDeServico autoriza){
		return autorizacaoPrestacaoDeServicoService.insert(autoriza); 
	}
	
	@GetMapping
	public List<AutorizacaoPrestacaoDeServico> todasAsAutorizacoes(){
		return autorizacaoPrestacaoDeServicoRepository.findAll();		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AutorizacaoPrestacaoDeServico> autorizacaoPorId(@PathVariable Long id) {
		return autorizacaoPrestacaoDeServicoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
