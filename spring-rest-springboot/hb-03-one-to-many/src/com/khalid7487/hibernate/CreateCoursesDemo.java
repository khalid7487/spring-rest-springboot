package com.khalid7487.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalid7487.hibernate.entity.Course;
import com.khalid7487.hibernate.entity.Instructor;
import com.khalid7487.hibernate.entity.InstructorDetail;


public class CreateCoursesDemo {

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
			
			//create some courses 
			Course tempcourse1 = new Course("IR");
			Course tempcourse2 = new Course("Introduction of public Admistration");
			
			//add course to instructor 
			tempInstructor.add(tempcourse1);
			tempInstructor.add(tempcourse2);
			
			//save the course 
			session.save(tempcourse1);
			session.save(tempcourse2);
			//commit transaction
			session.getTransaction().commit();
			
		} finally{
			//add clean up code
			session.close();
			factory.close();
		}
	}
}
