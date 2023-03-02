package com.wanzeler.controleacesso.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.input.AutorizacaoPrestacaoDeServicoInput;
import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;

@Component
public class AutorizacaoPrestacaoDeServicoInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AutorizacaoPrestacaoDeServico toDomainObject(AutorizacaoPrestacaoDeServicoInput autorizaInput) {
		return modelMapper.map(autorizaInput, AutorizacaoPrestacaoDeServico.class);
	}
}
