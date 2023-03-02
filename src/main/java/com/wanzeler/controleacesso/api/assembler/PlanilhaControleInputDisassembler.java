package com.wanzeler.controleacesso.api.assembler;

import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.input.PlanilhaControleInput;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;

@Component
public class PlanilhaControleInputDisassembler {
	
	public PlanilhaControle toDomainObject(PlanilhaControleInput controleInput) {
		PlanilhaControle controle = new PlanilhaControle();
		controle.setNome(controleInput.getNome());
		controle.setMotivo(controleInput.getMotivo());
		controle.setEmpresa(controleInput.getEmpresa()); 
		controle.setDocumento(controleInput.getDocumento());
		controle.setDestino(controleInput.getDestino());
		controle.setDataAcesso(controleInput.getDataAcesso());
		return controle;
	}
}
