package com.robo.ancora.guilherme.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robo.ancora.guilherme.dto.PostBlingDTO;
import com.robo.ancora.guilherme.services.PostBlingService;


@RestController
@RequestMapping(value = "/post_bling")
public class PostBlingResource {
	
	@Autowired 
	public PostBlingService service;
	
	@GetMapping
	public ResponseEntity<Page<PostBlingDTO>> findAll(Pageable pageable){
		Page<PostBlingDTO> list = service.findAllPaged(pageable); 
		return ResponseEntity.ok().body(list);
		
	}

}
