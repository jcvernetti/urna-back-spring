package com.projeto.urna.dto;

import java.util.Date;

import com.projeto.urna.model.Votacao;

public class VotacaoDTO {

    private int tipo;
    private Date dtInicio;
    private Date dtFim;
    
    public VotacaoDTO() {
	}
    
    public VotacaoDTO(Votacao votacao) {
		this.tipo = votacao.getTipo();
		this.dtInicio = votacao.getDtInicio();
		this.dtFim = votacao.getDtFim();
    }

	public VotacaoDTO(int tipo, Date dtInicio, Date dtFim, Date timeFim) {
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

	public static VotacaoDTO converter(Votacao votacao) {
		return new VotacaoDTO(votacao);
	}
}
