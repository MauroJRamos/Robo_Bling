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

import com.robo.ancora.guilherme.dto.ProdutoDTO;
import com.robo.ancora.guilherme.entities.Produto;
import com.robo.ancora.guilherme.repositories.ProdutoRepository;
import com.robo.ancora.guilherme.services.exceptions.DatabaseException;
import com.robo.ancora.guilherme.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Transactional(readOnly = true)
	public Page<ProdutoDTO> findAllPaged(String codigoId, Pageable pageable) {
		Page<Produto> list = repository.findWithNullCheck(codigoId, pageable);
		return list.map(x -> new ProdutoDTO(x));

	}

	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException(" Entidade não existe"));
		return new ProdutoDTO(entity);

	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProdutoDTO(entity);
	}

	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		try {
			Produto entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProdutoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}

	private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {

		entity.setCodProduto(dto.getCodProduto());
		entity.setNomProduto(dto.getNomProduto());
		entity.setDscProduto(dto.getDscProduto());
		entity.setVlrPrecoAncora(dto.getVlrPrecoAncora());
		entity.setVlrAnoFabricacao(dto.getVlrAnoFabricacao());
		entity.setMarcaId(dto.getMarcaId());
		entity.setCodCna(dto.getCodCna());
		entity.setQtdEstoque(dto.getQtdEstoque());
		entity.setVlrPrecoVenda(dto.getVlrPrecoVenda());
		entity.setDatCadastro(dto.getDatCadastro());
		entity.setDatAtualizacao(dto.getDatAtualizacao());
		entity.setIdtUsuarioCadastro(dto.getIdtUsuarioCadastro());
		entity.setDatAtualizacao(dto.getDatAtualizacao());
		entity.setAtivoInativo(dto.getAtivoInativo());

	}

}
