package com.wanzeler.controleacesso.api.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.wanzeler.controleacesso.api.dto.AutorizacaoUsoDeVagaDTO;
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
	public AutorizacaoUsoDeVagaDTO vagaLivre(@Valid @RequestBody 
			AutorizacaoUsoDeVaga vaga){
		return toModel(vagaService.inserindoVaga(vaga)); 
	}
	
	@GetMapping
	public List<AutorizacaoUsoDeVagaDTO> buscandoTodosOsCadastros(){
		return toCollectionDTO(vagaRepository.findAll());		
	}
	
	@GetMapping(value = "/{id}")
	public AutorizacaoUsoDeVagaDTO buscandoVagaPorId(@PathVariable Long id) {
		AutorizacaoUsoDeVaga vaga = vagaService.buscandoId(id);
		
		return toModel(vaga);
		
	}

	private AutorizacaoUsoDeVagaDTO toModel(AutorizacaoUsoDeVaga vaga) {
		AutorizacaoUsoDeVagaDTO vagaDTO = new AutorizacaoUsoDeVagaDTO();
		vagaDTO.setId(vaga.getId());
		vagaDTO.setAptoCedente(vaga.getAptoCedente());
		vagaDTO.setPlacaMorador(vaga.getPlacaMorador());
		vagaDTO.setAptoBeneficiado(vaga.getAptoBeneficiado());
		vagaDTO.setPlacaVisitante(vaga.getPlacaVisitante());
		vagaDTO.setMarca(vaga.getMarca());
		vagaDTO.setModelo(vaga.getModelo());
		vagaDTO.setNomeMotorista(vaga.getNomeMotorista());
		vagaDTO.setAcessoCondominio(vaga.getAcessoCondominio());
		return vagaDTO;
	}
	
	private List<AutorizacaoUsoDeVagaDTO> toCollectionDTO(List<AutorizacaoUsoDeVaga> vagas){
		return vagas.stream()
				.map(vaga -> toModel(vaga))
				.collect(Collectors.toList());
	}
}
