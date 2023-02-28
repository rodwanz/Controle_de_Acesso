package com.wanzeler.controleacesso.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wanzeler.controleacesso.api.dto.PlanilhaControleDTO;
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
	public List<PlanilhaControleDTO> buscandodoTodos(){
		return toCollectionDTO(planilhaControleRepository.findAll());		
	}
	
	@GetMapping(value = "/{id}")
	public PlanilhaControleDTO buscandoPorIdEntrega(@PathVariable Long id) {
		PlanilhaControle controle = controleService.buscandoPorId(id);
		
		return toModel(controle);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlanilhaControleDTO inserindoTabela(@Valid @RequestBody 
			PlanilhaControle controle){
		return toModel(controleService.salvandoTodos(controle));
	}
	
	@PutMapping(value = "/{id}")
	public PlanilhaControleDTO atualizando(@PathVariable Long id, 
			@RequestBody PlanilhaControle controle){
		PlanilhaControle newControle = controleService.buscandoPorId(id);
		return toModel(newControle);
	}
	
	private PlanilhaControleDTO toModel(PlanilhaControle controle) {
		PlanilhaControleDTO planilhaControleDTO = new PlanilhaControleDTO();
		planilhaControleDTO.setId(controle.getId());
		planilhaControleDTO.setNome(controle.getNome());
		planilhaControleDTO.setMotivo(controle.getMotivo());
		planilhaControleDTO.setEmpresa(controle.getEmpresa());
		planilhaControleDTO.setDocumento(controle.getDocumento());
		planilhaControleDTO.setDestino(controle.getDestino());
		planilhaControleDTO.setDataAcesso(controle.getDataAcesso());
		return planilhaControleDTO;
	}
	
	private List<PlanilhaControleDTO> toCollectionDTO(List<PlanilhaControle> planilhaControles){
		return planilhaControles.stream()
				.map(controle -> toModel(controle))
				.collect(Collectors.toList());
	}
}

