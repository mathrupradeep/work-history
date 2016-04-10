package com.karma.workhistory.dao;

import java.awt.SecondaryLoop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hibernateUtil")
public class HibernateUtil<T, O> {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void persistSaveOrUpdate(Class<T> type, O obj) {
		if (obj == null) {
			throw new NullPointerException("Obj is null");
		}

		Session session = null;

		try {
			session = getSession();
			session.save(obj);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(session != null){
					session.close();
			}
		}

	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	private T createObject(Class<T> type) {
		try {
			return type.newInstance();
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

	}
}
