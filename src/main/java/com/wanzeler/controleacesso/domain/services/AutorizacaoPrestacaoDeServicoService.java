package com.wanzeler.controleacesso.domain.services;

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
	public AutorizacaoPrestacaoDeServico inserindoAutorizacao(AutorizacaoPrestacaoDeServico autoriza) {
		autoriza.setId(null);
		return atoAutorizacaoPrestacaoDeServicoRepository.save(autoriza);
	}
	
	@Transactional
	public AutorizacaoPrestacaoDeServico buscandoId(Long id){
		return atoAutorizacaoPrestacaoDeServicoRepository.findById(id)
				.orElseThrow(() -> new AutorizacaoPrestacaoDeServicoException(id));

	}
}
