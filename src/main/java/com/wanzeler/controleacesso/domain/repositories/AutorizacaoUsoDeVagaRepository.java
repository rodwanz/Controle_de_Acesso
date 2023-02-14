package com.wanzeler.controleacesso.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanzeler.controleacesso.domain.model.AutorizacaoUsoDeVaga;

@Repository
public interface AutorizacaoUsoDeVagaRepository extends JpaRepository<AutorizacaoUsoDeVaga, Long>{

}
