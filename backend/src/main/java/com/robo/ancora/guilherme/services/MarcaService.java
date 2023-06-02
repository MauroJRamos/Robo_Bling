package com.robo.ancora.guilherme.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.robo.ancora.guilherme.dto.MarcaDTO;
import com.robo.ancora.guilherme.dto.MarcaDTO;
import com.robo.ancora.guilherme.dto.MarcaDTO;
import com.robo.ancora.guilherme.dto.MarcaDTO;
import com.robo.ancora.guilherme.entities.Marca;
import com.robo.ancora.guilherme.entities.Marca;
import com.robo.ancora.guilherme.entities.Marca;
import com.robo.ancora.guilherme.entities.Marca;
import com.robo.ancora.guilherme.repositories.MarcaRepository;
import com.robo.ancora.guilherme.services.exceptions.DatabaseException;
import com.robo.ancora.guilherme.services.exceptions.ResourceNotFoundException;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MarcaDTO> findAllPaged(Pageable pageable) {
		Page<Marca> list = repository.findAll(pageable);
		return list.map(x -> new MarcaDTO(x));

	}
	
	@Transactional(readOnly = true)
	public MarcaDTO findById(Long id) {
		Optional<Marca> obj = repository.findById(id);
		Marca entity = obj.orElseThrow(() -> new ResourceNotFoundException(" Entidade não existe"));
		return new MarcaDTO(entity);

	}
	
	@Transactional
	public MarcaDTO insert(MarcaDTO dto) {
		Marca entity = new Marca();
		entity.setNomMarca(dto.getNomMarca());
		entity.setAtivoInativo(dto.getAtivoInativo());
		entity.setIdUsuarioCadastro(dto.getIdUsuarioCadastro());
		entity.setDatCadastro(dto.getDatCadastro());
		entity = repository.save(entity);
		return new MarcaDTO(entity);
	}
	
	@Transactional
	public MarcaDTO update(Long id, MarcaDTO dto) {
		try {
			Marca entity = repository.getOne(id);
			entity.setNomMarca(dto.getNomMarca());
			entity.setAtivoInativo(dto.getAtivoInativo());
			entity.setIdUsuarioCadastro(dto.getIdUsuarioCadastro());
			entity.setDatCadastro(dto.getDatCadastro());
			entity = repository.save(entity);
			return new MarcaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
		    repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}

}
