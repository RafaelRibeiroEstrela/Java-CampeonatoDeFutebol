package com.example.apicampeonato.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.apicampeonato.models.enums.TipoPartidaEnum;

@Entity
@Table(name = "tb_partida")
public class Partida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(name = "hora_inicio", nullable = false)
	private LocalDate horaInicio;
	
	@Column(name = "hora_fim", nullable = false)
	private LocalDate horaFim;
	
	@Column(name = "tipo_partida", nullable = false)
	private Integer tipoPartidaEnum;
	
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;
	
	@OneToOne
	@JoinColumn(name = "id_estadio")
	private Estadio estadio;
	
	@OneToOne
	@JoinColumn(name = "id_placar")
	private Placar placar;
	
	//@OneToOne
	//@JoinColumn(name = "id_time1")
	//private Time time1;
	
	//@OneToOne
	//@JoinColumn(name = "id_time2")
	//private Time time2;
	
	//private List<Arbitro> arbitros = new ArrayList<>();

	public Partida() {
		
	}

	public Partida(Long id, LocalDate data, LocalDate horaInicio, LocalDate horaFim, TipoPartidaEnum tipoPartidaEnum,
			Campeonato campeonato, Estadio estadio, Time time1, Time time2) {
		super();
		this.id = id;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.tipoPartidaEnum = tipoPartidaEnum.getCod();
		this.campeonato = campeonato;
		this.estadio = estadio;
		//this.time1 = time1;
		//this.time2 = time2;
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

	public LocalDate getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDate horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDate getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalDate horaFim) {
		this.horaFim = horaFim;
	}

	public Integer getTipoPartidaEnum() {
		return tipoPartidaEnum;
	}

	public void setTipoPartidaEnum(Integer tipoPartidaEnum) {
		this.tipoPartidaEnum = tipoPartidaEnum;
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

	public Placar getPlacar() {
		return placar;
	}
	
	//public List<Arbitro> getArbitros() {
	//	return arbitros;
	//}


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
				+ ", tipoPartidaEnum=" + tipoPartidaEnum + ", campeonato=" + campeonato + ", estadio=" + estadio
				+ ", placar=" + placar + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}