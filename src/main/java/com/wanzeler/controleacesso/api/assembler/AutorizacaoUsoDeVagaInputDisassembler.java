package com.wanzeler.controleacesso.api.assembler;

import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.input.AutorizacaoUsoDeVagaInput;
import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;

@Component
public class AutorizacaoUsoDeVagaInputDisassembler {
	
	public AutorizacaoUsoDeVaga toDomainObject(AutorizacaoUsoDeVagaInput vagaInput) {
		AutorizacaoUsoDeVaga vaga = new AutorizacaoUsoDeVaga();
		vaga.setAptoCedente(vagaInput.getAptoCedente());
		vaga.setPlacaMorador(vagaInput.getPlacaMorador());
		vaga.setAptoBeneficiado(vagaInput.getAptoBeneficiado()); 
		vaga.setPlacaVisitante(vagaInput.getPlacaVisitante());
		vaga.setMarca(vagaInput.getMarca());
		vaga.setModelo(vagaInput.getModelo());
		vaga.setNomeMotorista(vagaInput.getNomeMotorista());
		vaga.setAcessoCondominio(vagaInput.getAcessoCondominio());
		return vaga;
	}
}
