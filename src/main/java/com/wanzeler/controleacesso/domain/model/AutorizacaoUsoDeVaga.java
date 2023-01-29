package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AutorizacaoUsoDeVaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "autoriza_apto_cedente")
	private String aptoCedente;
	
	@NotBlank
	@Column(name = "autoriza_placa_morador")
	private String placaMorador;
	
	@NotBlank
	@Column(name = "autoriza_apto_beneficiado")
	private String aptoBenficiado;
	
	@NotBlank
	@Column(name = "autoriza_placa_visitante")
	private String placaVisitante;
	
	@NotNull
	@Column(name = "autoriza_marca")
	private String marca;
	
	@NotNull
	@Column(name = "autoriza_modelo")
	private String modelo;

	@NotBlank
	@Column(name = "autoriza_nome_motorista")
	private String nomeMotorista;
	
	private OffsetDateTime horaDeEntrada;
	private OffsetDateTime horaDeSaida;

}
