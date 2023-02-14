package com.wanzeler.controleacesso.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzeler.controleacesso.domain.model.AutorizacaoPrestacaoDeServico;
import com.wanzeler.controleacesso.domain.repositories.AutorizacaoPrestacaoDeServicoRepository;

@Service
public class AutorizacaoPrestacaoDeServicoService {
	
	@Autowired
	private AutorizacaoPrestacaoDeServicoRepository atoAutorizacaoPrestacaoDeServicoRepository ;
	
	public AutorizacaoPrestacaoDeServico insert(AutorizacaoPrestacaoDeServico autoriza) {
		autoriza.setId(null);
		return atoAutorizacaoPrestacaoDeServicoRepository.save(autoriza);
	}
}