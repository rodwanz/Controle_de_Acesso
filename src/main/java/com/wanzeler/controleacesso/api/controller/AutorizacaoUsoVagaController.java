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

import com.wanzeler.controleacesso.api.assembler.AutorizacaoUsoVagaDtoAssembler;
import com.wanzeler.controleacesso.api.dto.AutorizacaoUsoDeVagaDTO;
import com.wanzeler.controleacesso.api.dto.input.AutorizacaoUsoDeVagaInput;
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
	
	@Autowired
	private AutorizacaoUsoVagaDtoAssembler autorizacaoDtoAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AutorizacaoUsoDeVagaDTO vagaLivre(@Valid @RequestBody 
			AutorizacaoUsoDeVagaInput vagaInput){
		AutorizacaoUsoDeVaga vaga = toDomainObject(vagaInput);
		return autorizacaoDtoAssembler.toModel(vagaService.inserindoVaga(vaga)); 
	}
	
	@GetMapping
	public List<AutorizacaoUsoDeVagaDTO> buscandoTodosOsCadastros(){
		return autorizacaoDtoAssembler.toCollectionDTO(vagaRepository.findAll());		
	}
	
	@GetMapping(value = "/{id}")
	public AutorizacaoUsoDeVagaDTO buscandoVagaPorId(@PathVariable Long id) {
		AutorizacaoUsoDeVaga vaga = vagaService.buscandoId(id);
		
		return autorizacaoDtoAssembler.toModel(vaga);
		
	}
	
	private AutorizacaoUsoDeVaga toDomainObject(AutorizacaoUsoDeVagaInput vagaInput) {
		AutorizacaoUsoDeVaga vaga = new AutorizacaoUsoDeVaga();
		vaga.setAptoCedente(vagaInput.getAptoCedente());
		vaga.setPlacaMorador(vagaInput.getPlacaMorador());
		vaga.setAptoBeneficiado(vagaInput.getAptoBeneficiado()); 
		vaga.setPlacaVisitante(vagaInput.getPlacaVisitante());
		vaga.setMarca(vagaInput.getMarca());
		vaga.setModelo(vagaInput.getModelo());
		vaga.setNomeMotorista(vagaInput.getNomeMotorista());
		vaga.setAcessoCondominio(vagaInput.getAcessoCondominio());
		return vaga;
	}
}
