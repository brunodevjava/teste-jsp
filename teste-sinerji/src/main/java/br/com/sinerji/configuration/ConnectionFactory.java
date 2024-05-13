package br.com.sinerji.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SINERJI");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
		
	}
}
