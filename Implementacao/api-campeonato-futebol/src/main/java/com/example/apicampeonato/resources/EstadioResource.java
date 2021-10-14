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

import com.example.apicampeonato.models.Estadio;
import com.example.apicampeonato.services.EstadioService;

@RestController
@RequestMapping(value = "/estadios")
public class EstadioResource {
	
	@Autowired
	private EstadioService estadioService;

	@GetMapping
	public ResponseEntity<Page<Estadio>> find(Pageable pageable){
		return ResponseEntity.ok().body(estadioService.find(pageable));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Estadio>> findAll(){
		return ResponseEntity.ok().body(estadioService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estadio> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(estadioService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Estadio> save(@RequestBody Estadio estadio){
		return ResponseEntity.created(null).body(estadioService.save(estadio));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Estadio> update(@PathVariable Long id, @RequestBody Estadio estadio){
		return ResponseEntity.ok().body(estadioService.update(id, estadio));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		estadioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
