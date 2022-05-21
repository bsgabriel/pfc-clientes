package com.gerenciador.database.entidades;

import java.io.Serializable;
import java.util.Date;

public class PfcPurificador implements Serializable {

	private static final long serialVersionUID = 808299559034190313L;

	private Integer codPurificador;
	private Date dtaUltimaTroca;
	private Date dtaProximaTroca;
	private PfcModeloPurificador pfcModeloPurificador;
	private PfcModeloRefil pfcModeloRefil;
	private Integer codCliente;
	private PfcCliente pfcCliente;

	public Integer getCodPurificador() {
		return codPurificador;
	}

	public void setCodPurificador(Integer codPurificador) {
		this.codPurificador = codPurificador;
	}

	public Date getDtaUltimaTroca() {
		return dtaUltimaTroca;
	}

	public void setDtaUltimaTroca(Date dtaUltimaTroca) {
		this.dtaUltimaTroca = dtaUltimaTroca;
	}

	public Date getDtaProximaTroca() {
		return dtaProximaTroca;
	}

	public void setDtaProximaTroca(Date dtaProximaTroca) {
		this.dtaProximaTroca = dtaProximaTroca;
	}

	public PfcModeloPurificador getPfcModeloPurificador() {
		return pfcModeloPurificador;
	}

	public void setPfcModeloPurificador(PfcModeloPurificador pfcModeloPurificador) {
		this.pfcModeloPurificador = pfcModeloPurificador;
	}

	public PfcModeloRefil getPfcModeloRefil() {
		return pfcModeloRefil;
	}

	public void setPfcModeloRefil(PfcModeloRefil pfcModeloRefil) {
		this.pfcModeloRefil = pfcModeloRefil;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public PfcCliente getPfcCliente() {
		return pfcCliente;
	}

	public void setPfcCliente(PfcCliente pfcCliente) {
		this.pfcCliente = pfcCliente;
	}

}
