package com.wanzeler.controleacesso.api.dto.input;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanilhaControleInput {

	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String motivo;
	
	@NotBlank
	private String empresa;
	
	@NotBlank
	private String documento;
	
	@NotBlank
	private String destino;
	
	
	private OffsetDateTime dataAcesso;

}
