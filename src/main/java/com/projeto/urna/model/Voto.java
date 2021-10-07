package com.projeto.urna.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoto;
	private String nomeCandidato;
	private int numeroCandidato;
	private Date dataVoto;
	
	public Voto() {
		
	}
	
	public Voto(String nomeCandidato, int numeroCandidato, Date dataVoto) {
		this.nomeCandidato = nomeCandidato;
		this.numeroCandidato = numeroCandidato;
		this.dataVoto = dataVoto;
	}

	public Voto(String nomeCandidato, int numeroCandidato, Date dataVoto, int idVoto) {
		this.idVoto = idVoto;
		this.nomeCandidato = nomeCandidato;
		this.numeroCandidato = numeroCandidato;
		this.dataVoto = dataVoto;
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
	
	public int getIdVoto() {
		return idVoto;
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

	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}
}
