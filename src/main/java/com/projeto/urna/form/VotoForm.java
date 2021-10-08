package com.projeto.urna.form;

import java.util.Date;

import com.projeto.urna.model.Voto;

public class VotoForm {
	
	private int idVotacao;
	private int idCandidato;
	private Date dataVoto;

	public VotoForm(int idCandidato, Date dataVoto) {
		this.dataVoto = dataVoto;
		this.idCandidato = idCandidato;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}
	
	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Voto converter() {
		return new Voto(dataVoto);		
	}

	public int getIdVotacao() {
		return idVotacao;
	}

	public void setIdVotacao(int idVotacao) {
		this.idVotacao = idVotacao;
	}
}
