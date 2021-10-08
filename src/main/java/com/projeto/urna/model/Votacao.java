package com.projeto.urna.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Votacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private int tipo;
    private Date dtInicio;
    private Date dtFim;
    private boolean iniciada;
	private boolean terminada;
	private boolean isVotacaoCurso;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idVotacao")
	private List<Voto> votos;
	
	@ManyToMany(mappedBy = "votacoes", cascade = CascadeType.ALL)
	private List<Candidato> candidatos;
	    
    public Votacao() {
	}

	public Votacao(int tipo, Date dtFim, Date timeFim, boolean iniciada, boolean terminada, boolean isVotacaoCurso) {
		this.tipo = tipo;
		this.dtFim = dtFim;
		this.iniciada = iniciada;
		this.terminada = terminada;
		this.isVotacaoCurso = isVotacaoCurso;
	}

	public int getId() {
		return id;
	}

	public int getTipo() {
		return tipo;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public boolean isIniciada() {
		return iniciada;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public boolean isVotacaoCurso() {
		return isVotacaoCurso;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public void setIniciada(boolean iniciada) {
		this.iniciada = iniciada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}

	public void setVotacaoCurso(boolean isVotacaoCurso) {
		this.isVotacaoCurso = isVotacaoCurso;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public void addVoto(Voto voto) {
		if(votos == null) {
			votos = new ArrayList<Voto>();
		}
		
		votos.add(voto);
	}
	
	public void addCandidatos(Candidato candidato) {
		if(candidatos == null) {
			candidatos = new ArrayList<Candidato>();
		}
		
		candidatos.add(candidato);
	}
}















