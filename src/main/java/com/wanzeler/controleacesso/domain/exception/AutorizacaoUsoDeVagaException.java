package com.wanzeler.controleacesso.domain.exception;

public class AutorizacaoUsoDeVagaException extends PlanilhaControleException{
	private static final long serialVersionUID = 1L;

	public AutorizacaoUsoDeVagaException(String msg) {
		super(msg);
	}
	
	public AutorizacaoUsoDeVagaException(Long id) {
		this(String.format("Id errado, corrigir %d", id));
	}
}
