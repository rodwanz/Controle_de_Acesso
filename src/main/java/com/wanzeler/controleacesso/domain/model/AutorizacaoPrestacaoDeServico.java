package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AutorizacaoPrestacaoDeServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "autoriza_bloco_apartamento")
	private String blocoApartamento;
	
	@NotBlank
	@Column(name = "autoriza_responsavel")
	private String responsavel;
	
	@NotBlank
	@Column(name = "autoriza_documento")
	private String documento;
	
	private OffsetDateTime horaDeEntrada;
	private OffsetDateTime horaDeSaida;
	
	
	

}
