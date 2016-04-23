package com.karma.workhistory.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.googlecode.genericdao.dao.hibernate.GeneralDAOImpl;
import com.googlecode.genericdao.search.ISearch;

@Repository("hibernateUtil")
public class HibernateUtil<T, O> extends GeneralDAOImpl implements GeneralDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void persistOrUpdate(Class<T> type, O obj) {
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

	
	public void deleteObject(Class<T> type, O obj) {
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
	
	public void findByCriteria(Class<T> type, O obj) {
		if (obj == null) {
			throw new NullPointerException("Obj is null");
		}

		Session session = null;

		try {
			session = getSession();
			session.getTransaction().begin();
			Criteria critera = session.createCriteria(type);
			//critera.add(arg0)
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
	
	/*public void extractData(Class<T> type, ISearch search) {
		Session session = null;

		try {
			session = getSession();
			session.getTransaction().begin();
			Criteria critera = session.createCriteria(type);
			search.g
			critera.u
			//critera.add(arg0)
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(session != null){
					session.close();
			}
		}
	}*/
	
	
}
