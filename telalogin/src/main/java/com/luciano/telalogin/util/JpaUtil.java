package com.luciano.telalogin.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;
	
	static {
		try {
			factory = Persistence.createEntityManagerFactory("dbusuario");
		} catch (Throwable e) {
			System.err.println("Erro na criação do EntityManagerFactory: " + e);
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void close() {
		if (factory != null) {
			factory.close();
		}
	}
	
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> close()));
	}
}
