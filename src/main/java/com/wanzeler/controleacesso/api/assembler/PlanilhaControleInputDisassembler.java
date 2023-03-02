package com.wanzeler.controleacesso.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.input.PlanilhaControleInput;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;

@Component
public class PlanilhaControleInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PlanilhaControle toDomainObject(PlanilhaControleInput controleInput) {
		return modelMapper.map(controleInput, PlanilhaControle.class);
	}
}
