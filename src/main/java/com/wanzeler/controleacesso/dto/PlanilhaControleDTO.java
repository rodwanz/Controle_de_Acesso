package com.wanzeler.controleacesso.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.wanzeler.controleacesso.entities.PlanilhaControle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanilhaControleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String motivo;
	private String empresa;
	private String documento;
	private String destino;
	private LocalDate data;
	private String horaDeEntrada;
	private String horaDeSaida;
	
	public PlanilhaControleDTO(PlanilhaControle controle) {
		id = controle.getId();
		nome = controle.getNome();
		motivo = controle.getMotivo();
		empresa = controle.getEmpresa();
		documento = controle.getDocumento();
		destino = controle.getDestino();
		data = controle.getData();
		horaDeEntrada = controle.getHoraDeEntrada();
		horaDeSaida = controle.getHoraDeSaida();
	}
}
