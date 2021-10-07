package com.projeto.urna.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Voto {
	
	@Id
	private int idVoto;
	private String nomeCandidato;
	private int numCandidato;
	private Date dataVoto;
	
	public Voto() {
		
	}

	public Voto(String nomeCandidato, int numCandidato, Date dataVoto, int idVoto) {
		this.idVoto = idVoto;
		this.nomeCandidato = nomeCandidato;
		this.numCandidato = numCandidato;
		this.dataVoto = dataVoto;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public int getNumCandidato() {
		return numCandidato;
	}

	public Date getDataVoto() {
		return dataVoto;
	}
	
	public int getIdVoto() {
		return idVoto;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public void setNumCandidato(int numCandidato) {
		this.numCandidato = numCandidato;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}

	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}
	
	
}
