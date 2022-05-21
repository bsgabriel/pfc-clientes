package com.gerenciador.database.entidades;

import java.io.Serializable;

public class PfcEndereco implements Serializable {

	private Integer codEndereco;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private Integer numero;
	private PfcEndereco pfcEndereco;

	public Integer getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Integer codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public PfcEndereco getPfcEndereco() {
		return pfcEndereco;
	}

	public void setPfcEndereco(PfcEndereco pfcEndereco) {
		this.pfcEndereco = pfcEndereco;
	}

}