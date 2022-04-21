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
public class OrderSummaryPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;

	public OrderSummaryPage() {
		PageFactory.initElements(driver,this);
	}
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
