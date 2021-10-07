package com.projeto.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.urna.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Integer> {

}
