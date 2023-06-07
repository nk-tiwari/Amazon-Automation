package com.amazonautomation.steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazonautomation.ApplicationConstants;
import com.amazonautomation.pom.actions.AmazonSearchResult_Actions;
import com.amazonautomation.pom.actions.CommonActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSearchResult {

	private CommonActions commonActions;
	private AmazonSearchResult_Actions searchResultActions;
	
	public AmazonSearchResult(CommonActions commonActions, AmazonSearchResult_Actions searchResultActions) {
		this.commonActions = commonActions;
		this.searchResultActions = searchResultActions;
	}

	@Given("I am on Search results page")
	public void i_am_on_search_results_page() {
		commonActions.navigateToUrl(ApplicationConstants.SEARCH_RESULT_PAGE_URL);
	}

	@When("I filter items by max and min price")
	public void i_filter_items_by_max_and_min_price() {
		searchResultActions.filterByMinMaxValue("1000", "2000");
	}

	@When("sort the items in descending order")
	public void sort_the_items_in_descending_order() {
//		WebElement element = driver.findElement(By.xpath(ApplicationConstants.SORT_BY_BUTTON_XPATH));
//		Select sortBy = new Select(element);
//		sortBy.selectByVisibleText("Price: High to Low");
//		driver.findElement(By.xpath(ApplicationConstants.HIGH_TO_LOW_SORT_XPATH)).click();
		searchResultActions.sortItemsAsPerKey("Price: High to Low");
	}

	@When("Pick 2nd and 4th item and add it to cart")
	public void pick_2nd_and_4th_item_and_add_it_to_cart() throws InterruptedException {
		Thread.sleep(5000);
		searchResultActions.add2ndAnd4thResultToCart();
	}

//	private void addToCart(WebElement resultItem) throws InterruptedException {
//		String parentWindowHandle = driver.getWindowHandle();
//		
//		resultItem.click();
//		
//		Set<String> childTabs = driver.getWindowHandles();
//		Iterator<String> tabsIterator = childTabs.iterator();
//		while(tabsIterator.hasNext()) {
//			String childTab = tabsIterator.next();
//			if(!childTab.equals(parentWindowHandle)) {
//				driver.switchTo().window(childTab);
//			}
//		}
//		driver.findElement(By.xpath(ApplicationConstants.ADD_TO_CART_BUTTON_XPATH)).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath(ApplicationConstants.CLOSE_ADD_TO_CART_POPUP_XPATH)).click();
//		driver.close();
//		driver.switchTo().window(parentWindowHandle);
//	}

	@When("navigate to carts section")
	public void navigate_to_carts_section() {
	    commonActions.navigateToUrl(ApplicationConstants.AMAZON_CART_URL);
	}

	@Then("I have 2 items in the cart")
	public void i_have_items_in_the_cart() {
	    String itemsCount = searchResultActions.getNoOfItemsInCart();
	    System.out.println("The cart has "+itemsCount);
	}

	@Then("Print the total cart value")
	public void print_the_total_cart_value() {
	    String totalValue = searchResultActions.getTotalValueOfCart();
	    System.out.println("Total cart value is "+totalValue);
	}
}
