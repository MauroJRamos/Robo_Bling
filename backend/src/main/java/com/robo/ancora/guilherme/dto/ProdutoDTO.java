package com.robo.ancora.guilherme.dto;

import java.io.Serializable;
import java.util.Date;

import com.robo.ancora.guilherme.entities.Produto;
import com.robo.ancora.guilherme.entities.enums.Situacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String codProduto;
	private String nomProduto;
	private String dscProduto;
	private Double vlrPrecoAncora;
	private Integer vlrAnoFabricacao;
	private Double marcaId;
	private String codCna;
	private Integer qtdEstoque;
	private Double vlrPrecoVenda;

	private Date datCadastro;

	private Date datAtualizacao;

	private Integer idtUsuarioCadastro;
	private Integer idtUsuarioAtualizacao;

	private Situacao ativoInativo;

	public ProdutoDTO(Produto entity) {
		id = entity.getId();
		codProduto = entity.getCodProduto();
		nomProduto = entity.getNomProduto();
		dscProduto = entity.getDscProduto();
		vlrPrecoAncora = entity.getVlrPrecoAncora();
		vlrAnoFabricacao = entity.getVlrAnoFabricacao();
		marcaId = entity.getMarcaId();
		codCna = entity.getCodCna();
		qtdEstoque = entity.getQtdEstoque();
		vlrPrecoVenda = entity.getVlrPrecoAncora();
		datCadastro = entity.getDatCadastro();
		datAtualizacao = entity.getDatAtualizacao();
		idtUsuarioCadastro = entity.getIdtUsuarioCadastro();
		idtUsuarioAtualizacao = entity.getIdtUsuarioAtualizacao();
		ativoInativo = entity.getAtivoInativo();

	}

}
