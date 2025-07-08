package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.repository.selenium.AccountPage;
import com.repository.selenium.HomePage;
import com.repository.selenium.LoginPage;
import com.utility.selenium.StartBrowser;

public class Login extends StartBrowser {

	WebDriver driver = null;
	LoginPage lp = null;
	HomePage hp = null;
	AccountPage ap = null;
	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	@BeforeMethod
	public void setUp() {

		config();
		driver = startBrowser(driver, config.getProperty("browser"));
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		ap = new AccountPage(driver);

		logger.info("Web browser is initialize");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

		logger.info("Web browser is closed");
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {

		try {

			hp.clickOnMyAccount();
			logger.info("Click on my account");
			hp.clickOnLoginOption();
			logger.info("Click on login option");
			lp.performLogin(testData.getProperty("validemail"), testData.getProperty("validpassword"));
			logger.info("Login is performed");
			Assert.assertTrue(ap.checkVisibilityOfEditAccountText());
			logger.info("Assertion executed");

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());
			logger.info("Test case is failed due to assertion");

		}

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnLoginOption();
			lp.performLogin(testData.getProperty("invalidemail"), testData.getProperty("invalidpassword"));
			String actualMessage = lp.readWarningMessage();

			Assert.assertEquals(actualMessage, testData.getProperty("warning"));

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 3)
	public void verifyLoginWithValidEmailInvalidPassword() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnLoginOption();
			lp.performLogin(testData.getProperty("validemail"), testData.getProperty("invalidpassword"));
			String actualMessage = lp.readWarningMessage();

			Assert.assertEquals(actualMessage, testData.getProperty("warning"));

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailValidPassword() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnLoginOption();
			lp.performLogin(testData.getProperty("invalidemail"), testData.getProperty("validpassword"));
			String actualMessage = lp.readWarningMessage();

			Assert.assertEquals(actualMessage, testData.getProperty("warning"));

		}

		catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 5)
	public void loginWithoutCredentials() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnLoginOption();
			lp.locateLoginButton().click();
			String actualMessage = lp.readWarningMessage();

			Assert.assertEquals(actualMessage, testData.getProperty("warning"));

		}

		catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}
	}

	@Test(priority = 6)
	public void loginWithOnlyEmail() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnLoginOption();
			lp.locateEmail().sendKeys(testData.getProperty("validemail"));
			lp.locateLoginButton().click();
			String actualMessage = lp.readWarningMessage();

			Assert.assertEquals(actualMessage, testData.getProperty("warning"));

		}

		catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}
	}

	@Test(priority = 7)
	public void loginWithOnlyPassword() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnLoginOption();
			lp.locatePassword().sendKeys(testData.getProperty("validpassword"));
			lp.locateLoginButton().click();
			String actualMessage = lp.readWarningMessage();

			Assert.assertEquals(actualMessage, testData.getProperty("warning"));

		}

		catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}
	}

}
