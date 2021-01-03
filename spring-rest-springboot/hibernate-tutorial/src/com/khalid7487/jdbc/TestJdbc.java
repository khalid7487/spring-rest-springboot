package com.khalid7487.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
	
		String jdbcUrl = "jdbc:mysql://localhost:3306/hu_student_tracker?useSSL=false"; 
		
		String user = "hbstudent";
		String pass ="hbstudent";
		
		try {
			System.out.println("Connecting to DB:" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
