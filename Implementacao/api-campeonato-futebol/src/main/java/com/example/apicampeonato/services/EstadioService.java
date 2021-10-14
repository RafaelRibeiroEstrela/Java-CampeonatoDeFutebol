package com.example.apicampeonato.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Estadio;
import com.example.apicampeonato.repositories.EstadioRepository;
import com.example.apicampeonato.services.exceptions.ObjectNotFoundException;

@Service
public class EstadioService {

	@Autowired
	private EstadioRepository estadioRepository;

	public Page<Estadio> find(Pageable pageable) {
		return estadioRepository.findAll(pageable);
	}

	public List<Estadio> findAll() {
		return estadioRepository.findAll();
	}

	public Estadio findById(Long id) {
		return estadioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found by id = " + id));
	}
	
	public Estadio save(Estadio estadio) {
		return estadioRepository.save(estadio);
	}

	public Estadio update(Long id, Estadio estadio) {
		Estadio estadioDb = findById(id);
		BeanUtils.copyProperties(estadio, estadioDb, "id");
		return estadioRepository.save(estadioDb);
	}
	
	public void delete(Long id) {
		findById(id);
		estadioRepository.deleteById(id);
	}
	
}
