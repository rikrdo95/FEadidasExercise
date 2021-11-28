package com.adidas.hooks;

import com.adidas.stepsDefinitions.stepsDefinitions;
import com.adidas.utils.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.After;

public class Hooks {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions builder;

	@Before("@PetStore")
	public void beforeScenario() {
		System.out.println("--------------------START OF SCENARIO--------------------");
		System.out.println("--------------------START OF BEFORE HOOK--------------------");

		// Initialize webdriver, by default chrome
		String browser = System.getProperty("browser").equals("") ? "chrome" : System.getProperty("browser");
		driver = initializeDriver(browser);
		wait = new WebDriverWait(this.driver, 10);
		builder = new Actions(driver);

		stepsDefinitions.setUpEnvironment();

		System.out.println("--------------------END OF BEFORE HOOK--------------------");

	}

	@After("@PetStore")
	public void afterScenario() {
		System.out.println("--------------------START AFTER HOOK--------------------");

		// Closes the browser
		driver.quit();

		System.out.println("--------------------END OF AFTER HOOK--------------------");
		System.out.println("--------------------END OF SCENARIO--------------------");
	}

	private WebDriver initializeDriver(String browser) {
		WebDriver driver;

		switch(browser){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
				ChromeOptions chrome_options = new ChromeOptions();
				chrome_options.addArguments("start-maximized");
				// chrome_options.addArguments("--headless");
				chrome_options.addArguments("--no-sandbox");
				driver = new ChromeDriver(chrome_options);
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver.exe");

				FirefoxOptions firefox_options = new FirefoxOptions();
				firefox_options.addArguments("start-maximized");
				// firefox_options.addArguments("--headless");
				firefox_options.addArguments("--no-sandbox");
				driver = new FirefoxDriver(firefox_options);
				break;
			default:
				driver = new ChromeDriver();
				
		}
		return driver;
	}

}