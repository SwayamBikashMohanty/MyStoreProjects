/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author swayam
 *
 */
public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//form//*[@id=\"quantity_wanted\"]")
	WebElement quantity;
	
	@FindBy(xpath="//form//*[@id=\"group_1\"]")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addTocartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver,this);
	}
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}
	public void clickOnAddToCart() {
		Action.click(driver, addToCartBtn);
	}
	public boolean validateAddtocart() {
		Action.fluentWait(driver, addTocartMessage, 10);
		return Action.isDisplayed(driver, addTocartMessage);
	}
	public OrderPage clickOnCheckout() throws Exception {
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
}
