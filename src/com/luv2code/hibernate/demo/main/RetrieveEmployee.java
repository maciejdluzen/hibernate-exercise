package com.luv2code.hibernate.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class RetrieveEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, 1);
			
			System.out.println("Retrieved employee " + employee);
			
			session.getTransaction().commit();
				
		} finally {
			session.close();
		}

	}

}
