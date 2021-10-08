package com.projeto.urna.dto;

import java.util.Date;

public class LoginDTO {
	private Date dataLogin;
	private boolean isLoginValido;

	public LoginDTO(Date dataLogin, boolean isLoginValido) {
		this.dataLogin = dataLogin;
		this.isLoginValido = isLoginValido;
	}

	public Date getDataLogin() {
		return dataLogin;
	}

	public boolean isLoginValido() {
		return isLoginValido;
	}

	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}

	public void setLoginValido(boolean isLoginValido) {
		this.isLoginValido = isLoginValido;
	}
}
