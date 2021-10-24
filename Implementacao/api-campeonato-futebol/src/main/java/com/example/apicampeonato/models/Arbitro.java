package com.example.apicampeonato.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.apicampeonato.models.enums.TipoArbitroEnum;

@Entity
@Table(name = "tb_funcionario_arbitro")
public class Arbitro extends Funcionario{
	
	private static final long serialVersionUID = 1L;

	private Integer tipoArbitro;
	
	//@ManyToMany(mappedBy = "arbitros")
	//private List<Partida> partidas = new ArrayList<>();

	public Arbitro() {
		super();
	}

	public Arbitro(Long id, String nome, String email, String cpf, Integer idade, TipoArbitroEnum tipoArbitro) {
		super(id, nome, email, cpf, idade);
		this.tipoArbitro = tipoArbitro.getCod();
	}

	public TipoArbitroEnum getTipoArbitro() {
		return TipoArbitroEnum.toEnum(tipoArbitro);
	}

	public void setTipoArbitro(TipoArbitroEnum tipoArbitro) {
		this.tipoArbitro = tipoArbitro.getCod();
	}

	@Override
	public String toString() {
		return "Arbitro [tipoArbitro=" + tipoArbitro + "]";
	}
	
	
	
	

}
