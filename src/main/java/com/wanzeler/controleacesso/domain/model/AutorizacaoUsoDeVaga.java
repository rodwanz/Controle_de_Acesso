package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

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
	
	@NotBlank
	@Size(max = 60)
	private String aptoCedente;
	
	@NotBlank
	@Size(max = 60)
	private String placaMorador;
	
	@NotNull(message = "O valor não pode ser nulo ou vazio")
	@Size(max = 5)
	private String aptoBenficiado;
	
	@NotBlank
	@Size(max = 60)
	private String placaVisitante;
	
	@NotBlank
	@Size(max = 60)
	private String marca;
	
	@NotBlank
	@Size(max = 60)
	private String modelo;

	@NotBlank
	@Size(max = 60)
	private String nomeMotorista;
	
	private OffsetDateTime acessoCondominio;

}
