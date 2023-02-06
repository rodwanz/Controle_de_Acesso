package com.wanzeler.controleacesso.domain.exception;

public class PlanilhaControleNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PlanilhaControleNotFoundException(String msg) {
		super(msg);
	}
}
