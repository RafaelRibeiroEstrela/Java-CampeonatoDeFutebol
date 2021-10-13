package com.example.apicampeonato.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.apicampeonato.models.enums.TipoPernaEnum;
import com.example.apicampeonato.models.enums.TipoPosicaoEnum;

@Entity
@Table(name = "tb_jogador")
public class Jogador extends Funcionario{

	private static final long serialVersionUID = 1L;
	
	private TipoPernaEnum tipoPerna;
	private TipoPosicaoEnum tipoPosicao;
	private Integer numeroDeGols = 0;
	private Integer numeroDeFaltas = 0;
	
	@ManyToOne
	@JoinColumn(name = "id_time")
	private Time time;
	
	public Jogador() {
		
	}

	public Jogador(TipoPernaEnum tipoPerna, TipoPosicaoEnum tipoPosicao) {
		super();
		this.tipoPerna = tipoPerna;
		this.tipoPosicao = tipoPosicao;
	}

	public TipoPernaEnum getTipoPerna() {
		return tipoPerna;
	}

	public void setTipoPerna(TipoPernaEnum tipoPerna) {
		this.tipoPerna = tipoPerna;
	}

	public TipoPosicaoEnum getTipoPosicao() {
		return tipoPosicao;
	}

	public void setTipoPosicao(TipoPosicaoEnum tipoPosicao) {
		this.tipoPosicao = tipoPosicao;
	}

	public Integer getNumeroDeGols() {
		return numeroDeGols;
	}

	public Integer getNumeroDeFaltas() {
		return numeroDeFaltas;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Jogador [tipoPerna=" + tipoPerna + ", tipoPosicao=" + tipoPosicao + ", numeroDeGols=" + numeroDeGols
				+ ", numeroDeFaltas=" + numeroDeFaltas + "]";
	}
	
	
	
	

}
