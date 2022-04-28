/**
 * 
 */
package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author swayam
 *
 */
public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	Action act = new Action();

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke", "sanity", "Regression" })
	public void setup(@Optional("chrome") String browser) {
		launchApp(browser);
	}

	@Test(groups = "smoke")
	public void wishListTest() {
		Log.endTestCase("wishListTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		//Assert.assertTrue(result);
		if (!result == true) {
			act.screenShot(driver, "wishListTest");
		}
		Log.endTestCase("wishListTest");
	}

	@Test(groups = "smoke")
	public void OrderHistoryandDetailsTest() throws IOException {
		Log.endTestCase("OrderHistoryandDetailsTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		// Assert.assertTrue(result);
		if (!result == true) {
			act.screenShot(driver, "OrderHistoryandDetailsTest");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(result);
		}
		Log.endTestCase("OrderHistoryandDetailsTest");
	}

	@AfterMethod(groups = { "smoke", "sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}
}
