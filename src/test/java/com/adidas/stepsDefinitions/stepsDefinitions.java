package com.adidas.stepsDefinitions;

import com.adidas.serenitySteps.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

public class stepsDefinitions {

  @Given("^I navigate to the section \"([^\"]*)\"$")
  public void iNavigateToTheSectionSECTION(String section) {
    steps.iNavigateToTheSectionsSECTIONS(section);
  }

  

}
