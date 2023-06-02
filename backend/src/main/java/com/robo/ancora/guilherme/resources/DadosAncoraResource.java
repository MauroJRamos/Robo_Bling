package com.robo.ancora.guilherme.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robo.ancora.guilherme.dto.DadosAncoraDTO;
import com.robo.ancora.guilherme.services.DadosAncoraService;

@RestController
@RequestMapping(value = "/dados_ancora")
public class DadosAncoraResource {

	@Autowired 
	public DadosAncoraService service;
	
	@GetMapping
	public ResponseEntity<Page<DadosAncoraDTO>> findAll(Pageable pageable){
		Page<DadosAncoraDTO> list = service.findAllPaged(pageable); 
		return ResponseEntity.ok().body(list);
		
	}
	
}
