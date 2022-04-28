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
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

/**
 * @author swayam
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	Action act = new Action();

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke", "sanity", "Regression" })
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);
	}

	@Test(groups = "smoke")
	public void verifyLogo() throws IOException {
		Log.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		// Assert.assertTrue(result);
		if (!result == true) {
			act.screenShot(driver, "verifyLogo");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(result);
		}
		Log.startTestCase("verifyLogo");
	}

	@Test(groups = "smoke")
	public void verifyTitle() throws IOException {
		Log.startTestCase("verifyTitle");
		String expTitle = "My Store";
		String actTitle = indexPage.getMyStoreTitle();
		// Assert.assertEquals(actTitle, expTitle);
		// act.screenShot(driver, "verifyTitle");
		if (!actTitle.equals(expTitle)) {
			act.screenShot(driver, "verifyTitle");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
		Log.startTestCase("verifyTitle");

	}

	@AfterMethod(groups = { "smoke", "sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}
}
