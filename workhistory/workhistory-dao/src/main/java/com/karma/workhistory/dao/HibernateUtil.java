package com.karma.workhistory.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();
    private static String filePath = "";

    private static SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure(filePath).buildSessionFactory();
            }
            return sessionFactory;
        } catch (final Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed."
                    + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // for junits
    public HibernateUtil(final String filePath) {
        HibernateUtil.filePath = filePath;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

}
