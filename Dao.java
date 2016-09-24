package com;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao
{
	private static SessionFactory factory;
	public static void instantiate()
	{	
	 
	      try
	      {
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) 
	      { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	     
	}
	
	   
	public void Askhr(Integer bankid,String query){
		 
		   Session session = factory.openSession();
		   Transaction tx=null;
		   try{
			   tx=session.beginTransaction();
			   Askhr a=new Askhr();
			   a.setBankid(bankid);
			   a.setQuery(query);
			   session.save(a);
			   tx.commit();
		   }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	}
		   
}
