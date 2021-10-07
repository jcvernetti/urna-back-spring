package com.projeto.urna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.model.Candidato;
import com.projeto.urna.repository.CandidatoRepository;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	CandidatoRepository candidatoRepository;
	
	@GetMapping
	public ResponseEntity<List<Candidato>> getCandidatos(){
		return ResponseEntity.ok().body(candidatoRepository.findAll());
	}
}
