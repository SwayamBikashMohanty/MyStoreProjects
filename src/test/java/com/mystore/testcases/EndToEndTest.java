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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author swayam
 *
 */
public class EndToEndTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummary;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@Test
	public void endToEndTest() throws Exception {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckout();
		loginPage = orderPage.clickOnCheckOut();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage = shippingPage.clickOnProceedToCheckOut();
		orderSummary = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummary.clickOnConfirmOrderBtn();
		String actualMessage = orderConfirmationPage.validateConfirmMessage();
		String expectedMessage = "Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
