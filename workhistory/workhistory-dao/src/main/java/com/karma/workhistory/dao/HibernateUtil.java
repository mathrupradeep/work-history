package com.karma.workhistory.dao;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.googlecode.genericdao.dao.hibernate.GeneralDAOImpl;

@Repository("hibernateUtil")
public class HibernateUtil<T, O> extends GeneralDAOImpl implements GeneralDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	public SessionFactory getsessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@PostConstruct
	public void setupSessionFactoryToSuperClass(){
		super.setSessionFactory(sessionFactory);	
	}
	
}
