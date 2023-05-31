package com.amazonautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestConfiguration {

	private WebDriver driver;

	@Before
	public void initSetUp() {
		System.setProperty("webdriver.chrome.driver", "WebDrivers//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void endProcess() {
		driver.close();
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}
