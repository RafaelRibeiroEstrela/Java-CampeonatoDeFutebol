package com.example.apicampeonato.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_time")
public class Time implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer numeroDeJogadores;
	private Integer golsMarcados = 0;
	private Integer golsSofridos = 0;
	private Integer numeroDeVitorias = 0;
	private Integer numeroDeEmpates = 0;
	private Integer numeroDeDerrotas = 0;
	
	@OneToMany
	private List<Jogador> jogadores = new ArrayList<>();
	
	@ManyToMany(mappedBy = "times")
	private List<Partida> partidas = new ArrayList<>();
	
	public Time() {
		
	}

	public Time(Long id, String nome, Integer numeroDeJogadores) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroDeJogadores = numeroDeJogadores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroDeJogadores() {
		return numeroDeJogadores;
	}

	public void setNumeroDeJogadores(Integer numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
	}

	public Integer getGolsMarcados() {
		return golsMarcados;
	}

	public void setGolsMarcados(Integer golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	public Integer getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(Integer golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public Integer getNumeroDeVitorias() {
		return numeroDeVitorias;
	}

	public void setNumeroDeVitorias(Integer numeroDeVitorias) {
		this.numeroDeVitorias = numeroDeVitorias;
	}

	public Integer getNumeroDeEmpates() {
		return numeroDeEmpates;
	}

	public void setNumeroDeEmpates(Integer numeroDeEmpates) {
		this.numeroDeEmpates = numeroDeEmpates;
	}

	public Integer getNumeroDeDerrotas() {
		return numeroDeDerrotas;
	}

	public void setNumeroDeDerrotas(Integer numeroDeDerrotas) {
		this.numeroDeDerrotas = numeroDeDerrotas;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
	
	public Integer getSaldoDeGols() {
		return golsMarcados - golsSofridos;
	}
	
	public Integer getTotalDeFaltas() {
		return null;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", numeroDeJogadores=" + numeroDeJogadores + ", golsMarcados="
				+ golsMarcados + ", golsSofridos=" + golsSofridos + ", numeroDeVitorias=" + numeroDeVitorias
				+ ", numeroDeEmpates=" + numeroDeEmpates + ", numeroDeDerrotas=" + numeroDeDerrotas + "]";
	}
	
	
	
	

}
