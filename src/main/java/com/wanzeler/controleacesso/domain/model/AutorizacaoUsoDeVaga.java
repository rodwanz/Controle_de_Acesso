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

import com.wanzeler.controleacesso.api.dto.input.AutorizacaoUsoDeVagaInput;

import lombok.EqualsAndHashCode;

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
	@Size(max = 6)
	@Column(name = "apto_beneficiado")
	private String aptoBeneficiado;
	
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

	public String getAptoCedente() {
		return aptoCedente;
	}

	public void setAptoCedente(String aptoCedente) {
		this.aptoCedente = aptoCedente;
	}

	public String getPlacaMorador() {
		return placaMorador;
	}

	public void setPlacaMorador(String placaMorador) {
		this.placaMorador = placaMorador;
	}

	public String getAptoBeneficiado() {
		return aptoBeneficiado;
	}

	public void setAptoBeneficiado(String aptoBeneficiado) {
		this.aptoBeneficiado = aptoBeneficiado;
	}

	public String getPlacaVisitante() {
		return placaVisitante;
	}

	public void setPlacaVisitante(String placaVisitante) {
		this.placaVisitante = placaVisitante;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public OffsetDateTime getAcessoCondominio() {
		return acessoCondominio;
	}

	public void setAcessoCondominio(OffsetDateTime acessoCondominio) {
		this.acessoCondominio = acessoCondominio;
	}

	public void setId(AutorizacaoUsoDeVagaInput autorizacaoUsoDeVagaInput) {}

}
