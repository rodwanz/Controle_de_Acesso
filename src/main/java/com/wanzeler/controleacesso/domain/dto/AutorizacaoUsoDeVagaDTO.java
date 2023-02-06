package com.wanzeler.controleacesso.domain.dto;

import java.time.OffsetDateTime;

import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorizacaoUsoDeVagaDTO {
	
	private Long id;
	private String aptoCedente;
	private String placaMorador;
	private String aptoBenficiado;
	private String placaVisitante;
	private String marca;
	private String modelo;
	private String nomeMotorista;
	private OffsetDateTime acessoCondominio;
	
	public AutorizacaoUsoDeVagaDTO(AutorizacaoUsoDeVaga vaga) {
		id = vaga.getId();
		aptoCedente = vaga.getAptoCedente();
		placaMorador = vaga.getPlacaMorador();
		aptoBenficiado = vaga.getAptoBenficiado();
		placaVisitante = vaga.getPlacaVisitante();
		marca = vaga.getMarca();
		modelo = vaga.getModelo();
		nomeMotorista = vaga.getNomeMotorista();
		acessoCondominio = vaga.getAcessoCondominio();
		
	}
}
