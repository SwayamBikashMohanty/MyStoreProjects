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

import com.aventstack.extentreports.model.ScreenCapture;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author swayam
 *
 */
public class AccountCreationTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	Action act = new Action();

	@Parameters("browser")
	@BeforeMethod(groups = { "smoke", "sanity", "Regression" })
	public void setup(@Optional("chrome") String browser) {
		launchApp(browser);
	}

	@Test(groups = "sanity")
	public void verifyCreateAccountPageTest() throws IOException {

		Log.startTestCase("verifyCreateAccountPageTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("dvj@gmail.com");
		boolean result = accountCreationPage.validateAccountCreatePage();
		// Assert.assertTrue(result);
		if (!result == true) {
			act.screenShot(driver, "verifyCreateAccountPageTest");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(result);
		}
		Log.endTestCase("verifyCreateAccountPageTest");

	}

	@AfterMethod(groups = { "smoke", "sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

}
