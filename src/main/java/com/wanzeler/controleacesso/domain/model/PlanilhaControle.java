package com.wanzeler.controleacesso.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.wanzeler.controleacesso.api.dto.input.PlanilhaControleInput;

import lombok.EqualsAndHashCode;

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
	@Size(max = 60)
	private String documento;

	@NotBlank
	@Size(max = 5)
	private String destino;
	
	private OffsetDateTime dataAcesso;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public OffsetDateTime getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(OffsetDateTime dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	public void setId(PlanilhaControleInput planilhaControleInput) {}	
}
