package com.wanzeler.controleacesso.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.wanzeler.controleacesso.api.dto.AutorizacaoUsoDeVagaDTO;
import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;

@Component
public class AutorizacaoUsoVagaDtoAssembler {

	public AutorizacaoUsoDeVagaDTO toModel(AutorizacaoUsoDeVaga vaga) {
		AutorizacaoUsoDeVagaDTO vagaDTO = new AutorizacaoUsoDeVagaDTO();
		vagaDTO.setId(vaga.getId());
		vagaDTO.setAptoCedente(vaga.getAptoCedente());
		vagaDTO.setPlacaMorador(vaga.getPlacaMorador());
		vagaDTO.setAptoBeneficiado(vaga.getAptoBeneficiado());
		vagaDTO.setPlacaVisitante(vaga.getPlacaVisitante());
		vagaDTO.setMarca(vaga.getMarca());
		vagaDTO.setModelo(vaga.getModelo());
		vagaDTO.setNomeMotorista(vaga.getNomeMotorista());
		vagaDTO.setAcessoCondominio(vaga.getAcessoCondominio());
		return vagaDTO;
	}

	public List<AutorizacaoUsoDeVagaDTO> toCollectionDTO(List<AutorizacaoUsoDeVaga> vagas) {
		return vagas.stream().map(vaga -> toModel(vaga)).collect(Collectors.toList());
	}

}
