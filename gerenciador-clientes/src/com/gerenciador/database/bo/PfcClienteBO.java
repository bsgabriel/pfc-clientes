package com.gerenciador.database.bo;

import com.gerenciador.database.entidades.PfcCliente;

import java.util.List;

public interface PfcClienteBO {

	public abstract List<PfcCliente> buscarTodos();

	public abstract List<PfcCliente> buscarTodosFisico();

	public abstract List<PfcCliente> buscarTodosJuridico();

	public abstract List<PfcCliente> buscarPorNome(String nome);

	public abstract PfcCliente buscarPorCpfCnpj(String doc, String tipCliente);

}
