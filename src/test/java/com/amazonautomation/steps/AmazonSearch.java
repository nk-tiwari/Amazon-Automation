package com.amazonautomation.steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazonautomation.ApplicationConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSearch {

	WebDriver driver;

	public AmazonSearch(TestConfiguration config) {
		this.driver = config.getWebDriver();
	}

	@Given("I am on Search results page")
	public void i_am_on_search_results_page() {
		driver.get(ApplicationConstants.SEARCH_RESULT_PAGE_URL);
	}

	@When("I filter items by max and min price")
	public void i_filter_items_by_max_and_min_price() {
		driver.findElement(By.xpath(ApplicationConstants.LOW_PRICE_VAL_XPATH)).sendKeys("1000");
		driver.findElement(By.xpath(ApplicationConstants.HIGH_PRICE_VAL_XPATH)).sendKeys("2000");
		driver.findElement(By.xpath(ApplicationConstants.PRICE_FILTER_GO_BUTTON_XPATH)).click();
	}

	@When("sort the items in descending order")
	public void sort_the_items_in_descending_order() {
		WebElement element = driver.findElement(By.xpath(ApplicationConstants.SORT_BY_BUTTON_XPATH));
		Select sortBy = new Select(element);
		sortBy.selectByVisibleText("Price: High to Low");
		driver.findElement(By.xpath(ApplicationConstants.HIGH_TO_LOW_SORT_XPATH)).click();
	}

	@When("Pick 2nd and 4th item and add it to cart")
	public void pick_2nd_and_4th_item_and_add_it_to_cart() throws InterruptedException {
		Thread.sleep(5000);
		WebElement secondResultItem = driver.findElement(By.xpath(ApplicationConstants.SECOND_RESULT_XPATH));
		addToCart(secondResultItem);
		
		WebElement fourthResultItem = driver.findElement(By.xpath(ApplicationConstants.FOURTH_RESULT_XPATH));
		addToCart(fourthResultItem);
	}

	private void addToCart(WebElement resultItem) throws InterruptedException {
		String parentWindowHandle = driver.getWindowHandle();
		
		resultItem.click();
		
		Set<String> childTabs = driver.getWindowHandles();
		Iterator<String> tabsIterator = childTabs.iterator();
		while(tabsIterator.hasNext()) {
			String childTab = tabsIterator.next();
			if(!childTab.equals(parentWindowHandle)) {
				driver.switchTo().window(childTab);
			}
		}
		driver.findElement(By.xpath(ApplicationConstants.ADD_TO_CART_BUTTON_XPATH)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(ApplicationConstants.CLOSE_ADD_TO_CART_POPUP_XPATH)).click();
		driver.close();
		driver.switchTo().window(parentWindowHandle);
	}

	@When("navigate to carts section")
	public void navigate_to_carts_section() {
	    driver.navigate().to(ApplicationConstants.AMAZON_CART_URL);
	}

	@Then("I have 2 items in the cart")
	public void i_have_items_in_the_cart() {
	    String itemsCount = driver.findElement(By.xpath(ApplicationConstants.TOTAL_ITEMS_IN_CART_XPATH)).getText();
	    System.out.println("The cart has "+itemsCount.substring(10, itemsCount.length()-2));
	}

	@Then("Print the total cart value")
	public void print_the_total_cart_value() {
	    String totalValue = driver.findElement(By.xpath(ApplicationConstants.TOTAL_CART_VALUE_XPATH)).getText();
	    System.out.println("Total cart value is "+totalValue);
	}
}
