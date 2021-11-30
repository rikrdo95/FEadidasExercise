package com.adidas.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @Step
    public void goToSection(String section) {
        click(By.linkText(section));
    }

    @Step
    public void addProductToCart(String product) {
        waitVisibility(By.linkText(product));
        click(By.linkText(product));

        waitVisibility(By.linkText("Add to cart"));
        click(By.linkText("Add to cart"));

        waitAlertAndAccept();
    }

}
