package com.wanzeler.controleacesso.domain.dto;

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
	
	private Long id;
	private String nome;
	private String motivo;
	private String empresa;
	private String documento;
	private String destino;
	private OffsetDateTime dataAcesso;
	
	public PlanilhaControleDTO(PlanilhaControle controle) {
		id = controle.getId();
		nome = controle.getNome();
		motivo = controle.getMotivo();
		empresa = controle.getEmpresa();
		documento = controle.getDocumento();
		destino = controle.getDestino();
		dataAcesso = controle.getDataAcesso();
	}
}
