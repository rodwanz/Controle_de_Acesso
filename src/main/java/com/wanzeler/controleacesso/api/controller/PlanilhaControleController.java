package com.wanzeler.controleacesso.api.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wanzeler.controleacesso.domain.dto.PlanilhaControleDTO;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;
import com.wanzeler.controleacesso.domain.services.PlanilhaControleCadastroService;

@RestController
@RequestMapping(value = "/dados")
public class PlanilhaControleController {
	
	@Autowired
	private PlanilhaControleCadastroService controleService;
	
	@GetMapping
	public ResponseEntity<List<PlanilhaControleDTO>> findAll(){
		List<PlanilhaControle> list = controleService.findAll();
		List<PlanilhaControleDTO> listDTO = 
				list.stream().map(controle -> 
				new PlanilhaControleDTO(controle)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlanilhaControleDTO> findById(@PathVariable Long id) {
		PlanilhaControle controle = controleService.findById(id);
		return ResponseEntity.ok().body(new PlanilhaControleDTO(controle));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PlanilhaControle> insert(@Valid @RequestBody PlanilhaControle controle){
		controle = controleService.insert(controle);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(controle.getId()).toUri();
		return ResponseEntity.created(uri).body(controle); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PlanilhaControleDTO> upDate(@PathVariable Long id, @RequestBody PlanilhaControleDTO controleDTO){
		PlanilhaControle newControle = controleService.upDate(id, controleDTO);
		return ResponseEntity.ok().body(new PlanilhaControleDTO(newControle));
	}
}
