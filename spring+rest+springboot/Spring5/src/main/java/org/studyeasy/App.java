package org.studyeasy;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.studyeasy.Interfaces.Car;
import org.studyeasy.cars.Corolla;
import org.studyeasy.cars.Swift;

public class App {

	public static void main(String[] args) {
		Car swift = new Swift();
		Car corolla = new Corolla();
		
//		System.out.println(swift.specs());
//		System.out.println(corolla.specs());
//		
//		Car myCar = new Swift();
//	    System.out.println(myCar.specs());
	    
	    AnnotationConfigApplicationContext context =
	    		new AnnotationConfigApplicationContext(AppConfig.class);
	    
	    Car myCar =context.getBean("corolla",Car.class);
	    System.out.println(myCar.specs());
	    context.close();
	}

}
