/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author swayam
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@Test
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test
	public void verifyTitle() {
		String expTitle="My Store";
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
