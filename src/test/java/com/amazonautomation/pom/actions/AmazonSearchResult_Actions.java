package com.amazonautomation.pom.actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazonautomation.pom.elements.AmazonSearchResult_Elements;
import com.amazonautomation.steps.TestConfiguration;

public class AmazonSearchResult_Actions {

	private WebDriver driver;
	private AmazonSearchResult_Elements searchResultElements;

	public AmazonSearchResult_Actions(TestConfiguration config) {
		this.driver = config.getWebDriver();
		searchResultElements = new AmazonSearchResult_Elements(driver);
	}

	public void filterByMinMaxValue(String lowVal, String highVal) {
		searchResultElements.lowPriceVal.sendKeys(lowVal);
		searchResultElements.highPriceVal.sendKeys(highVal);
		searchResultElements.priceFilterGoBtn.click();
	}

	public void sortItemsAsPerKey(String key) {
		Select sortBy = new Select(searchResultElements.sortByBtn);
		sortBy.selectByVisibleText(key);
		searchResultElements.sortHighToLow.click();
	}

	public void add2ndAnd4thResultToCart() throws InterruptedException {
		addToCart(searchResultElements.secondResult);
		addToCart(searchResultElements.fourthResult);

	}

	public String getNoOfItemsInCart() {
		String itemsCount = searchResultElements.itemCountInCart.getText();
	    return itemsCount.substring(10, itemsCount.length()-2);
	}
	
	public String getTotalValueOfCart() {
		return searchResultElements.cartValue.getText();
	}

	private void addToCart(WebElement resultItem) throws InterruptedException {
		String parentWindowHandle = driver.getWindowHandle();
		resultItem.click();

		Set<String> childTabs = driver.getWindowHandles();
		Iterator<String> tabsIterator = childTabs.iterator();
		while (tabsIterator.hasNext()) {
			String childTab = tabsIterator.next();
			if (!childTab.equals(parentWindowHandle)) {
				driver.switchTo().window(childTab);
			}
		}
		searchResultElements.addToCartBtn.click();
		Thread.sleep(5000);
		searchResultElements.closePopUpAddToCart.click();
		driver.close();
		driver.switchTo().window(parentWindowHandle);
	}
}
