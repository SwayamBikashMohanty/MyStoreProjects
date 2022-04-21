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
public class OrderConfirmationPage extends BaseClass{
	@FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmMessag;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}

}
