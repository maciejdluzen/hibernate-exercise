package com.luv2code.hibernate.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee employee1 = new Employee("Maciej", "Dluzen", "Capgemini");
			
			session.beginTransaction();
			
			session.save(employee1);
			
			session.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}

	}

}
