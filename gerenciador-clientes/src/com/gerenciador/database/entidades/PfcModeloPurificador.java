package com.gerenciador.database.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class PfcModeloPurificador implements Serializable{

	private static final long serialVersionUID = -977498554863855832L;
	
	private Integer codModelo;
	private String nomeModelo;
	private BigDecimal qtdLitros;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getQtdLitros() {
		return qtdLitros;
	}

	public void setQtdLitros(BigDecimal qtdLitros) {
		this.qtdLitros = qtdLitros;
	}

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

}
