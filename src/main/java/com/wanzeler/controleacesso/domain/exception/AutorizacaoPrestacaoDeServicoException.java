package com.wanzeler.controleacesso.domain.exception;

public class AutorizacaoPrestacaoDeServicoException extends AutorizacaoUsoDeVagaException{
	private static final long serialVersionUID = 1L;

	public AutorizacaoPrestacaoDeServicoException(String msg) {
		super(msg);
	}
	
	public AutorizacaoPrestacaoDeServicoException(Long id) {
		this(String.format("Prestador de serviço não autorizado %d", id));
	}
}
