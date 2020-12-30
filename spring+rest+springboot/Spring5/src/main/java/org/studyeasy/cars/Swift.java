package org.studyeasy.cars;

import org.springframework.stereotype.Component;
import org.studyeasy.Interfaces.Car;

@Component("swift")
public class Swift implements Car {

	@Override
	public String specs() {
		return "Hatchback from Suzuki";
	}



}
