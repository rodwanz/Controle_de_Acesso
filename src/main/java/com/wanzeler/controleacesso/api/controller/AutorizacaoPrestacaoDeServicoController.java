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

import com.wanzeler.controleacesso.api.dto.AutorizacaoPrestacaoDeServicoDTO;
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
	public AutorizacaoPrestacaoDeServicoDTO autorizaServico(@Valid @RequestBody 
			AutorizacaoPrestacaoDeServico autoriza){
		return toModel(autorizacaoPrestacaoDeServicoService.inserindoAutorizacao(autoriza)); 
	}
	
	@GetMapping
	public List<AutorizacaoPrestacaoDeServicoDTO> todasAsAutorizacoes(){
		return toCollectionDTO(autorizacaoPrestacaoDeServicoRepository.findAll());		
	}
	
	@GetMapping(value = "/{id}")
	public AutorizacaoPrestacaoDeServicoDTO autorizacaoPorId(@PathVariable Long id) {
		AutorizacaoPrestacaoDeServico autoriza = autorizacaoPrestacaoDeServicoService.buscandoId(id);
		
		return toModel(autoriza);

	}

	private AutorizacaoPrestacaoDeServicoDTO toModel(AutorizacaoPrestacaoDeServico autoriza) {
		AutorizacaoPrestacaoDeServicoDTO autorizaDTO = new AutorizacaoPrestacaoDeServicoDTO();
		autorizaDTO.setId(autoriza.getId());
		autorizaDTO.setApartamentoAtendido(autoriza.getApartamentoAtendido());
		autorizaDTO.setResponsavelPeloServico(autoriza.getResponsavelPeloServico());
		autorizaDTO.setDocumento(autoriza.getDocumento());
		autorizaDTO.setHoraDeAcesso(autoriza.getHoraDeAcesso());
		return autorizaDTO;
	}
	
	private List<AutorizacaoPrestacaoDeServicoDTO> toCollectionDTO(List<AutorizacaoPrestacaoDeServico> autorizacoes){
		return autorizacoes.stream()
				.map(autoriza -> toModel(autoriza))
				.collect(Collectors.toList());
	}
}
