package com.khalid7487.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalid7487.hibernate.entity.Course;
import com.khalid7487.hibernate.entity.Instructor;
import com.khalid7487.hibernate.entity.InstructorDetail;


public class DeleteCourseDemo {

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
		    
			//get the Course form db

			int theid=10;
			
			Course  tempCourse = session.get(Course.class, theid);
			
			if(tempCourse == null) {
				System.out.println("Invalid Id");
			}else {
				//delete course
				session.delete(tempCourse);
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
