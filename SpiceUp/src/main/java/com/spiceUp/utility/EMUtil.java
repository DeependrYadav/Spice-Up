package com.spiceUp.utility;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtil {
	static EntityManagerFactory emf = null;

	public static EntityManagerFactory createEntityManager() {
		return Persistence.createEntityManagerFactory("spiceUp");
	}
}
