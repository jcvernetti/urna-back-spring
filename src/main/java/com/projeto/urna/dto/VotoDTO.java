package com.projeto.urna.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projeto.urna.model.Voto;

public class VotoDTO {
	private String nomeCandidato;
	private int numeroCandidato;
	private Date dataVoto;
	
	public VotoDTO(Voto voto) {
		this.nomeCandidato = voto.getNomeCandidato();
		this.numeroCandidato = voto.getNumeroCandidato();
		this.dataVoto = voto.getDataVoto();
	}
	
	public static List<VotoDTO> converter(List<Voto> votos){
		return votos.stream().map(VotoDTO:: new).collect(Collectors.toList());
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public int getNumeroCandidato() {
		return numeroCandidato;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public void setNumeroCandidato(int numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}
}
