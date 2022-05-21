package com.gerenciador.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gerenciador.database.entidades.PfcCliente;
import com.gerenciador.database.entidades.PfcEndereco;
import com.gerenciador.database.entidades.PfcModeloPurificador;
import com.gerenciador.database.entidades.PfcModeloRefil;
import com.gerenciador.database.entidades.PfcPurificador;
import com.gerenciador.util.PfcGlobal;

public class DbConnection {

	private static DbConnection instance;
	private SessionFactory sessionFactory;
	private Session currentSession;

	private String driverJdbc;
	private String url;
	private String user;
	private String password;
	private String database;
	private Integer port;
	private String host;
	private ArrayList<String> classList;

	public static DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}

	public Session getCurrentSession() {
		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
		}
		return currentSession;
	}

	private DbConnection() {
		loadParams();
		this.database = PfcGlobal.DB_PROPERTIES.getProperty("database");
		this.host = PfcGlobal.DB_PROPERTIES.getProperty("host");
		this.port = Integer.valueOf(PfcGlobal.DB_PROPERTIES.getProperty("port"));
		this.user = PfcGlobal.DB_PROPERTIES.getProperty("user");
		this.password = PfcGlobal.DB_PROPERTIES.getProperty("password");
		this.driverJdbc = "org.postgresql.Driver";
		this.url = String.format("jdbc:postgresql://%s:%s/%s", this.host, this.port, this.database); 
//		this.url = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.database;
		loadConfig();
	}

	private void loadParams() {
		InputStream input = null;

		try {
			input = new FileInputStream("database.properties");
			PfcGlobal.DB_PROPERTIES.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void loadConfig() {
		Configuration config = new Configuration();
		config.setProperty("hibernate.connection.driver_class", this.driverJdbc);
		config.setProperty("hibernate.connection.url", this.url);
		config.setProperty("hibernate.connection.username", this.user);
		config.setProperty("hibernate.connection.password", this.password);
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		config.setProperty("hibernate.show_sql", "true");
		config.setProperty("hibernate.format_sql", "true");
		config.setProperty("hbm2ddl.auto", "update");

		for (String strClass : getClassList()) {
			config.addResource(hbmForObject(strClass));
		}

		sessionFactory = config.buildSessionFactory();

	}

	private ArrayList<String> getClassList() {
		if (classList == null) {
			classList = new ArrayList<>();
		}
		classList.add(PfcModeloPurificador.class.getName());
		classList.add(PfcModeloRefil.class.getName());
		classList.add(PfcPurificador.class.getName());
		classList.add(PfcEndereco.class.getName());
		classList.add(PfcCliente.class.getName());

		return classList;
	}

	public void insert(Object obj) {
		Transaction tx = null;

		try {
			tx = getCurrentSession().beginTransaction();
			getCurrentSession().persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Transação falhou:");
			e.printStackTrace();
		}
	}

	public Object search(Class<?> clazz, Serializable pk) {
		Transaction tx = null;

		Object ret = null;
		try {
			tx = getCurrentSession().beginTransaction();
			ret = getCurrentSession().get(clazz, pk);
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Transação falhou:");
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * search for the .hbm.xml file for the given class
	 * 
	 * @param strClass class name as string
	 * @return path to the xml file
	 */
	private String hbmForObject(String strClass) {
		strClass = strClass.replace(".", "/");
		strClass = strClass.replace("/entidades", "/entidades/map");
		strClass = strClass.concat(".hbm.xml");
		return strClass;
	}

}
