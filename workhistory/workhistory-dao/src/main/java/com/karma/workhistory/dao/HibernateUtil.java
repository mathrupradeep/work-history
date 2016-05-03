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
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	
	public void save(Class<T> type, O obj) {
		if (obj == null) {
			throw new NullPointerException("Obj is null");
		}

		Session session = null;

		try {
			session = getSession();
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(session != null){
					session.close();
			}
		}

	}

	
	public void delete(Class<T> type, O obj) {
		if (obj == null) {
			throw new NullPointerException("Obj is null");
		}

		Session session = null;

		try {
			session = getSession();
			session.getTransaction().begin();
			session.delete(obj);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(session != null){
					session.close();
			}
		}

	}
	
	@PostConstruct
	public void setupSessionFactoryToSuperClass(){
		super.setSessionFactory(sessionFactory);
	}
	
}
