package com.gerenciador.database.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.gerenciador.database.DbConnection;
import com.gerenciador.database.entidades.PfcEndereco;

public class PfcEnderecoDAO {

	private static final String CAMPO_CODIGO = "codEndereco";

	public PfcEndereco buscarPorCodigo(Integer codigo) {
		CriteriaBuilder builder = DbConnection.getInstance().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<PfcEndereco> critQuery = builder.createQuery(PfcEndereco.class);
		Root<PfcEndereco> root = critQuery.from(PfcEndereco.class);

		critQuery.select(root);
		critQuery.where(builder.equal(root.get(CAMPO_CODIGO), codigo));

		Query<PfcEndereco> query = DbConnection.getInstance().getCurrentSession().createQuery(critQuery);
		return query.uniqueResult();
	}

	public void gravar(PfcEndereco endereco) {
		Transaction tx = null;
		try {
			tx = DbConnection.getInstance().getCurrentSession().beginTransaction();
			DbConnection.getInstance().getCurrentSession().persist(endereco);
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
