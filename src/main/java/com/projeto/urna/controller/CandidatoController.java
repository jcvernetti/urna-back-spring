package com.projeto.urna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.form.CandidatoForm;
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
	
	@GetMapping("/{idCandidato}")
	public ResponseEntity<Candidato> getCandidato(@PathVariable int idCandidato){
		Optional<Candidato> candidatoExistente = candidatoRepository.findById(idCandidato);
		
		if(candidatoExistente.isPresent()) {
			return ResponseEntity.ok().body(candidatoExistente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Candidato> postCandidato(@RequestBody CandidatoForm candidatoForm){
		Candidato candidato = candidatoForm.converter();
		
		return ResponseEntity.ok().body(candidatoRepository.save(candidato));
	}
}
