package com.wanzeler.controleacesso.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.PlanilhaControleDTO;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;

@Component
public class PlanilhaControllerDtoAssembler {
	
	public PlanilhaControleDTO toModel(PlanilhaControle controle) {
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
	
	public List<PlanilhaControleDTO> toCollectionDTO(List<PlanilhaControle> planilhaControles){
		return planilhaControles.stream()
				.map(controle -> toModel(controle))
				.collect(Collectors.toList());
	}

}
