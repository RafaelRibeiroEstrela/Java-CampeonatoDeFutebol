package com.example.apicampeonato.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Jogador;
import com.example.apicampeonato.repositories.JogadorRepository;
import com.example.apicampeonato.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;

	public Page<Jogador> find(Pageable pageable) {
		return jogadorRepository.findAll(pageable);
	}

	public List<Jogador> findAll() {
		return jogadorRepository.findAll();
	}

	public Jogador findById(Long id) {
		return jogadorRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found by id = " + id));
	}
	
	public Jogador save(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}

	public Jogador update(Long id, Jogador jogador) {
		Jogador jogadorDb = findById(id);
		BeanUtils.copyProperties(jogador, jogadorDb, "id");
		return jogadorRepository.save(jogadorDb);
	}
	
	public void delete(Long id) {
		findById(id);
		jogadorRepository.deleteById(id);
	}
	
}
