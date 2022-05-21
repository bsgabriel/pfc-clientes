package com.gerenciador.database.bo.imp;

import com.gerenciador.database.GenericProcedures;
import com.gerenciador.database.bo.PfcEnderecoBO;
import com.gerenciador.database.dao.PfcEnderecoDAO;
import com.gerenciador.database.entidades.PfcEndereco;

public class PfcEnderecoBOImp implements PfcEnderecoBO, GenericProcedures {

	private PfcEnderecoDAO enderecoDao;

	private PfcEnderecoDAO getEnderecoDao() {
		if (enderecoDao == null) {
			enderecoDao = new PfcEnderecoDAO();
		}
		return enderecoDao;
	}

	@Override
	public void gravar(Object obj) {
		getEnderecoDao().gravar((PfcEndereco) obj);
	}

	@Override
	public PfcEndereco buscarPorCodigo(Integer codigo) {
		return getEnderecoDao().buscarPorCodigo(codigo);
	}
}
