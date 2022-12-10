package com.wanzeler.controleacesso.resources;
import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanilhaControleResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("nome_pessoa")
	private String nome;
	
	@JsonProperty("motivo")
	private String motivo;
	
	@JsonProperty("Empresa")
	private String empresa;
	
	@JsonProperty("Documento")
	private Integer documento;
	
	@JsonProperty("Destino")
	private Integer destino;
	
	@JsonProperty("Data")
	private LocalDate data;
	
	@JsonProperty("Horário_de_entrada")
	private String horaDeEntrada;
	
	@JsonProperty("Horário_de_saída")
	private String horaDeSaida;

}