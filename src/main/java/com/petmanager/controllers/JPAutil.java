package com.petmanager.controllers;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutil {

	private static final String UNIDAD_DE_PERSISTENCIA="com.petManager_petManager_jar_1.0-SNAPSHOTPU";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
		}
		return factory;
	}
	
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
			factory=null;
		}
	}
	
}
