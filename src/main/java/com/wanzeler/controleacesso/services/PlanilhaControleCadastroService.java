package com.wanzeler.controleacesso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzeler.controleacesso.dto.PlanilhaControleDTO;
import com.wanzeler.controleacesso.entities.PlanilhaControle;
import com.wanzeler.controleacesso.repositories.PlanilhaControleRepository;
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
		controle.setDestino(controleDTO.getDestino());
		controle.setData(controleDTO.getData());
		controle.setHoraDeEntrada(controleDTO.getHoraDeEntrada());
		controle.setHoraDeSaida(controleDTO.getHoraDeSaida());
		return controleRepository.save(controle);
	}
}