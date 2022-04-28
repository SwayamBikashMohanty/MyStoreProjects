/**
 * 
 */
package com.mystore.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author swayam
 *
 */
public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	Action act = new Action();

	@Parameters({ "browser" })
	@BeforeMethod(groups = { "smoke", "sanity", "Regression" })
	public void setup(@Optional("chrome") String browser) {
		launchApp(browser);
	}

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "smoke", "sanity" })
	public void loginTest(String uname, String pwd) throws IOException {
		Log.startTestCase("loginTest");
		log.info("Test Case started");
		indexPage = new IndexPage();
		log.info("user is going to click on signIn");
		loginPage = indexPage.clickOnSignIn();
		log.info("Enter username and password");
		// homePage=loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		homePage = loginPage.login(uname, pwd);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		log.info("Verifying if user is able to login");

		// Assert.assertEquals(actualURL, expectedURL);//Here through Assert not able to
		// take fail screenshot so implemented if--else
		//act.screenShot(driver, "loginTest");

		if (!actualURL.equals(expectedURL)) {
			act.screenShot(driver, "loginTest");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
		Log.endTestCase("loginTest");

	}

	// @AfterMethod(groups = { "smoke", "sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

}
