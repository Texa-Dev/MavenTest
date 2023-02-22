package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/hibernate.cfg.xml");
            sessionFactory=configuration.buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory(){return sessionFactory;}

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
