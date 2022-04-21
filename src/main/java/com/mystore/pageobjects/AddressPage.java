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
public class AddressPage extends BaseClass{

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(driver,this);
	}
	
	public ShippingPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new ShippingPage();
	}
}
