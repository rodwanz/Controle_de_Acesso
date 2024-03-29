package com.wanzeler.controleacesso.api.dto;

import java.time.OffsetDateTime;

import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorizacaoPrestacaoDeServicoDTO {

	private String apartamentoAtendido;
	private String responsavelPeloServico;
	private String documento;
	private OffsetDateTime horaDeAcesso;
	
	public AutorizacaoPrestacaoDeServicoDTO(AutorizacaoPrestacaoDeServico autoriza) {
		apartamentoAtendido = autoriza.getApartamentoAtendido();
		responsavelPeloServico = autoriza.getResponsavelPeloServico();
		documento = autoriza.getDocumento();
		horaDeAcesso = autoriza.getHoraDeAcesso();
	}

}
