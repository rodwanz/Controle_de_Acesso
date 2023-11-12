package com.wanzeler.controleacesso.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wanzeler.controleacesso.domain.exception.PlanilhaControleException;

@ControllerAdvice
public class ApiControleExcecao{
	
	@ExceptionHandler(PlanilhaControleException.class)
	public ResponseEntity<?> tratandoControleExcption(
			PlanilhaControleException e) {
		Problema problema = Problema.builder()
				.dataHora(LocalDateTime.now())
				.mensagem(e.getMessage())
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problema);
	}
}
