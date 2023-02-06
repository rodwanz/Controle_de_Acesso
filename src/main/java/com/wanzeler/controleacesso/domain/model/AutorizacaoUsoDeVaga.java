package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AutorizacaoUsoDeVaga {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "apto_cedente")
	private String aptoCedente;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "placa_morador")
	private String placaMorador;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "apto_beneficiado")
	private String aptoBenficiado;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "placa_visitante")
	private String placaVisitante;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "marca")
	private String marca;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "modelo")
	private String modelo;

	@NotNull
	@Size(max = 60)
	@Column(name = "nome_motorista")
	private String nomeMotorista;
	
	private OffsetDateTime acessoCondominio;

}
