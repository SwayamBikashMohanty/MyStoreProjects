/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author swayam
 *
 */
public class LoginPage extends BaseClass{

	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id = "SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public HomePage login(String uname,String pwd) {
		Action.type(username,uname);
		Action.type(password, pwd);
		Action.click(driver, signInBtn);
		return new HomePage();
	}
	public AddressPage login1(String uname,String pwd) {
		Action.type(username,uname);
		Action.type(password, pwd);
		Action.click(driver, signInBtn);
		return new AddressPage();
	}
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}
}

