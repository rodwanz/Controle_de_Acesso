package com.wanzeler.controleacesso.controllers.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wanzeler.controleacesso.services.exception.PlanilhaControleNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(PlanilhaControleNotFoundException.class)
	public ResponseEntity<StandardError> planilhaControleNotFoundException(PlanilhaControleNotFoundException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError
				(System.currentTimeMillis(), status.value(), 
						"Id não encontrado", "Corrigir erro", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
