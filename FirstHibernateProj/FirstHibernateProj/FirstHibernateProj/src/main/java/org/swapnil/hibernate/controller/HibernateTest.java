package org.swapnil.hibernate.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.swapnil.hibernate.dto.Address;
import org.swapnil.hibernate.dto.UserDetails;
import org.swapnil.hibernate.dto.Vehicle;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("swapnil");
       
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		user.getVehicle().add(vehicle);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("jeep");
		
		user.getVehicle().add(vehicle2);
		vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// session object will be use to store model object
		Session session = sessionFactory.openSession();
		// create a transaction to save object
		session.beginTransaction();

	//	session.save(user);
		session.persist(user);
		
		session.save(vehicle);
		session.save(vehicle2);
		// end transaction
		session.getTransaction().commit();
		session.close(); // session will be close
		
	//the owner of the vehicle can be only one person So, oneTo one mapping is best example if user is having only one vehicle
		/*JPA Cascade Types

		The cascade types supported by the Java Persistence Architecture are as below:

		CascadeType.PERSIST : means that save() or persist() operations cascade to related entities.
		CascadeType.MERGE : means that related entities are merged when the owning entity is merged.
		CascadeType.REFRESH : does the same thing for the refresh() operation.
		CascadeType.REMOVE : removes all related entities association with this setting when the owning entity is deleted.
		CascadeType.DETACH : detaches all related entities if a “manual detach” occurs.
		CascadeType.ALL : is shorthand for all of the above cascade operations.
	*/
	}
}
