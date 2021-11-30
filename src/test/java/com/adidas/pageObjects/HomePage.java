package com.adidas.pageObjects;

import org.openqa.selenium.WebDriver;
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
        // Wait for the first element to appear
        waitVisibility(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
    }

    @Step
    public void addProductToCart(String product) {
        try {
            waitVisibility(By.linkText(product));
            click(By.linkText(product));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            // Sometimes the element is reloaded by the page, so when we try to click it
            // the reference is gone and provoques a StaleElementReferenceException. In this
            // case I try to get the element again
            waitVisibility(By.linkText(product));
            click(By.linkText(product));
        }

        waitVisibility(By.linkText("Add to cart"));
        click(By.linkText("Add to cart"));

        waitAlertAndAccept();
    }

}
