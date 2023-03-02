package com.wanzeler.controleacesso.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wanzeler.controleacesso.api.assembler.AutorizacaoPrestacaoDeServicoDtoAssembler;
import com.wanzeler.controleacesso.api.assembler.AutorizacaoPrestacaoDeServicoInputDisassembler;
import com.wanzeler.controleacesso.api.dto.AutorizacaoPrestacaoDeServicoDTO;
import com.wanzeler.controleacesso.api.dto.input.AutorizacaoPrestacaoDeServicoInput;
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
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoDtoAssembler autorizacaoServicoDtoAssembler;
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoInputDisassembler autorizaServicoInptDisassembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AutorizacaoPrestacaoDeServicoDTO autorizaServico(@Valid @RequestBody 
			AutorizacaoPrestacaoDeServicoInput autorizaInput){
		AutorizacaoPrestacaoDeServico autoriza = autorizaServicoInptDisassembler.toDomainObject(autorizaInput);
		return autorizacaoServicoDtoAssembler.toModel(autorizacaoPrestacaoDeServicoService.inserindoAutorizacao(autoriza)); 
	}
	
	@GetMapping
	public List<AutorizacaoPrestacaoDeServicoDTO> todasAsAutorizacoes(){
		return autorizacaoServicoDtoAssembler.toCollectionDTO(autorizacaoPrestacaoDeServicoRepository.findAll());		
	}
	
	@GetMapping(value = "/{id}")
	public AutorizacaoPrestacaoDeServicoDTO autorizacaoPorId(@PathVariable Long id) {
		AutorizacaoPrestacaoDeServico autoriza = autorizacaoPrestacaoDeServicoService.buscandoId(id);
		
		return autorizacaoServicoDtoAssembler.toModel(autoriza);

	}
}
