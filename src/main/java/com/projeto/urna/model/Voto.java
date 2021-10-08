package com.projeto.urna.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoto;
	private Date dataVoto;
	
	@OneToOne
	@JoinColumn(name = "idCandidato")
	private Candidato candidato;
	
	public Voto() {
		
	}
	
	public Voto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}

	public Date getDataVoto() {
		return dataVoto;
	}
	
	public int getIdVoto() {
		return idVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}

	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}
