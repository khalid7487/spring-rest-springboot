package com.khalid.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
   public TrackCoach() {
	   
   }
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	} 

	@Override
	public String getDaliyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDaliyFortune() {
		return "Just Do it " + fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	//add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}

}
