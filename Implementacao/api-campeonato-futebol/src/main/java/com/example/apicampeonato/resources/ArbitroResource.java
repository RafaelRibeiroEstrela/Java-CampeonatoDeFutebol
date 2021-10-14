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

import com.example.apicampeonato.models.Arbitro;
import com.example.apicampeonato.services.ArbitroService;

@RestController
@RequestMapping(value = "/arbitros")
public class ArbitroResource {
	
	@Autowired
	private ArbitroService arbitroService;

	@GetMapping
	public ResponseEntity<Page<Arbitro>> find(Pageable pageable){
		return ResponseEntity.ok().body(arbitroService.find(pageable));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Arbitro>> findAll(){
		return ResponseEntity.ok().body(arbitroService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Arbitro> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(arbitroService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Arbitro> save(@RequestBody Arbitro arbitro){
		return ResponseEntity.created(null).body(arbitroService.save(arbitro));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Arbitro> update(@PathVariable Long id, @RequestBody Arbitro arbitro){
		return ResponseEntity.ok().body(arbitroService.update(id, arbitro));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		arbitroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
