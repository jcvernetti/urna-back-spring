package com.projeto.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.urna.model.Votacao;

public interface VotacaoRepository  extends JpaRepository<Votacao, Integer> {

}
