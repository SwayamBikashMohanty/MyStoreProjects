/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author swayam
 *
 */
public class LoginPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@Test
	public void loginTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homePage.getCurrURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
