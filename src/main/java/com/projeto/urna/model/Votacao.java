package com.projeto.urna.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Votacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private int tipo;
    private Date dtInicio;
    private Date dtFim;
    private Date timeInicio;
    private Date timeFim;
    private boolean iniciada;
	private boolean terminada;
	private boolean isVotacaoCurso;
	private ArrayList<Voto> votos;
    private ArrayList<Candidato> candidatos;
    
    public Votacao() {
	}

	public Votacao(int tipo, Date dtInicio, Date dtFim, Date timeInicio, Date timeFim, boolean iniciada,
			boolean terminada, boolean isVotacaoCurso, ArrayList<Voto> votos, ArrayList<Candidato> candidatos) {
		this.tipo = tipo;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.timeInicio = timeInicio;
		this.timeFim = timeFim;
		this.iniciada = iniciada;
		this.terminada = terminada;
		this.isVotacaoCurso = isVotacaoCurso;
		this.votos = votos;
		this.candidatos = candidatos;
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

	public Date getTimeInicio() {
		return timeInicio;
	}

	public Date getTimeFim() {
		return timeFim;
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

	public ArrayList<Voto> getVotos() {
		return votos;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
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

	public void setTimeInicio(Date timeInicio) {
		this.timeInicio = timeInicio;
	}

	public void setTimeFim(Date timeFim) {
		this.timeFim = timeFim;
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

	public void setVotos(ArrayList<Voto> votos) {
		this.votos = votos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
