package com.example.apicampeonato.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.apicampeonato.models.enums.TipoPartidaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_partida")
public class Partida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm")
	private LocalDateTime horaInicio;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm")
	private LocalDateTime horaFim;
	
	@Column(nullable = false)
	private Integer tipoPartida;
	
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;
	
	@OneToOne
	@JoinColumn(name = "id_estadio")
	private Estadio estadio;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "id_partida"), inverseJoinColumns = @JoinColumn(name = "id_time"))
	private List<Time> times = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "id_partida"), inverseJoinColumns = @JoinColumn(name = "id_arbitro"))
	private List<Arbitro> arbitros = new ArrayList<>();

	public Partida() {
		
	}

	public Partida(Long id, LocalDate data, LocalDateTime horaInicio, LocalDateTime horaFim, TipoPartidaEnum tipoPartida,
			Campeonato campeonato, Estadio estadio) {
		super();
		this.id = id;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.tipoPartida = tipoPartida.getCod();
		this.campeonato = campeonato;
		this.estadio = estadio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalDateTime horaFim) {
		this.horaFim = horaFim;
	}

	public TipoPartidaEnum getTipoPartida() {
		return TipoPartidaEnum.toEnum(tipoPartida);
	}

	public void setTipoPartida(TipoPartidaEnum tipoPartida) {
		this.tipoPartida = tipoPartida.getCod();
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	public List<Arbitro> getArbitros() {
		return arbitros;
	}

	public List<Time> getTimes() {
		return times;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", data=" + data + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim
				+ ", tipoPartida=" + tipoPartida + ", campeonato=" + campeonato + ", estadio=" + estadio
				+ "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
