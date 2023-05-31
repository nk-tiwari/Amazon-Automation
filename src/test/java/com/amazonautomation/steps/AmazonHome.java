package com.amazonautomation.steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonautomation.ApplicationConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonHome {
	
	WebDriver driver;
	
	public AmazonHome(TestConfiguration config) {
		this.driver = config.getWebDriver();
	}
	
	@Given("I am on Amazon Homepage")
	public void i_am_on_amazon_homepage() {
		driver.get(ApplicationConstants.AMAZON_HOMEPAGE);
	}

	@When("I search for an item")
	public void i_search_for_an_item() {
		driver.findElement(By.xpath(ApplicationConstants.SEARCH_BOX_XPATH)).sendKeys(ApplicationConstants.ITEM_TO_SEARCH);;
	}

	@When("I click on search icon")
	public void i_click_on_search_icon() {
		driver.findElement(By.xpath(ApplicationConstants.SEARCH_ICON_XPATH)).click();
	}

	@Then("I am on results page")
	public void i_am_on_results_page() {
		String actualText = driver.findElement(By.xpath(ApplicationConstants.SEARCH_RESULT_TEXT_XPATH)).getText();
	    String expectedText = ApplicationConstants.ITEM_TO_SEARCH;
	    
		if(!actualText.contains(expectedText)) {
	    	fail("Expected and actual results are different");
	    }
	}

}
