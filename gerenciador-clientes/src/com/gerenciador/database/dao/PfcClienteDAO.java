package com.gerenciador.database.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.gerenciador.database.DbConnection;
import com.gerenciador.database.entidades.PfcCliente;

public class PfcClienteDAO {

	/*
	 * variáveis com os nomes de alguns atributos, para evitar a repetição de
	 * strings
	 */
	private static final String CAMPO_TIP_CLIENTE = "tipCliente";
	private static final String CAMPO_CPF_CNPJ = "cpfCnpj";
	private static final String CAMPO_NOME = "nome";
	private static final String CAMPO_CODIGO = "codCliente";

	@SuppressWarnings("unchecked")
	public PfcCliente buscarPorCpfCnpj(String value, String tipCliente) {
		CriteriaBuilder builder = DbConnection.getInstance().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PfcCliente> critQuery = builder.createQuery(PfcCliente.class);
		Root<?> root = null;

		root = critQuery.from(PfcCliente.class);

		critQuery.select((Selection<? extends PfcCliente>) root);
		critQuery.where(//
				builder.equal(root.get(CAMPO_TIP_CLIENTE), tipCliente), //
				builder.equal(root.get(CAMPO_CPF_CNPJ), value)); 

		Query<PfcCliente> query = DbConnection.getInstance().getCurrentSession().createQuery(critQuery);
		return query.getSingleResult();
	}

	public List<PfcCliente> buscarTodos(String tipCliente) {
		CriteriaBuilder builder = DbConnection.getInstance().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PfcCliente> critQuery = builder.createQuery(PfcCliente.class);
		Root<PfcCliente> root = critQuery.from(PfcCliente.class);

		critQuery.select(root);

		if (tipCliente != null) {
			critQuery.where(builder.equal(root.get(CAMPO_TIP_CLIENTE), tipCliente));
		}

		Query<PfcCliente> query = DbConnection.getInstance().getCurrentSession().createQuery(critQuery);
		return query.getResultList();
	}

	public List<PfcCliente> buscarPorNome(String nome) {
		CriteriaBuilder builder = DbConnection.getInstance().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PfcCliente> critQuery = builder.createQuery(PfcCliente.class);
		Root<PfcCliente> root = critQuery.from(PfcCliente.class);

		critQuery.select(root);
		critQuery.where(builder.like(root.get(CAMPO_NOME), "%" + nome + "%"));

		Query<PfcCliente> query = DbConnection.getInstance().getCurrentSession().createQuery(critQuery);
		return query.getResultList();
	}

	public PfcCliente buscarPorCodigo(Integer codigo) {
		CriteriaBuilder builder = DbConnection.getInstance().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PfcCliente> critQuery = builder.createQuery(PfcCliente.class);
		Root<PfcCliente> root = critQuery.from(PfcCliente.class);

		critQuery.select(root);
		critQuery.where(builder.equal(root.get(CAMPO_CODIGO), codigo));

		Query<PfcCliente> query = DbConnection.getInstance().getCurrentSession().createQuery(critQuery);
		return query.uniqueResult();
	}

	public void gravar(PfcCliente cliente) {
		Transaction tx = null;
		try {
			tx = DbConnection.getInstance().getCurrentSession().beginTransaction();
			DbConnection.getInstance().getCurrentSession().persist(cliente);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Transação falhou:");
			e.printStackTrace();
		}
	}
}
