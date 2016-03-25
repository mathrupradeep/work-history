package com.karma.workhistory.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionFactoryUtil {

	@Autowired
	private static SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

}
