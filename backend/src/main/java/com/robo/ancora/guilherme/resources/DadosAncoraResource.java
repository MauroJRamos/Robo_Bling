package com.robo.ancora.guilherme.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robo.ancora.guilherme.dto.DadosAncoraDTO;
import com.robo.ancora.guilherme.services.DadosAncoraService;

@RestController
@RequestMapping(value = "/dados_ancora")
public class DadosAncoraResource {

	@Autowired 
	public DadosAncoraService service;
	
	@GetMapping
	public ResponseEntity<Page<DadosAncoraDTO>> findAll(
		@RequestParam(value = "dataInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
		@RequestParam(value = "dataFim", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim,
		Pageable pageable) {

		Page<DadosAncoraDTO> list;
	    if (dataInicio == null || dataFim == null) {
	        list = service.findAllPaged(pageable);
	    } else {
	        list = service.findAllPaged(dataInicio, dataFim, pageable);
	    }
	    return ResponseEntity.ok().body(list);
	}

	
	/*
	 @GetMapping
	public ResponseEntity<Page<DadosAncoraDTO>> findAll(Pageable pageable){
		Page<DadosAncoraDTO> list = service.findAllPaged(pageable); 
		return ResponseEntity.ok().body(list);
		
	}
	 
	 */
}
