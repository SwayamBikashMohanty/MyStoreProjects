/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author swayam
 *
 */
public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	Action act = new Action();

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke", "sanity", "Regression" })
	public void setup(@Optional("chrome") String browser) {
		launchApp(browser);
	}

	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Exception {
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckout();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice * 2) + 2;
		//Assert.assertEquals(totalPrice, totalExpectedPrice);

		if (!totalPrice.equals(totalExpectedPrice)) {
			act.screenShot(driver, "verifyTotalPrice");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
		Log.startTestCase("verifyTotalPrice");
	}

	@AfterMethod(groups = { "smoke", "sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

}
