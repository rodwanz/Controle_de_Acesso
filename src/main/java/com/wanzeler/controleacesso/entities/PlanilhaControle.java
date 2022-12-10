package com.wanzeler.controleacesso.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "planilha_controle")
public class PlanilhaControle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(name = "Motivo")
	private String motivo;
	
	@Column(name = "Empresa")
	private String empresa;
	
	@Column(name = "RG_CPF")
	private String documento;
	
	@Column(name = "Destino")
	private String destino;
	
	@Column(name = "Data")
	private LocalDate data;
	
	@Column(name = "hora_de_entrada")
	private String horaDeEntrada;
	
	@Column(name = "hora_de_saida")
	private String horaDeSaida;

	public PlanilhaControle() {
		super();
	}

	public PlanilhaControle(Long id, String nome, String motivo, String empresa, String documento, String destino,
			LocalDate data, String horaDeEntrada, String horaDeSaida) {
		super();
		this.id = id;
		this.nome = nome;
		this.motivo = motivo;
		this.empresa = empresa;
		this.documento = documento;
		this.destino = destino;
		this.data = data;
		this.horaDeEntrada = horaDeEntrada;
		this.horaDeSaida = horaDeSaida;
	}	
}
