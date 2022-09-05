package com.i2i.hibernateUtil;
 
import com.i2i.entity.Trainer;
import com.i2i.entity.Trainee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    public static SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    
    private  HibernateUtil() {
           
    }

    public static synchronized SessionFactory getSessionFactory() {
	if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Trainer.class)
                                                .addAnnotatedClass(Trainee.class)
                                                .buildSessionFactory();
                    
        }
        return sessionFactory;
        
    }
}