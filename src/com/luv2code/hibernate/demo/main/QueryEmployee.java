package com.luv2code.hibernate.demo.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Employee> employees = session.createQuery("from Employee e where e.company = 'Capgemini'").getResultList();
			
			displayEmployees(employees);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

	private static void displayEmployees(List<Employee> employees) {
		employees.forEach(employee -> System.out.println(employee));
	}

}
