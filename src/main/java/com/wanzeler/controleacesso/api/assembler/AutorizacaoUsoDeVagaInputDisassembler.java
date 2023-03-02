package com.wanzeler.controleacesso.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.input.AutorizacaoUsoDeVagaInput;
import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;

@Component
public class AutorizacaoUsoDeVagaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AutorizacaoUsoDeVaga toDomainObject(AutorizacaoUsoDeVagaInput vagaInput) {
		return modelMapper.map(vagaInput, AutorizacaoUsoDeVaga.class);
	}
}
