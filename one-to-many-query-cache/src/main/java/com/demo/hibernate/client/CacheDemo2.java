package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class CacheDemo2 {
public static void main(String[] args) {

    
    Configuration cfg = new Configuration().configure();
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    try {
    	//Emp e = new Emp(220, "James", "Hyderabad", 89000);
    	Emp e = session.get(Emp.class, 107);
    	e.setCity("California");
    	session.update(e);
    	tx.commit();
    	
    	System.out.println(sf.getCache().containsEntity(Emp.class, 107));
    	session.close();
    	Session session1 = sf.openSession();
    	Emp e1 = session1.get(Emp.class, 107);
    	System.out.println(e1.getCity()); //object coming from second level cache
    	//less no of writes, more no of reads - second level cache is useful. With the above prog, data is getting updated to db and second level cache
        	
    }
    catch(HibernateException e) {
        //tx.rollback();
        e.printStackTrace();
    }
    finally{
        //session.close();
        sf.close();
    }

}
}
