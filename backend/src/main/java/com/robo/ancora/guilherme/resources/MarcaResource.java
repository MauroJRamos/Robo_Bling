package com.robo.ancora.guilherme.resources;

import java.net.URI;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.robo.ancora.guilherme.dto.MarcaDTO;
import com.robo.ancora.guilherme.services.MarcaService;

@RestController
@RequestMapping(value = "/marca")
public class MarcaResource {
	
	@Autowired 
	public MarcaService service;
	
	@GetMapping
	public ResponseEntity<Page<MarcaDTO>> findAll(Pageable pageable){
		Page<MarcaDTO> list = service.findAllPaged(pageable); 
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MarcaDTO> findById(@PathVariable Long id){
		MarcaDTO dto = service.findById(id); 
		return ResponseEntity.ok().body(dto);
		
	}
	
	@PostMapping
	public ResponseEntity<MarcaDTO> insert(@RequestBody MarcaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MarcaDTO> update(@PathVariable Long id, @RequestBody MarcaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
			
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
			
	}
}
