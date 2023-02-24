package com.wanzeler.controleacesso.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping
	public List<PlanilhaControle> buscandodoTodos(){
		return planilhaControleRepository.findAll();		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlanilhaControle> buscandoPorIdEntrega(@PathVariable Long id) {
		return planilhaControleRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlanilhaControle adicinandoEntrega(@Valid @RequestBody 
			PlanilhaControle controle){
		return controleService.insert(controle); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PlanilhaControle> upDate(@PathVariable Long id, 
			@RequestBody PlanilhaControle controle){
		PlanilhaControle newControle = controleService.upDate(id, controle);
		return ResponseEntity.ok().body(newControle);
	}
}

