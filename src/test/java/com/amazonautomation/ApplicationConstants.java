package com.amazonautomation;

public class ApplicationConstants {

	public static final String AMAZON_HOMEPAGE = "https://www.amazon.in/";
	public static final String ITEM_TO_SEARCH = "boat headphones";
	public static final String SEARCH_RESULT_PAGE_URL = "https://www.amazon.in/s?k=boat+headphones";
	public static final String AMAZON_CART_URL = "https://www.amazon.in/gp/cart/view.html";
	

	
	//XPaths
	public static final String SEARCH_BOX_XPATH = "//input[@id = 'twotabsearchtextbox']";
	public static final String SEARCH_ICON_XPATH = "//input[@id = 'nav-search-submit-button']";
	public static final String SEARCH_RESULT_TEXT_XPATH = "//div[@class = 'a-section a-spacing-small a-spacing-top-small']";
	public static final String LOW_PRICE_VAL_XPATH = "//input[@id='low-price']";
	public static final String HIGH_PRICE_VAL_XPATH = "//input[@id='high-price']";
	public static final String PRICE_FILTER_GO_BUTTON_XPATH = "//span[@id='a-autoid-1']";
	public static final String SORT_BY_BUTTON_XPATH = "//select[@id='s-result-sort-select']";
	public static final String HIGH_TO_LOW_SORT_XPATH = "//div[@id='a-popover-2']/div/div/ul/li[3]";
	public static final String ADD_TO_CART_BUTTON_XPATH = "//input[@id='add-to-cart-button']";
	public static final String CLOSE_ADD_TO_CART_POPUP_XPATH = "//a[@id='attach-close_sideSheet-link']";
	public static final String TOTAL_ITEMS_IN_CART_XPATH = "//span[@id='sc-subtotal-label-buybox']";
	public static final String TOTAL_CART_VALUE_XPATH = "//span[@id='sc-subtotal-amount-buybox']";//span/span";
	public static final String SECOND_RESULT_XPATH = "//div[@data-index='3']//img";
	public static final String FOURTH_RESULT_XPATH = "//div[@data-index='5']//img";

}
