package com.adidas.stepsDefinitions;


import com.adidas.hooks.Hooks;
import com.adidas.pageObjects.BasePage;
import com.adidas.pageObjects.CartPage;
import com.adidas.pageObjects.HomePage;
import com.adidas.utils.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import java.util.List;

public class stepsDefinitions {

  @Steps
  BasePage basePage = new BasePage(driver, wait);

  @Steps
  HomePage homePage = new HomePage(driver, wait);

  @Steps
  CartPage cartPage = new CartPage(driver, wait);
  
  static WebDriver driver;
	static WebDriverWait wait;
  static String baseUrl;
  String cartEndpoint;

  @Given("^I am in \"([^\"]*)\" page$")
  public void iAmInPAGE(String endpoint) {
    basePage.goTo(baseUrl, endpoint);
  }

  @Given("^I navigate to the section \"([^\"]*)\"$")
  public void iNavigateToTheSectionSECTION(String section) {
    homePage.goToSection(section);
  }

  @And("^I add to the cart the product \"([^\"]*)\"$")
  public void iAddToTheCartTheProductPRODUCT(String product) {
    homePage.addProductToCart(product);
  }

  @Then("^I delete from the cart the product \"([^\"]*)\"$")
  public void iDeleteFromTheCartTheProductPRODUCT(String product) {
    cartPage.deleteProductFromCart(product);
  }

  @When("^I want to place the order$")
  public void iWantToPlaceTheOrder() {
    cartPage.placeOrder();
  }

  @And("^I fill the form fields$")
  public void iFillTheFormFields() {
    cartPage.fillForm();
  }

  @And("^I click on \"([^\"]*)\"$")
  public void iClickOnELEMENT(String element) {
    cartPage.finishOrder(element);
  }

  @Then("^I check the field(?:s)$")
  public void iCheckTheFields(List<String> fields) {
    cartPage.checkFields(fields);
  }

  @And("^I click on OK to finish the purchase$")
  public void iClickOnOKToFinishThePurchase() {
    wait(500);
    driver.findElement(By.buttonText("OK")).click();
  }

  private void wait(int milis) {
    try {
      Thread.sleep(milis);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void setUpEnvironment() {
    driver = Hooks.driver;
    wait = Hooks.wait;

    baseUrl = utils.getProjectProperties("BASE_URL");
  }

}
