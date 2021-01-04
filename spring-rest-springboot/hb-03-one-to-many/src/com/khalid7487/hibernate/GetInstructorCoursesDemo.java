package com.khalid7487.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalid7487.hibernate.entity.Course;
import com.khalid7487.hibernate.entity.Instructor;
import com.khalid7487.hibernate.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
		    
			//get the instructor form db
			int theID=1;
			Instructor tempInstructor =session.get(Instructor.class, theID);

			System.out.println("Instructor :" + tempInstructor);
		    if(tempInstructor == null) {
		    	System.out.println("Invalid ID!!");
		    }else {
		    	//get courses for the instructor
				System.out.println("Course: " +tempInstructor.getCourse());
		    }
			
		
			
			//commit transaction
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			//add clean up code
			session.close();
			factory.close();
		}
	}
}
