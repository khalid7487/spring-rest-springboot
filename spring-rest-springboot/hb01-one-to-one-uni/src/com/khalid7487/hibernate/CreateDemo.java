package com.khalid7487.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalid7487.hibernate.entity.Instructor;
import com.khalid7487.hibernate.entity.InstructorDetail;
import com.khalid7487.hibernate.entity.Student;



public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects 
/*			Instructor tempInstructor =
					new Instructor("Khalid", "Hossen", "khalid7487@gmail.com");
			InstructorDetail tempInstructorDerail = 
					 new InstructorDetail(
							 "http://www.luv2code.com/youtube",
							 "Love to code !!!!");*/
			Instructor tempInstructor =
					new Instructor("Azmira Sultana ", "Mou", "mou7487@gmail.com");
			InstructorDetail tempInstructorDerail = 
					 new InstructorDetail(
							 "http://www.mou.com/youtube",
							 "Love to read !!!!");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDerail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//
			//Note: this will Also save the details object
			// because of CascadeType.All
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			factory.close();
		}
	}
}
