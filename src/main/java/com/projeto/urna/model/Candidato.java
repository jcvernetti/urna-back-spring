package com.projeto.urna.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int numero;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "votacao_candidato", 
			joinColumns = { @JoinColumn(name = "idCandidato") }, 
			inverseJoinColumns = { @JoinColumn(name = "idVotacao")})
	private List<Votacao> votacoes;

	public Candidato() {
	}

	public Candidato(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public Candidato(int id, String nome, int numero) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void addVotacoes(Votacao votacao) {
		if(votacoes == null) {
			votacoes = new ArrayList<Votacao>();
		}
		
		votacoes.add(votacao);
	}
}
