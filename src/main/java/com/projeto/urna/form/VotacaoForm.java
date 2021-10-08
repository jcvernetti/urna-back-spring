package com.projeto.urna.form;

import java.util.Date;

import com.projeto.urna.model.Votacao;

public class VotacaoForm {

    private int tipo;
    private Date dtInicio;
    private Date dtFim;
    
    public VotacaoForm() {
	}

	public VotacaoForm(int tipo, Date dtInicio, Date dtFim, boolean iniciada, boolean terminada, boolean isVotacaoCurso) {
		this.tipo = tipo;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
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

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Votacao converter() {
		return new Votacao(tipo, dtInicio, dtFim, false, false, false);
	}
}
