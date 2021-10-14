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

import com.example.apicampeonato.models.Partida;
import com.example.apicampeonato.services.PartidaService;

@RestController
@RequestMapping(value = "/partidas")
public class PartidaResource {
	
	@Autowired
	private PartidaService partidaService;

	@GetMapping
	public ResponseEntity<Page<Partida>> find(Pageable pageable){
		return ResponseEntity.ok().body(partidaService.find(pageable));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Partida>> findAll(){
		return ResponseEntity.ok().body(partidaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Partida> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(partidaService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Partida> save(@RequestBody Partida partida){
		return ResponseEntity.created(null).body(partidaService.save(partida));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Partida> update(@PathVariable Long id, @RequestBody Partida partida){
		return ResponseEntity.ok().body(partidaService.update(id, partida));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		partidaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
