/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author swayam
 *
 */
public class AccountCreationTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@Test
	public void verifyCreateAccountPageTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount("dvj@gmail.com");
		boolean result=accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
