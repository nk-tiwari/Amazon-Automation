package com.amazonautomation.steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;

import com.amazonautomation.ApplicationConstants;
import com.amazonautomation.pom.actions.AmazonHome_Actions;
import com.amazonautomation.pom.actions.CommonActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonHome {
	
	private CommonActions commonActions;
	private AmazonHome_Actions amazonHomeActions;
	
	public AmazonHome(CommonActions commonActions, AmazonHome_Actions amazonHomeActions) {
		this.commonActions = commonActions;
		this.amazonHomeActions = amazonHomeActions;
	}
	
	@Given("I am on Amazon Homepage")
	public void i_am_on_amazon_homepage() {
		commonActions.navigateToUrl(ApplicationConstants.AMAZON_HOMEPAGE);
	}

	@When("I search for an item")
	public void i_search_for_an_item() {
		amazonHomeActions.enterSearchString(ApplicationConstants.ITEM_TO_SEARCH);
	}

	@When("I click on search icon")
	public void i_click_on_search_icon() {
		amazonHomeActions.clickOnSearchBtn();
	}

	@Then("I am on results page")
	public void i_am_on_results_page() {
		String actualText = amazonHomeActions.getSearchResultText();
	    String expectedText = ApplicationConstants.ITEM_TO_SEARCH;
	    
		if(!actualText.contains(expectedText)) {
	    	fail("Expected and actual results are different");
	    }
	}

}
