package com.demo.hibernate.client;

 

 

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

 

import com.demo.hibernate.Emp;

 

public class App1 {

 

    public static void main(String[] args) {
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Emp emp = new Emp(106, "Karthik", "Chennai", 45000);
            session.persist(emp); // It saves in session cache
            tx.commit();// It commit the changes in database
        }
        catch(HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
            sf.close();
        }
    }

 

}
 