package com.robo.ancora.guilherme.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.robo.ancora.guilherme.entities.Usuario;
import com.robo.ancora.guilherme.entities.enums.Situacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String nom_usuario;
	
	@NotBlank(message = "Campo requerido")
	private Situacao ativo_inativo;
	
	@NotBlank(message = "Campo requerido")
	private Date dat_cadastro;
	


	public  UsuarioDTO(Usuario entity) {
		id = entity.getId();
		nom_usuario = entity.getNom_usuario();
		ativo_inativo = entity.getAtivo_inativo();
		dat_cadastro = entity.getDat_cadastro();
		
	}
}
