/**
 * 
 */
package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author swayam
 *
 */
public class AddToCartTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@Test
	public void addToCartTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddtocart();
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
