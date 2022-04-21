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
public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@Test
	public void wishListTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	@Test
	public void OrderHistoryandDetailsTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
