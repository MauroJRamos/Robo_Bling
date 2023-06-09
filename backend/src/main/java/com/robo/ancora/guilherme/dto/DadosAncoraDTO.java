package com.robo.ancora.guilherme.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.robo.ancora.guilherme.entities.DadosAncora;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosAncoraDTO implements Serializable {
		private static final long serialVersionUID = 1L;
		 
		private int id;
		private String codProduto;
		private String dscProduto;
		private String dscMarcaProduto;
		private Double vlrProduto;
		private LocalDateTime datRequest;

		
		public  DadosAncoraDTO(DadosAncora entity) {
			id = entity.getId();
			codProduto = entity.getCodProduto();
			dscProduto = entity.getDscProduto();
			dscMarcaProduto = entity.getDscMarcaProduto();
			vlrProduto     = entity.getVlrProduto();
			datRequest = entity.getDatRequest();
			
		}

}
