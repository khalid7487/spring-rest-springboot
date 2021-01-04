package com.khalid7487.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalid7487.hibernate.entity.Instructor;
import com.khalid7487.hibernate.entity.InstructorDetail;
import com.khalid7487.hibernate.entity.Student;



public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		
		try {

			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId =4556;
			InstructorDetail tempInstructorDetail =
					 session.get(InstructorDetail.class, theId );
			
			//print the instructor detail
			System.out.println("tempInstructorDetail:" + tempInstructorDetail);
			
			//print the associated instructor
			 System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());
			 
			//commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
	}
}