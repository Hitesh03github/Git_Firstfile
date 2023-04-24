package com.velocity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SampleExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// step-11
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// step-2-
		SessionFactory sf = configuration.buildSessionFactory();

		// step-3-
		Session s = sf.openSession();

		// step-4-
		Transaction t = s.beginTransaction();

		// How to set the value into employee object
		Employee emp1 = new Employee();
		emp1.setName("amit");
		emp1.setEmail("amit@gmail.com");

		Employee emp2 = new Employee();
		emp2.setName("rahul");
		emp2.setEmail("rahul@gmail.com");

		// How to set the value into address object
		Address address = new Address();
		address.setCity("pune");
		address.setState("maharashtra");
		address.setCountry("india");
		address.setPincode("123456");

		emp1.setAddress(address);
		emp2.setAddress(address);

		s.save(emp1);
		s.save(emp2);
		t.commit();
	}
}
