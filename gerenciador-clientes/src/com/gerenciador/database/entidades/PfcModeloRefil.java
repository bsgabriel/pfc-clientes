package com.gerenciador.database.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class PfcModeloRefil implements Serializable {

	private static final long serialVersionUID = 328010878550836394L;

	private Integer codModelo;
	private String nomeModelo;
	private BigDecimal preco;
	private String descricao;

	public Integer getCodModelo() {
		return codModelo;
	}

	public void setCodModelo(Integer codModelo) {
		this.codModelo = codModelo;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
