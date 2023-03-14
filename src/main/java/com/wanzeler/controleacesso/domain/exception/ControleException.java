package com.wanzeler.controleacesso.domain.exception;

public class ControleException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ControleException(String msg) {
		super(msg);
	}
	
	public ControleException(String mensagen, Throwable causa) {
		super(mensagen,causa);
	}
}
