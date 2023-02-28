package com.wanzeler.controleacesso.api.dto.input;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorizacaoPrestacaoDeServicoInput {
	
	@NotBlank
	private String apartamentoAtendido;
	
	@NotBlank
	private String responsavelPeloServico;
	
	@NotBlank
	private String documento;
	
	private OffsetDateTime horaDeAcesso;

}
