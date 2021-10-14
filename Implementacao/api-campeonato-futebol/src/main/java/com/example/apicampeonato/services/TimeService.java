package com.example.apicampeonato.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apicampeonato.models.Time;
import com.example.apicampeonato.repositories.TimeRepository;
import com.example.apicampeonato.services.exceptions.ObjectNotFoundException;

@Service
public class TimeService {

	@Autowired
	private TimeRepository timeRepository;

	public Page<Time> find(Pageable pageable) {
		return timeRepository.findAll(pageable);
	}

	public List<Time> findAll() {
		return timeRepository.findAll();
	}

	public Time findById(Long id) {
		return timeRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found by id = " + id));
	}
	
	public Time save(Time time) {
		return timeRepository.save(time);
	}

	public Time update(Long id, Time time) {
		Time timeDb = findById(id);
		BeanUtils.copyProperties(time, timeDb, "id");
		return timeRepository.save(timeDb);
	}
	
	public void delete(Long id) {
		findById(id);
		timeRepository.deleteById(id);
	}
	
}
