package com.projeto.urna.form;

import java.util.Date;

import com.projeto.urna.model.Voto;

public class VotoForm {
	
	private String nomeCandidato;
	private int numeroCandidato;
	private Date dataVoto;

	public VotoForm(String nomeCandidato, int numeroCandidato, Date dataVoto) {
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

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public void setNumeroCandidato(int numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}
	
	public Voto converter() {
		return new Voto(nomeCandidato, numeroCandidato, dataVoto);		
	}
}
