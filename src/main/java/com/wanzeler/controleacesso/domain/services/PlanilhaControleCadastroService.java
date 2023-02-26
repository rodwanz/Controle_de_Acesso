package com.wanzeler.controleacesso.domain.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzeler.controleacesso.domain.exception.PlanilhaControleException;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;
import com.wanzeler.controleacesso.domain.repositories.PlanilhaControleRepository;

@Service
public class PlanilhaControleCadastroService {

	@Autowired
	private PlanilhaControleRepository controleRepository;

	@Transactional
	public PlanilhaControle buscandoPorId(Long id) {
		return controleRepository.findById(id).orElseThrow(() -> new PlanilhaControleException(
				"Id não encontrado na planilha: " + id + ", Buscar novamnete: " 
		+ PlanilhaControle.class.getName()));
	}
	
	@Transactional
	public PlanilhaControle salvandoTodos(PlanilhaControle controle) {
		return controleRepository.save(controle);
	}
}