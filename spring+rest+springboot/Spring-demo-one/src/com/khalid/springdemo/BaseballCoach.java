package com.khalid.springdemo;

public class BaseballCoach implements Coach {

	//define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		// TODO Auto-generated constructor stub
		fortuneService = theFortuneService;
	}
	@Override
	public String getDaliyWorkout() {
		return "spend 30 minutes on Batting practice";
	}

	@Override
	public String getDaliyFortune() {
		//use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
