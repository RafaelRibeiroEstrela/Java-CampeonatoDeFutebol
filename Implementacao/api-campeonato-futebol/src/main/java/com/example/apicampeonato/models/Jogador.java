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
	
	private Integer tipoPerna;
	private Integer tipoPosicao;
	private Integer numeroDeGols = 0;
	private Integer numeroDeFaltas = 0;
	
	@ManyToOne
	@JoinColumn(name = "id_time")
	private Time time;
	
	public Jogador() {
		
	}

	public Jogador(Long id, String nome, String email, String cpf, Integer idade, TipoPernaEnum tipoPerna, TipoPosicaoEnum tipoPosicao) {
		super(id, nome, email, cpf, idade);
		this.tipoPerna = tipoPerna.getCod();
		this.tipoPosicao = tipoPosicao.getCod();
	}

	public TipoPernaEnum getTipoPerna() {
		return TipoPernaEnum.toEnum(tipoPerna);
	}

	public void setTipoPerna(TipoPernaEnum tipoPerna) {
		this.tipoPerna = tipoPerna.getCod();
	}

	public TipoPosicaoEnum getTipoPosicao() {
		return TipoPosicaoEnum.toEnum(tipoPosicao);
	}

	public void setTipoPosicao(TipoPosicaoEnum tipoPosicao) {
		this.tipoPosicao = tipoPosicao.getCod();
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
