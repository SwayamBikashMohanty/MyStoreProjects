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

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author swayam
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke", "sanity", "Regression" })
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);
	}

	@Test(groups = "smoke")
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test(groups = "smoke")
	public void verifyTitle() {
		String expTitle = "My Store";
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	@AfterMethod(groups = { "smoke", "sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}
}
