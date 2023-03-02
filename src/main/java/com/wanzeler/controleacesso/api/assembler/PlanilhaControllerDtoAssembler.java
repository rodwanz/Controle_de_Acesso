package com.wanzeler.controleacesso.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.PlanilhaControleDTO;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;

@Component
public class PlanilhaControllerDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PlanilhaControleDTO toModel(PlanilhaControle controle) {
		return modelMapper.map(controle, PlanilhaControleDTO.class);
	}
	
	public List<PlanilhaControleDTO> toCollectionDTO(List<PlanilhaControle> planilhaControles){
		return planilhaControles.stream()
				.map(controle -> toModel(controle))
				.collect(Collectors.toList());
	}
}
