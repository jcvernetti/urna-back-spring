package com.projeto.urna.form;

import com.projeto.urna.model.Login;

public class CadastroLoginForm {
	private String usuario;
	private String senha;

	public CadastroLoginForm(String usuario, String senha) {
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

	public Login converter() {
		return new Login(usuario, senha);
	}
}
