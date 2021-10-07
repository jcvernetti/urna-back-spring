package com.projeto.urna.model;

public class Candidato {

	private int id;
	private String nome;
	private int numero;

	public Candidato() {
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
}
