package com.projeto.urna.dto;

import java.util.Date;

public class LoginDTO {
	private Date dataLogin;
	private boolean autorizado;

	public LoginDTO() {
	}
	
	public LoginDTO(Date dataLogin, boolean autorizado) {
		this.dataLogin = dataLogin;
		this.autorizado = autorizado;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public Date getDataLogin() {
		return dataLogin;
	}

	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}
}
