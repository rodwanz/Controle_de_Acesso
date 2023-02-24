package com.wanzeler.controleacesso.domain.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzeler.controleacesso.domain.exception.AutorizacaoPrestacaoDeServicoException;
import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;
import com.wanzeler.controleacesso.domain.repositories.AutorizacaoPrestacaoDeServicoRepository;

@Service
public class AutorizacaoPrestacaoDeServicoService {
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoRepository atoAutorizacaoPrestacaoDeServicoRepository ;
	
	@Transactional
	public AutorizacaoPrestacaoDeServico insert(AutorizacaoPrestacaoDeServico autoriza) {
		autoriza.setId(null);
		return atoAutorizacaoPrestacaoDeServicoRepository.save(autoriza);
	}
	
	@Transactional
	public AutorizacaoPrestacaoDeServico findById(Long id){
		Optional<AutorizacaoPrestacaoDeServico> autoriza = atoAutorizacaoPrestacaoDeServicoRepository.findById(id);
		return autoriza
				.orElseThrow(() -> new AutorizacaoPrestacaoDeServicoException(
				"Autorização não encontrado: " + id + ", Buscar novamente: " 
		+ AutorizacaoPrestacaoDeServico.class.getName()));
	}
	
	@Transactional
	public List<AutorizacaoPrestacaoDeServico> findAll() {
		return atoAutorizacaoPrestacaoDeServicoRepository.findAll();
	}
}
