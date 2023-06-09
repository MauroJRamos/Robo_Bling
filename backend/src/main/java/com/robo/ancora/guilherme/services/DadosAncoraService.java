package com.robo.ancora.guilherme.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robo.ancora.guilherme.dto.DadosAncoraDTO;
import com.robo.ancora.guilherme.entities.DadosAncora;
import com.robo.ancora.guilherme.repositories.DadosAncoraRepository;

@Service
public class DadosAncoraService {
	
	@Autowired
	private DadosAncoraRepository repository;

	@Transactional(readOnly = true)
	public Page<DadosAncoraDTO> findAllPaged(LocalDate dataInicio, LocalDate dataFim, Pageable pageable) {
		LocalDateTime dataInicioDateTime = dataInicio.atStartOfDay();
	    LocalDateTime dataFimDateTime = dataFim.atTime(23, 59, 59);
		Page<DadosAncora> list = repository.findAllByDatRequestBetween(dataInicioDateTime, dataFimDateTime, pageable);
		return list.map(x -> new DadosAncoraDTO(x));

	}
	
	@Transactional(readOnly = true)
	public Page<DadosAncoraDTO> findAllPaged( Pageable pageable) {
		Page<DadosAncora> list = repository.findAll(pageable);
		return list.map(x -> new DadosAncoraDTO(x));

	}

}
