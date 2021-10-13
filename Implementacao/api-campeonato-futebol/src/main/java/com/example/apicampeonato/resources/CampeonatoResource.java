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

import com.example.apicampeonato.models.Campeonato;
import com.example.apicampeonato.services.CampeonatoService;

@RestController
@RequestMapping(value = "/campeonatos")
public class CampeonatoResource {
	
	@Autowired
	private CampeonatoService campeonatoService;

	@GetMapping
	public ResponseEntity<Page<Campeonato>> find(Pageable pageable){
		return ResponseEntity.ok().body(campeonatoService.find(pageable));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Campeonato>> findAll(){
		return ResponseEntity.ok().body(campeonatoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Campeonato> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(campeonatoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Campeonato> save(@RequestBody Campeonato campeonato){
		return ResponseEntity.created(null).body(campeonatoService.save(campeonato));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Campeonato> update(@PathVariable Long id, @RequestBody Campeonato campeonato){
		return ResponseEntity.ok().body(campeonatoService.update(id, campeonato));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		campeonatoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
