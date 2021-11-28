package com.adidas.pageObjects;

import com.adidas.utils.utils;

import org.openqa.selenium.Alert;
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

	public void click(WebElement element) {
		element.click();
	}

	public void writeText(WebElement element, String word) {
		element.sendKeys(word);
	}

	public void waitVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

    public void waitAlertAndAccept() {
        wait(500);
        ExpectedConditions.alertIsPresent();
        Alert myalert = driver.switchTo().alert();
        myalert.accept();    
	}

	public String exists(WebElement element) {
		waitVisibility(element);
		if (element.getText().isEmpty()) {
			return element.getText();
		} else {
			return "null";
		}
	}

    public void wait(int milis) {
        try {
          Thread.sleep(milis);
        } catch (Exception e) {
          System.out.println(e);
        }
      }    

      private String getEndpoint(String endpoint){
        return utils.getProjectProperties(endpoint.toUpperCase());
      }

}