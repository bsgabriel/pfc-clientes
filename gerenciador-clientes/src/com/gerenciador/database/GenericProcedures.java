package com.gerenciador.database;

public interface GenericProcedures {

	public abstract void gravar(Object obj);

	public abstract Object buscarPorCodigo(Integer codigo);
}
