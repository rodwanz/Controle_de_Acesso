package com.wanzeler.controleacesso.api.assembler;

import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.input.AutorizacaoPrestacaoDeServicoInput;
import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;

@Component
public class AutorizacaoPrestacaoDeServicoInputDisassembler {
	
	public AutorizacaoPrestacaoDeServico toDomainObject(AutorizacaoPrestacaoDeServicoInput autorizaInput) {
		AutorizacaoPrestacaoDeServico autoriza = new AutorizacaoPrestacaoDeServico();
		autoriza.setApartamentoAtendido(autorizaInput.getApartamentoAtendido());
		autoriza.setResponsavelPeloServico(autorizaInput.getResponsavelPeloServico());
		autoriza.setDocumento(autorizaInput.getDocumento()); 
		autoriza.setHoraDeAcesso(autorizaInput.getHoraDeAcesso());		
		return autoriza;
	}
}
