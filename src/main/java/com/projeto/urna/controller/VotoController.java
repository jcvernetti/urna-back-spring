package com.projeto.urna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.dto.VotoDTO;
import com.projeto.urna.form.VotoForm;
import com.projeto.urna.model.Candidato;
import com.projeto.urna.model.Votacao;
import com.projeto.urna.model.Voto;
import com.projeto.urna.repository.CandidatoRepository;
import com.projeto.urna.repository.VotacaoRepository;
import com.projeto.urna.repository.VotoRepository;

@RestController
@RequestMapping("/votacao")
public class VotoController {
	
	@Autowired
	public VotoRepository votoRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public Object salvarVoto(@RequestBody VotoForm votoForm) {
		Optional<Candidato> candidatoExistente = candidatoRepository.findById(votoForm.getIdCandidato());
		Optional<Votacao> votacaoExistente = votacaoRepository.findById(votoForm.getIdVotacao());
		
		if(candidatoExistente.isPresent()) {
			if(votacaoExistente.isPresent()) {
				Candidato candidato = candidatoExistente.get();
				Votacao votacao = votacaoExistente.get();
				
				Voto voto = votoForm.converter();
				voto.setCandidato(candidato);
				votacao.addVoto(voto);
				
				return voto;
			}
		
			return "Votação não encontrada";
			
		}
		
		return "Candidato não encontrado";
	}
	
	@CrossOrigin
	@GetMapping
	public List<VotoDTO> consultarVoto(){
		List<Voto> votos = votoRepository.findAll();
		return VotoDTO.converter(votos);
	}
}