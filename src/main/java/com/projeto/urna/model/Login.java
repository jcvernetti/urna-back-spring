package com.projeto.urna.model;

import javax.persistence.*;

@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String usuario;
	private String senha;
	
	public Login() {
		
	}
	
	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
