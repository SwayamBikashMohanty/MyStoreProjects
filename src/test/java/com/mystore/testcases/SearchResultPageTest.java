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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author swayam
 *
 */
public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@Test
	public void productAvailibilityTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
