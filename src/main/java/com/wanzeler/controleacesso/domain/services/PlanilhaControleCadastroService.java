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
	public PlanilhaControle findById(Long id){
		Optional<PlanilhaControle> controle = controleRepository.findById(id);
		return controle
				.orElseThrow(() -> new PlanilhaControleException(
				"Planilhamento não encontrado por Id: " + id + ", Dados: " 
		+ PlanilhaControle.class.getName()));
	}
	
	@Transactional
	public List<PlanilhaControle> findAll() {
		return controleRepository.findAll();
	}
	
	@Transactional
	public PlanilhaControle insert(PlanilhaControle controle) {
		controle.setId(null);
		return controleRepository.save(controle);
	}

	public PlanilhaControle upDate(Long id, PlanilhaControle controle) {
		PlanilhaControle newControle = findById(id);
		atualizando(newControle, controle);
		return controleRepository.save(newControle);
	}

	private void atualizando(PlanilhaControle newControle, PlanilhaControle controle) {
		newControle.setId(controle.getId());
		newControle.setNome(controle.getNome());
		newControle.setMotivo(controle.getMotivo());
		newControle.setEmpresa(controle.getEmpresa());
		newControle.setDocumento(controle.getDocumento());
		newControle.setDestino(controle.getDestino());
		newControle.setDataAcesso(controle.getDataAcesso());
		
	}
}