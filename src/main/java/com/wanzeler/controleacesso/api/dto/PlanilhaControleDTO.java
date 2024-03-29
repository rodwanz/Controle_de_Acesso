package com.wanzeler.controleacesso.api.dto;

import java.time.OffsetDateTime;

import com.wanzeler.controleacesso.domain.model.PlanilhaControle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanilhaControleDTO {

	private String nome;
	private String motivo;
	private String empresa;
	private String documento;
	private String destino;
	private OffsetDateTime dataAcesso;
	
	public PlanilhaControleDTO(PlanilhaControle controle) {
		nome = controle.getNome();
		motivo = controle.getMotivo();
		empresa = controle.getEmpresa();
		documento = controle.getDocumento();
		destino = controle.getDestino();
		dataAcesso = controle.getDataAcesso();
	}	
}
