package com.amazonautomation.pom.actions;

import org.openqa.selenium.WebDriver;

import com.amazonautomation.steps.TestConfiguration;

public class CommonActions {
	
	private WebDriver driver;

	public CommonActions(TestConfiguration config) {
		this.driver = config.getWebDriver();
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}
}
