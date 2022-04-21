/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author swayam
 *
 */
public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@Test
	public void verifyTotalPrice() throws Exception {
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
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
