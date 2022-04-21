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
public class ShippingPage extends BaseClass {
	
	@FindBy(id="cgv")
	WebElement terms;
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver,this);
	}
	public void checkTheTerms() {
		Action.click(driver, terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		Action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}
}
