package com.adidas.hooks;

import com.adidas.serenitySteps.steps;
import com.adidas.utils.utils;

import cucumber.api.java.Before;
import cucumber.api.java.After;

public class Hooks {
	@Before("@PetStore")
	public void beforeScenario() {
		System.out.println("--------------------START OF SCENARIO--------------------");
		System.out.println("--------------------START OF BEFORE HOOK--------------------");


		System.out.println("--------------------END OF BEFORE HOOK--------------------");

	}

	@After("@PetStore")
	public void afterScenario() {
		System.out.println("--------------------START AFTER HOOK--------------------");

		System.out.println("--------------------END OF AFTER HOOK--------------------");
		System.out.println("--------------------END OF SCENARIO--------------------");
	}
}