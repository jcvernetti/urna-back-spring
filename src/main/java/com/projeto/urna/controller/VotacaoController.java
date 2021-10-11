package com.projeto.urna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.dto.VotacaoDTO;
import com.projeto.urna.form.VotacaoForm;
import com.projeto.urna.model.Votacao;
import com.projeto.urna.repository.VotacaoRepository;

@RestController
@RequestMapping("/configvotacao")
public class VotacaoController {

	@Autowired
	private VotacaoRepository votacaoRepository;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<VotacaoDTO> getVotacao(){
		List<Votacao> votacoes = votacaoRepository.findAll();
		
		if(votacoes.size() != 0) {
			VotacaoDTO votacao = VotacaoDTO.converter(votacoes.get(0)); 			
		
			return ResponseEntity.ok().body(votacao);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@GetMapping("/candidatos/{idVotacao}")
	public Object getCandidatos(@PathVariable int idVotacao) {
		Optional<Votacao> votacaoExistente = votacaoRepository.findById(idVotacao);
		
		if(votacaoExistente.isPresent()) {
			Votacao votacao = votacaoExistente.get();
			
			return votacao.getCandidatos();
		}
		
		return "Votação não encontrada";
	}
	
	@CrossOrigin
	@GetMapping("/votos/{idVotacao}")
	public Object getVotos(@PathVariable int idVotacao) {
		Optional<Votacao> votacaoExistente = votacaoRepository.findById(idVotacao);
		
		if(votacaoExistente.isPresent()) {
			Votacao votacao = votacaoExistente.get();
			
			return votacao.getVotos();
		}
		
		return "Votação não encontrada";
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Votacao> postVotacao(@RequestBody VotacaoForm votacaoForm){
		Votacao votacao = new Votacao();
		
		votacao.setTipo(votacaoForm.getTipo());
		votacao.setDtInicio(votacaoForm.getDtInicio());
		votacao.setDtFim(votacaoForm.getDtFim());
		
		return ResponseEntity.ok().body(votacaoRepository.save(votacao));
	}
	
	@CrossOrigin
	@DeleteMapping
	public ResponseEntity<Votacao> deleteVotacao(){
		List<Votacao> votacoes = votacaoRepository.findAll();
		
		if(votacoes.size() != 0) {
			votacaoRepository.deleteAll();
			return ResponseEntity.ok().build();
		}
	
		return ResponseEntity.notFound().build();
	}
}
