package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.wanzeler.controleacesso.api.dto.input.AutorizacaoPrestacaoDeServicoInput;

import lombok.EqualsAndHashCode;

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

	public String getApartamentoAtendido() {
		return apartamentoAtendido;
	}

	public void setApartamentoAtendido(String apartamentoAtendido) {
		this.apartamentoAtendido = apartamentoAtendido;
	}

	public String getResponsavelPeloServico() {
		return responsavelPeloServico;
	}

	public void setResponsavelPeloServico(String responsavelPeloServico) {
		this.responsavelPeloServico = responsavelPeloServico;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public OffsetDateTime getHoraDeAcesso() {
		return horaDeAcesso;
	}

	public void setHoraDeAcesso(OffsetDateTime horaDeAcesso) {
		this.horaDeAcesso = horaDeAcesso;
	}

	public void setId(AutorizacaoPrestacaoDeServicoInput autorizacaoPrestacaoDeServicoInput) {}	
}
