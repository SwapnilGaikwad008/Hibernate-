package org.swapnil.hibernate.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.swapnil.hibernate.dto.Address;
import org.swapnil.hibernate.dto.UserDetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		// user.setUserId(2);
		user.setUserName("swapnil");

		Address addr = new Address();
		addr.setStreet("abc");
		addr.setCity("Navimumbai");
		addr.setState("maharashtra");
        addr.setPincode("400001");
		
		
		Address addr2 = new Address();
		addr2.setCity("Mumbai");
		addr2.setStreet("xyz");
		addr2.setState("Maharashtra");
		addr2.setPincode("4000100");
		
		user.getListofAddress().add(addr);
		user.getListofAddress().add(addr2);
	
		// configuration in configure takes the configuration file and reads the
		// configuration file to understand
		// what's the DB conf1iguration needs to be made so its gets to cfg.xml
		// buildsessionfactory() return a session factory
		// So create new SessionFactory object
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// session object will be use to store model object
		Session session = sessionFactory.openSession();

		// create a transaction to save object
		session.beginTransaction();

		session.save(user);
		// end transaction
		session.getTransaction().commit();
		session.close(); // session will be close

		 user = null;
		 session = sessionFactory.openSession();
		 session.beginTransaction();
		  
		  //to fetch value is inserted 1st parameter is class and 2nd parameter
		  //is object of class 
		 user = (UserDetails)session.get(UserDetails.class, 1);
		 session.close(); //To check if its proxy object or not i.e lazy fetch
		 System.out.println(user.getListofAddress().size()); // size the value of proxy object
		 
		 //Even if the session is close we get the out when we use fetchType eager 
		 //bydeafault its lazy from hibernate 3
		 }
}
