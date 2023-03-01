package com.wanzeler.controleacesso.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.AutorizacaoPrestacaoDeServicoDTO;
import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;

@Component
public class AutorizacaoPrestacaoDeServicoDtoAssembler {
	
	public AutorizacaoPrestacaoDeServicoDTO toModel(AutorizacaoPrestacaoDeServico autoriza) {
		AutorizacaoPrestacaoDeServicoDTO autorizaDTO = new AutorizacaoPrestacaoDeServicoDTO();
		autorizaDTO.setId(autoriza.getId());
		autorizaDTO.setApartamentoAtendido(autoriza.getApartamentoAtendido());
		autorizaDTO.setResponsavelPeloServico(autoriza.getResponsavelPeloServico());
		autorizaDTO.setDocumento(autoriza.getDocumento());
		autorizaDTO.setHoraDeAcesso(autoriza.getHoraDeAcesso());
		return autorizaDTO;
	}
	
	public List<AutorizacaoPrestacaoDeServicoDTO> toCollectionDTO(List<AutorizacaoPrestacaoDeServico> autorizacoes){
		return autorizacoes.stream()
				.map(autoriza -> toModel(autoriza))
				.collect(Collectors.toList());
	}

}
