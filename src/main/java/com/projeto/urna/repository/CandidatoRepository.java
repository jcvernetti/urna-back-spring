package com.projeto.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.urna.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{

}
