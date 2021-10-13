package com.example.apicampeonato.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_placar")
public class Placar {
	
	@Id
	private Long id;

	@Column(name = "placar_time1")
	private Integer placarTime1 = 0;
	
	@Column(name = "placar_time2")
	private Integer placarTime2 = 0;
	
	public Placar() {
		
	}

	public Placar(Long id, Integer placarTime1, Integer placarTime2) {
		super();
		this.id = id;
		this.placarTime1 = placarTime1;
		this.placarTime2 = placarTime2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlacarTime1() {
		return placarTime1;
	}

	public void setPlacarTime1(Integer placarTime1) {
		this.placarTime1 = placarTime1;
	}

	public Integer getPlacarTime2() {
		return placarTime2;
	}

	public void setPlacarTime2(Integer placarTime2) {
		this.placarTime2 = placarTime2;
	}
	
	
	

}
