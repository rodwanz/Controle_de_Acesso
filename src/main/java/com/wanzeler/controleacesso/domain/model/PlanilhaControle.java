package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PlanilhaControle {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;

	@NotBlank
	@Size(max = 60)
	private String motivo;

	@NotBlank
	@Size(max = 60)
	private String empresa;

	@NotBlank
	@Size(max = 11)
	private String documento;

	@NotBlank
	@Size(max = 5)
	private String blocoApartamento;
	
	private OffsetDateTime horaDeEntrada;
	private OffsetDateTime horaDeSaida;
	
}
