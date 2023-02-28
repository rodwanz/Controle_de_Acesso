package com.wanzeler.controleacesso.api.dto.input;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorizacaoUsoDeVagaInput {
	
	@NotBlank
	private String aptoCedente;
	
	@NotBlank
	private String placaMorador;
	
	@NotBlank
	private String aptoBeneficiado;
	
	@NotBlank
	private String placaVisitante;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String nomeMotorista;
	
	private OffsetDateTime acessoCondominio;

}
