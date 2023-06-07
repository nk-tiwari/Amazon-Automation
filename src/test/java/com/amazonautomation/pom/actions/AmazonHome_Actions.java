package com.amazonautomation.pom.actions;

import org.openqa.selenium.WebDriver;

import com.amazonautomation.pom.elements.AmazonHome_Elements;
import com.amazonautomation.steps.TestConfiguration;

public class AmazonHome_Actions {

	private WebDriver driver;
	private AmazonHome_Elements amazonHomeelement;

	public AmazonHome_Actions(TestConfiguration config) {
		this.driver = config.getWebDriver();
		amazonHomeelement = new AmazonHome_Elements(driver);
	}

	public void enterSearchString(String key) {
		amazonHomeelement.amazonHomeSearchBox.sendKeys(key);
	}

	public void clickOnSearchBtn() {
		amazonHomeelement.amazonHomeSearchBtn.click();
	}

	public String getSearchResultText() {
		return amazonHomeelement.searchResultTxtxPath.getText();
	}
}
