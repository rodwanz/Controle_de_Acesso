package com.wanzeler.controleacesso.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzeler.controleacesso.domain.dto.PlanilhaControleDTO;
import com.wanzeler.controleacesso.domain.model.PlanilhaControle;
import com.wanzeler.controleacesso.domain.repositories.PlanilhaControleRepository;
import com.wanzeler.controleacesso.services.exception.PlanilhaControleNotFoundException;
@Service
public class PlanilhaControleCadastroService {
	
	@Autowired
	private PlanilhaControleRepository controleRepository;
	
	public PlanilhaControle findById(Long id){
		Optional<PlanilhaControle> controle = controleRepository.findById(id);
		return controle.orElseThrow(() -> new PlanilhaControleNotFoundException(
				"Planilhamento não encontrado por Id: " + id + ", Dados: " 
		+ PlanilhaControle.class.getName()));
	}
	
	public List<PlanilhaControle> findAll() {
		return controleRepository.findAll();
	}
	
	public PlanilhaControle insert(PlanilhaControle controle) {
		controle.setId(null);
		return controleRepository.save(controle);
	}

	public PlanilhaControle upDate(Long id, PlanilhaControleDTO controleDTO) {
		PlanilhaControle controle = findById(id);
		controle.setNome(controleDTO.getNome());
		controle.setMotivo(controleDTO.getMotivo());
		controle.setEmpresa(controleDTO.getEmpresa());
		controle.setDocumento(controleDTO.getDocumento());
		controle.setBlocoApartamento(controleDTO.getBlocoApartamento());
	
		return controleRepository.save(controle);
	}
}