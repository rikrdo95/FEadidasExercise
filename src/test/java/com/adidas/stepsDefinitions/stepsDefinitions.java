package com.adidas.stepsDefinitions;

import com.adidas.serenitySteps.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

public class stepsDefinitions {

  @Given("^I navigate to the section \"([^\"]*)\"$")
  @And("^I navigate to the section \"([^\"]*)\"$")
  @Then("^I navigate to the section \"([^\"]*)\"$")
  public void iNavigateToTheSectionSECTION(String section) {
    steps.iNavigateToTheSectionsSECTIONS(section);
  }

  @And("^I add to the cart the product \"([^\"]*)\"$")
  public void iAddToTheCartTheProductPRODUCT(String product) {
    steps.iAddToTheCartTheProductPRODUCT(product);
  }

  @Then("^I delete from the cart the product \"([^\"]*)\"$")
  public void iDeleteFromTheCartTheProductPRODUCT(String product) {
    steps.iDeleteFromTheCartTheProductPRODUCT(product);
  }

  @When("^I want to place the order$")
  public void iWantToPlaceTheOrder() {
    steps.iWantToPlaceTheOrder();
  }

  @And("^I fill the form fields$")
  public void iFillTheFormFields() {
    steps.iFillTheFormFields();
  }

  @And("^I click on \"([^\"]*)\"$")
  public void iClickOnELEMENT(String element) {
    steps.iClickOnELEMENT(element);
  }

  @Then("^I check the field(?s)$")
  public void iCheckTheFields(DataTable fields) {
    steps.iCheckTheFields(fields);
  }

  @And("^I click on Ok to finish the purchase$")
  public void iClickOnOkToFinishThePurchase() {
    steps.iClickOnOkToFinishThePurchase();
  }

}
