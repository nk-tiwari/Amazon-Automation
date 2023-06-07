package com.amazonautomation.pom.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome_Elements {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	public WebElement amazonHomeSearchBox;
	
	@FindBy(xpath = "//input[@id = 'nav-search-submit-button']")
	public WebElement amazonHomeSearchBtn;
	
	@FindBy(xpath = "//div[@class = 'a-section a-spacing-small a-spacing-top-small']")
	public WebElement searchResultTxtxPath;
	
	public AmazonHome_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
