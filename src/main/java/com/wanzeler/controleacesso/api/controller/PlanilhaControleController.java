package com.wanzeler.controleacesso.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wanzeler.controleacesso.api.assembler.PlanilhaControleInputDisassembler;
import com.wanzeler.controleacesso.api.assembler.PlanilhaControllerDtoAssembler;
import com.wanzeler.controleacesso.api.dto.PlanilhaControleDTO;
import com.wanzeler.controleacesso.api.dto.input.PlanilhaControleInput;
import com.wanzeler.controleacesso.api.exceptionhandler.Problema;
import com.wanzeler.controleacesso.domain.exception.ControleException;
import com.wanzeler.controleacesso.domain.exception.PlanilhaControleException;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;
import com.wanzeler.controleacesso.domain.repositories.PlanilhaControleRepository;
import com.wanzeler.controleacesso.domain.services.PlanilhaControleCadastroService;

@RestController
@RequestMapping(value = "/dados")
public class PlanilhaControleController {
	
	@Autowired
	private PlanilhaControleCadastroService controleService;
	
	@Autowired
	private PlanilhaControleRepository planilhaControleRepository;
	
	@Autowired
	private PlanilhaControllerDtoAssembler planilhaDtoAssembler;
	
	@Autowired
	private PlanilhaControleInputDisassembler planilhaInputDisassembler;
	
	@GetMapping
	public List<PlanilhaControleDTO> buscandodoTodos(){
		return planilhaDtoAssembler.toCollectionDTO(planilhaControleRepository.findAll());		
	}
	
	@GetMapping(value = "/{id}")
	public PlanilhaControleDTO buscandoPorIdEntrega(@PathVariable Long id) {
		PlanilhaControle controle = controleService.buscandoPorId(id);
		
		return planilhaDtoAssembler.toModel(controle);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlanilhaControleDTO inserindoTabela(@Valid @RequestBody 
			PlanilhaControleInput controleInput){
		PlanilhaControle controle = planilhaInputDisassembler.toDomainObject(controleInput);
		return planilhaDtoAssembler.toModel(controleService.salvandoTodos(controle));
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public PlanilhaControleDTO atualizando(@PathVariable Long id, 
			@RequestBody PlanilhaControleInput controleInput){
		try {
			PlanilhaControle newControle = controleService.buscandoPorId(id);
			planilhaInputDisassembler.copyToDomainObject(controleInput, newControle);
			return planilhaDtoAssembler.toModel(controleService.salvandoTodos(newControle));
		}catch(PlanilhaControleException e){
			throw new ControleException(e.getMessage());
		}
	}
}

