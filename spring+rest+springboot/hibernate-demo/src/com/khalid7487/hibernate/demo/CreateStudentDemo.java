package com.khalid7487.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalid7487.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =
				new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();;
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating new student object....");
			Student tempStudent = new Student("Khalid","Hossen","khalid7487@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student....");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			factory.close();
		}
	}
}