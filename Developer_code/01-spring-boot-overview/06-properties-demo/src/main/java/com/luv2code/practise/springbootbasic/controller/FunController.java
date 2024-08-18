package com.luv2code.practise.springbootbasic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	@GetMapping("/")
	public String hellowWorld() {
		return "Hello World";
	}

	@GetMapping("/getDailyFortune")
	public String getDailyFortune() {
		return "Today is your lucky Day";
	}

	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run hard 5k ";
	}
	
	@GetMapping("/teamInfo")
	public String getTeamInfo() {
		return coachName+" "+teamName;
	}
}
