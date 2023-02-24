package com.wanzeler.controleacesso.domain.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzeler.controleacesso.domain.exception.AutorizacaoUsoDeVagaException;
import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;
import com.wanzeler.controleacesso.domain.repositories.AutorizacaoUsoDeVagaRepository;

@Service
public class AutorizacaoUsoDeVagaService {
	
	@Autowired
	AutorizacaoUsoDeVagaRepository vagaRepository;
	
	@Transactional
	public AutorizacaoUsoDeVaga insert(AutorizacaoUsoDeVaga vaga) {
		vaga.setId(null);
		return vagaRepository.save(vaga);
	}
	
	@Transactional
	public AutorizacaoUsoDeVaga findById(Long id){
		Optional<AutorizacaoUsoDeVaga> vaga = vagaRepository.findById(id);
		return vaga
				.orElseThrow(() -> new AutorizacaoUsoDeVagaException(
				"Vaga não esta livre: " + id + ", Buscar outra vaga: " 
		+ PlanilhaControle.class.getName()));
	}
	
	@Transactional
	public List<AutorizacaoUsoDeVaga> findAll() {
		return vagaRepository.findAll();
	}
}
