package com.robo.ancora.guilherme.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.robo.ancora.guilherme.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
     //"(:codigoId IS NULL OR obj.codProduto = :codigoId) ")
	@Query("SELECT u FROM com.robo.ancora.guilherme.entities.Usuario "
			+ "u WHERE :nomeUsuario IS NULL OR u.nom_usuario =:nomeUsuario")
	Page<Usuario> findByNomeUsuario(String nomeUsuario, Pageable pageable);
	
	default Page<Usuario> findWithNullCheck(String nomeUsuario, Pageable pageable) {
        if (nomeUsuario == null || nomeUsuario.equals("0")) {
        	nomeUsuario = null;
        }
        return findByNomeUsuario(nomeUsuario, pageable);
    }
}
