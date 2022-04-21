package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signinbtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement mystorelogo;

	@FindBy(id = "search_query_top")
	WebElement searchproductbox;

	@FindBy(name = "submit_search")
	WebElement searchbtn;

	// initialize all elements
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() {
		Action.click(driver, signinbtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(driver, mystorelogo);
	}

	public String getMyStoreTitle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchproductbox,productName);
		Action.click(driver, searchbtn);
		return new SearchResultPage();
	}
    
}
