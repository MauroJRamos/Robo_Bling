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


import com.robo.ancora.guilherme.dto.UsuarioDTO;
import com.robo.ancora.guilherme.entities.Usuario;
import com.robo.ancora.guilherme.repositories.UsuarioRepository;
import com.robo.ancora.guilherme.services.exceptions.DatabaseException;
import com.robo.ancora.guilherme.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public Page<UsuarioDTO> findAllPaged(Pageable pageable) {
		Page<Usuario> list = repository.findAll(pageable);
		return list.map(x -> new UsuarioDTO(x));

	}

	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException(" Entidade não existe"));
		return new UsuarioDTO(entity);

	}

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		entity.setNom_usuario(dto.getNom_usuario());
		entity.setAtivo_inativo(dto.getAtivo_inativo());
		entity.setDat_cadastro(dto.getDat_cadastro());
		entity = repository.save(entity);
		return new UsuarioDTO(entity);
	}

	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario entity = repository.getOne(id);
			entity.setNom_usuario(dto.getNom_usuario());
			entity.setAtivo_inativo(dto.getAtivo_inativo());
			entity.setDat_cadastro(dto.getDat_cadastro());
			entity = repository.save(entity);
			return new UsuarioDTO(entity);
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
