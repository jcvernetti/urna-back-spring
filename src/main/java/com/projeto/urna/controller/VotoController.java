package com.projeto.urna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.urna.dto.VotoDTO;
import com.projeto.urna.form.VotoForm;
import com.projeto.urna.model.Voto;
import com.projeto.urna.repository.VotoRepository;

@RestController
@RequestMapping("/voto")
public class VotoController {
	
	@Autowired
	public VotoRepository votoRepository;
	
	@PostMapping
	public Object salvarVoto(@RequestBody VotoForm votoForm) {
		Voto voto = votoForm.converter();
		votoRepository.save(voto);
		return voto;
	}
	
	@GetMapping
	public List<VotoDTO> consultarVoto(){
		List<Voto> votos = votoRepository.findAll();
		return VotoDTO.converter(votos);
	}
}

