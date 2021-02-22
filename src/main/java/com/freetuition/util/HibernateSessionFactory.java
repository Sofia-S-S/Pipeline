package com.freetuition.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url",System.getenv("postgresUrl"))
					.setProperty("hibernate.connection.username",System.getenv("postgresUsername"))
					.setProperty("hibernate.connection.password",System.getenv("postgrasPassword"))
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
	
}
