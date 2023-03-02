package com.wanzeler.controleacesso.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.AutorizacaoPrestacaoDeServicoDTO;
import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;

@Component
public class AutorizacaoPrestacaoDeServicoDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AutorizacaoPrestacaoDeServicoDTO toModel(AutorizacaoPrestacaoDeServico autoriza) {
		return modelMapper.map(autoriza, AutorizacaoPrestacaoDeServicoDTO.class);
	}
	
	public List<AutorizacaoPrestacaoDeServicoDTO> toCollectionDTO(List<AutorizacaoPrestacaoDeServico> autorizacoes){
		return autorizacoes.stream()
				.map(autoriza -> toModel(autoriza))
				.collect(Collectors.toList());
	}
}
