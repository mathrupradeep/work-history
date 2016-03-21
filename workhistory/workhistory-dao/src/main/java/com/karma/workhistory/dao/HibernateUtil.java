package com.karma.workhistory.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil {

	@Autowired
	private static SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

}
