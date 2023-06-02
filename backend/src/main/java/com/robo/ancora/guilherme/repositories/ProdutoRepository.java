package com.robo.ancora.guilherme.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.robo.ancora.guilherme.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("SELECT obj FROM com.robo.ancora.guilherme.entities.Produto obj WHERE "
            + "(:codigoId IS NULL OR obj.codProduto = :codigoId) ")
	Page<Produto> find(@Param("codigoId")String codigoId, Pageable pageable);
	
	default Page<Produto> findWithNullCheck(String codigoId, Pageable pageable) {
        if (codigoId == null || codigoId.equals("0")) {
            codigoId = null;
        }
        return find(codigoId, pageable);
    }
		
}
