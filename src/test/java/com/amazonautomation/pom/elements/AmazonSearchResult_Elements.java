package com.amazonautomation.pom.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchResult_Elements {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='low-price']")
	public WebElement lowPriceVal;
	
	@FindBy(xpath = "//input[@id='high-price']")
	public WebElement highPriceVal;
	
	@FindBy(xpath = "//span[@id='a-autoid-1']")
	public WebElement priceFilterGoBtn;
	
	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	public WebElement sortByBtn;
	
	@FindBy(xpath = "//div[@id='a-popover-2']/div/div/ul/li[3]")
	public WebElement sortHighToLow;
	
	@FindBy(xpath = "//div[@data-index='3']//img")
	public WebElement secondResult;
	
	@FindBy(xpath = "//div[@data-index='5']//img")
	public WebElement fourthResult;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
	public WebElement closePopUpAddToCart;
	
	@FindBy(xpath = "//span[@id='sc-subtotal-label-buybox']")
	public WebElement itemCountInCart;
	
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']")
	public WebElement cartValue;
	
	public AmazonSearchResult_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
