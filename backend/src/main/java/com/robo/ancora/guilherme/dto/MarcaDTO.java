package com.robo.ancora.guilherme.dto;

import java.io.Serializable;
import java.util.Date;

import com.robo.ancora.guilherme.entities.Marca;
import com.robo.ancora.guilherme.entities.enums.Situacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Situacao ativoInativo;
	
	private String nomMarca;
	
	private String idUsuarioCadastro;
	
	private Date datCadastro;
	
	
	public MarcaDTO(Marca entity) {
		id = entity.getId();
		ativoInativo = entity.getAtivoInativo();
		nomMarca = entity.getNomMarca();
		idUsuarioCadastro =  entity.getIdUsuarioCadastro();
		datCadastro =  entity.getDatCadastro();
	}


}
