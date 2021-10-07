package com.projeto.urna.form;

import com.projeto.urna.model.Candidato;

public class AlteracaoCandidatoForm {

	private String nome;
	private int numero;

	public AlteracaoCandidatoForm() {
	}

	public AlteracaoCandidatoForm(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public AlteracaoCandidatoForm(Candidato candidato) {
		this.nome =  candidato.getNome();
		this.numero = candidato.getNumero();
	}
	
	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Candidato converter() {
		return new Candidato(nome, numero); 
	}
}
