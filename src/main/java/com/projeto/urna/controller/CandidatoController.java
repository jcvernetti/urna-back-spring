package com.projeto.urna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.form.AlteracaoCandidatoForm;
import com.projeto.urna.form.CandidatoForm;
import com.projeto.urna.model.Candidato;
import com.projeto.urna.model.Votacao;
import com.projeto.urna.repository.CandidatoRepository;
import com.projeto.urna.repository.VotacaoRepository;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	CandidatoRepository candidatoRepository;
	
	@Autowired
	VotacaoRepository votacaoRepository;
	
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
		Optional<Votacao> votacaoExistente = votacaoRepository.findById(candidatoForm.getIdVotacao());
		
		if(votacaoExistente.isPresent()) {
			Votacao votacao = votacaoExistente.get();
			Candidato candidato = candidatoForm.converter();
			
			votacao.addCandidatos(candidato);
			candidato.addVotacoes(votacao);
			
			return ResponseEntity.ok().body(candidato);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{idCandidato}")
	@Transactional
	public ResponseEntity<Candidato> putCandidato(@PathVariable int idCandidato, @RequestBody AlteracaoCandidatoForm candidatoForm){
		Optional<Candidato> candidatoExistente = candidatoRepository.findById(idCandidato);
		
		if(candidatoExistente.isPresent()) {
			Candidato candidato = candidatoExistente.get();
			candidato.setNome(candidatoForm.getNome());
			candidato.setNumero(candidatoForm.getNumero());
			
			return ResponseEntity.ok().body(candidatoRepository.save(candidato));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{idCandidato}")
	@Transactional
	public ResponseEntity<Candidato> deleteCandidato(@PathVariable int idCandidato){
		Optional<Candidato> candidatoExistente = candidatoRepository.findById(idCandidato);
		
		if(candidatoExistente.isPresent()) {
			Candidato candidato = candidatoExistente.get();
			candidatoRepository.delete(candidato);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
