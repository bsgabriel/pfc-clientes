package com.gerenciador.database.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PfcCliente implements Serializable {

	private static final long serialVersionUID = 317044111579842365L;

	private Integer codCliente;
	private String nome;
	private String observacao;
	private Integer codEndereco;
	private String numeroTelefone;
	private String numeroCelular;
	private String email;
	private String tipCliente;
	private String cpfCnpj;
	private PfcEndereco pfcEndereco;
	private Set<PfcPurificador> pfcPurificadores;

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Integer codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipCliente() {
		return tipCliente;
	}

	public void setTipCliente(String tipCliente) {
		this.tipCliente = tipCliente;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public PfcEndereco getPfcEndereco() {
		return pfcEndereco;
	}

	public void setPfcEndereco(PfcEndereco pfcEndereco) {
		this.pfcEndereco = pfcEndereco;
	}

	public Set<PfcPurificador> getPfcPurificadores() {
		return pfcPurificadores;
	}

	public void setPfcPurificadores(Set<PfcPurificador> pfcPurificadores) {
		this.pfcPurificadores = pfcPurificadores;
	}

}
