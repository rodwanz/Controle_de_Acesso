package com.wanzeler.controleacesso.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.AutorizacaoUsoDeVagaDTO;
import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;

@Component
public class AutorizacaoUsoVagaDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;

	public AutorizacaoUsoDeVagaDTO toModel(AutorizacaoUsoDeVaga vaga) {
		return modelMapper.map(vaga, AutorizacaoUsoDeVagaDTO.class);
	}

	public List<AutorizacaoUsoDeVagaDTO> toCollectionDTO(List<AutorizacaoUsoDeVaga> vagas) {
		return vagas.stream()
				.map(vaga -> toModel(vaga))
				.collect(Collectors.toList());
	}
}
