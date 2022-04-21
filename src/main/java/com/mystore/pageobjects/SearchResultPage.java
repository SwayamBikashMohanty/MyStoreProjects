/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author swayam
 *
 */
public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='product-container']//a[@class='product-name']")
	WebElement productText;
	
	@FindBy(xpath="//*[@id=\"bigpic\"]")
	WebElement productImg;
	
	public SearchResultPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(driver, productText);
	}
	public AddToCartPage clickOnProduct() {
		Action.click(driver, productText);
		return new AddToCartPage();
	}
}
