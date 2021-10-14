package com.example.apicampeonato.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicampeonato.models.Time;
import com.example.apicampeonato.services.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeResource {
	
	@Autowired
	private TimeService timeService;

	@GetMapping
	public ResponseEntity<Page<Time>> find(Pageable pageable){
		return ResponseEntity.ok().body(timeService.find(pageable));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Time>> findAll(){
		return ResponseEntity.ok().body(timeService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Time> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(timeService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Time> save(@RequestBody Time time){
		return ResponseEntity.created(null).body(timeService.save(time));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Time> update(@PathVariable Long id, @RequestBody Time time){
		return ResponseEntity.ok().body(timeService.update(id, time));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		timeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
