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

import com.example.apicampeonato.models.Jogador;
import com.example.apicampeonato.services.JogadorService;

@RestController
@RequestMapping(value = "/jogadors")
public class JogadorResource {
	
	@Autowired
	private JogadorService jogadorService;

	@GetMapping
	public ResponseEntity<Page<Jogador>> find(Pageable pageable){
		return ResponseEntity.ok().body(jogadorService.find(pageable));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Jogador>> findAll(){
		return ResponseEntity.ok().body(jogadorService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogador> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(jogadorService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Jogador> save(@RequestBody Jogador jogador){
		return ResponseEntity.created(null).body(jogadorService.save(jogador));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogador> update(@PathVariable Long id, @RequestBody Jogador jogador){
		return ResponseEntity.ok().body(jogadorService.update(id, jogador));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		jogadorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
