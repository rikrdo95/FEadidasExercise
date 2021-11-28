package com.adidas.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;


public class HomePage extends BasePage {

	private WebElement productElement;
	private WebElement addToCartLink;


	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
        PageFactory.initElements(driver, this);
	}

    @Step
    public void goToSection(String section) {
        click(driver.findElement(By.linkText(section)));
    }

    @Step
    public void addProductToCart(String product) {
        wait(500);

        productElement = driver.findElement(By.linkText(product));
        waitVisibility(productElement);
        click(productElement);

        wait(1500);
        addToCartLink = driver.findElement(By.linkText("Add to cart"));
        waitVisibility(addToCartLink);
        click(addToCartLink);

        waitAlertAndAccept();
    }
        
}