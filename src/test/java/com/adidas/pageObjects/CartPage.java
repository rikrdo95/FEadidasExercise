package com.adidas.pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adidas.utils.utils;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CartPage extends BasePage {

    private String idOrder;
    private HashMap<String, String> productsValues = new HashMap<String, String>();
    private String amountResume;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step
    public void deleteProductFromCart(String product) {
        // Wait for the second element to appear
        waitVisibility(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[2]"));
        // Find position of the product in the list
        int productIndex = -1;
        for (int i = 1; i <= 2; i++) {
            if (driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[" + i + "]/td[2]")).getText().equals(product)) {
                productIndex = i;
            }
        }

        click(By.xpath("//*[@id=\"tbodyid\"]/tr[" + productIndex + "]/td[4]/a"));
        wait(3000);
        assertThat(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText(), not(product));

        productsValues.put(
                driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText(),
                driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]")).getText());

    }

    @Step
    public void placeOrder() {
        waitVisibility(By.buttonText("Place Order"));
        click(By.buttonText("Place Order"));
    }

    @Step
    public void fillForm() {
        JSONObject formString = utils.getJSON("form");
        waitVisibility(By.xpath("//*[@id=\"orderModal\"]/div/div"));

        writeText(driver.findElement(By.id("name")), (String) formString.get("name"));
        writeText(driver.findElement(By.id("country")), (String) formString.get("country"));
        writeText(driver.findElement(By.id("city")), (String) formString.get("city"));
        writeText(driver.findElement(By.id("card")), (String) formString.get("card"));
        writeText(driver.findElement(By.id("month")), (String) formString.get("month"));
        writeText(driver.findElement(By.id("year")), (String) formString.get("year"));
    }

    @Step
    public void finishOrder(String element) {
        waitVisibility(By.buttonText(element));
        click(By.buttonText(element));
    }

    @Step
    public void checkFields(List<String> fields) {
        waitVisibility(By.xpath("/html/body/div[10]/p"));

        String resumeText = driver.findElement(By.xpath("/html/body/div[10]/p")).getText();
        Pattern patternId = Pattern.compile("Id: (\\d*)");
        Pattern patternAmount = Pattern.compile("Amount: (\\d*)");
        Matcher matcher = patternId.matcher(resumeText);
        idOrder = matcher.find() ? matcher.group(1) : "";
        matcher = patternAmount.matcher(resumeText);
        amountResume = matcher.find() ? matcher.group(1) : "";
        System.out.println("Id: " + idOrder + ".");
        System.out.println("Amount: " + amountResume + ".");

        int calculatedAmount = 0;
        for (Map.Entry<String, String> product : productsValues.entrySet()) {
            calculatedAmount = calculatedAmount + Integer.valueOf(product.getValue());
        }
        System.out.println("Calculated amount: " + calculatedAmount);
        assertThat(Integer.valueOf(amountResume), is(calculatedAmount));
    }

    @Step
    public void finish() {
        waitVisibility(By.buttonText("OK"));
        click(By.buttonText("OK"));
    }

}
