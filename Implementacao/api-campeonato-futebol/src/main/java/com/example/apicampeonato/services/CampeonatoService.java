package com.example.apicampeonato.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Campeonato;
import com.example.apicampeonato.repositories.CampeonatoRepository;
import com.example.apicampeonato.services.exceptions.ObjectNotFoundException;

@Service
public class CampeonatoService {

	@Autowired
	private CampeonatoRepository campeonatoRepository;

	public Page<Campeonato> find(Pageable pageable) {
		return campeonatoRepository.findAll(pageable);
	}

	public List<Campeonato> findAll() {
		return campeonatoRepository.findAll();
	}

	public Campeonato findById(Long id) {
		return campeonatoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found by id = " + id));
	}
	
	public Campeonato save(Campeonato campeonato) {
		return campeonatoRepository.save(campeonato);
	}

	public Campeonato update(Long id, Campeonato campeonato) {
		Campeonato campeonatoDb = findById(id);
		BeanUtils.copyProperties(campeonato, campeonatoDb, "id");
		return campeonatoRepository.save(campeonatoDb);
	}
	
	public void delete(Long id) {
		findById(id);
		campeonatoRepository.deleteById(id);
	}
	
}
