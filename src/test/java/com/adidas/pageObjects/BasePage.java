package com.adidas.pageObjects;

import com.adidas.utils.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step
    public void goTo(String baseUrl, String endpoint) {
        driver.get(baseUrl + (endpoint.equals("home") ? "" : getEndpoint(endpoint)));
        assertThat(driver.getCurrentUrl(), is(baseUrl + (endpoint.equals("home") ? "" : getEndpoint(endpoint))));
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void writeText(WebElement element, String word) {
        element.sendKeys(word);
    }

    public void waitVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitAlertAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert myalert = driver.switchTo().alert();
        myalert.accept();
    }

    public void wait(int milis) {
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String getEndpoint(String endpoint) {
        return utils.getProjectProperties(endpoint.toUpperCase());
    }

}
