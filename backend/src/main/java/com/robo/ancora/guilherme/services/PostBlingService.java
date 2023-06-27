package com.robo.ancora.guilherme.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robo.ancora.guilherme.dto.PostBlingDTO;
import com.robo.ancora.guilherme.entities.PostBling;
import com.robo.ancora.guilherme.repositories.PostBlingRepository;

@Service
public class PostBlingService {
	
	@Autowired
	private PostBlingRepository repository;

	@Transactional(readOnly = true)
	public Page<PostBlingDTO> findAllPaged(LocalDate dataInicio, LocalDate dataFim, Pageable pageable) {
		LocalDateTime dataInicioDateTime = dataInicio.atStartOfDay();
	    LocalDateTime dataFimDateTime = dataFim.atTime(23, 59, 59);
		Page<PostBling> list = repository.findAllByDatRequestBetween(dataInicioDateTime, dataFimDateTime, pageable);
		return list.map(x -> new PostBlingDTO(x));
	}
	
	@Transactional(readOnly = true)
	public Page<PostBlingDTO> findAllPaged(Pageable pageable) {
		Page<PostBling> list = repository.findAll(pageable);
		return list.map(x -> new PostBlingDTO(x));

	}

}
