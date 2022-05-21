package com.gerenciador.database.bo.imp;

import com.gerenciador.database.GenericProcedures;
import com.gerenciador.database.bo.PfcClienteBO;
import com.gerenciador.database.dao.PfcClienteDAO;
import com.gerenciador.database.entidades.PfcCliente;
import com.gerenciador.util.PfcGlobal;

import java.util.ArrayList;
import java.util.List;

public class PfcClienteBOImp implements PfcClienteBO, GenericProcedures {

	private PfcClienteDAO clienteDao;

	private PfcClienteDAO getClienteDao() {
		if (clienteDao == null) {
			clienteDao = new PfcClienteDAO();
		}
		return clienteDao;
	}

	@Override
	public List<PfcCliente> buscarTodos() {
		return getClienteDao().buscarTodos(null);
	}

	@Override
	public List<PfcCliente> buscarTodosFisico() {
		ArrayList<PfcCliente> lstPessoasFisicas = new ArrayList<>();

		for (PfcCliente p : getClienteDao().buscarTodos(PfcGlobal.PESSOA_FISICA)) {
			lstPessoasFisicas.add(p);
		}
		return lstPessoasFisicas;
	}

	@Override
	public List<PfcCliente> buscarTodosJuridico() {
		ArrayList<PfcCliente> lst = new ArrayList<>();
		for (PfcCliente p : getClienteDao().buscarTodos(PfcGlobal.PESSOA_JURIDICA)) {
			lst.add(p);
		}
		return lst;
	}

	@Override
	public List<PfcCliente> buscarPorNome(String nome) {
		return getClienteDao().buscarPorNome(nome);
	}

	@Override
	public void gravar(Object obj) {
		getClienteDao().gravar((PfcCliente) obj);
	}

	@Override
	public Object buscarPorCodigo(Integer codigo) {
		return getClienteDao().buscarPorCodigo(codigo);
	}

	@Override
	public PfcCliente buscarPorCpfCnpj(String doc, String tipCliente) {
		return getClienteDao().buscarPorCpfCnpj(doc, tipCliente);
	}

}
