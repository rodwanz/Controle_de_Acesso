package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
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
public class AutorizacaoPrestacaoDeServico {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "apartamento_atendido")
	@Size(max = 60)
	private String apartamentoAtendido;
	
	@NotBlank
	@Column(name = "responsavel_pelo_servico")
	@Size(max = 60)
	private String responsavelPeloServico;
	
	@NotBlank
	@Column(name = "documento")
	@Size(max = 60)
	private String documento;
	
	private OffsetDateTime horaDeAcesso;
	
}
