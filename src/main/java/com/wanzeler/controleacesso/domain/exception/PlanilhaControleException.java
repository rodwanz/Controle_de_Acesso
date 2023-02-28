package com.wanzeler.controleacesso.domain.exception;

public class PlanilhaControleException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PlanilhaControleException(String msg) {
		super(msg);
	}
	
	public PlanilhaControleException(Long id) {
		this(String.format("Cadastro não encontrado %d", id));
	}
}
