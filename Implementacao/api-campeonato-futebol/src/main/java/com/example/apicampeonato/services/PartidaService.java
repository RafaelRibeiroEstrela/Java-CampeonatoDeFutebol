package com.example.apicampeonato.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Partida;
import com.example.apicampeonato.repositories.PartidaRepository;
import com.example.apicampeonato.services.exceptions.ObjectNotFoundException;

@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;

	public Page<Partida> find(Pageable pageable) {
		return partidaRepository.findAll(pageable);
	}

	public List<Partida> findAll() {
		return partidaRepository.findAll();
	}

	public Partida findById(Long id) {
		return partidaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found by id = " + id));
	}
	
	public Partida save(Partida partida) {
		return partidaRepository.save(partida);
	}

	public Partida update(Long id, Partida partida) {
		Partida partidaDb = findById(id);
		BeanUtils.copyProperties(partida, partidaDb, "id");
		return partidaRepository.save(partidaDb);
	}
	
	public void delete(Long id) {
		findById(id);
		partidaRepository.deleteById(id);
	}
	
}
