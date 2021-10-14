package com.example.apicampeonato.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Arbitro;
import com.example.apicampeonato.repositories.ArbitroRepository;
import com.example.apicampeonato.services.exceptions.ObjectNotFoundException;

@Service
public class ArbitroService {

	@Autowired
	private ArbitroRepository arbitroRepository;

	public Page<Arbitro> find(Pageable pageable) {
		return arbitroRepository.findAll(pageable);
	}

	public List<Arbitro> findAll() {
		return arbitroRepository.findAll();
	}

	public Arbitro findById(Long id) {
		return arbitroRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found by id = " + id));
	}
	
	public Arbitro save(Arbitro arbitro) {
		return arbitroRepository.save(arbitro);
	}

	public Arbitro update(Long id, Arbitro arbitro) {
		Arbitro arbitroDb = findById(id);
		BeanUtils.copyProperties(arbitro, arbitroDb, "id");
		return arbitroRepository.save(arbitroDb);
	}
	
	public void delete(Long id) {
		findById(id);
		arbitroRepository.deleteById(id);
	}
	
}
