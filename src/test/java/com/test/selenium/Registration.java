package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.repository.selenium.HomePage;
import com.repository.selenium.RegistrationPage;
import com.utility.selenium.StartBrowser;
import com.utility.selenium.Utility;

public class Registration extends StartBrowser {

	WebDriver driver = null;
	HomePage hp = null;
	RegistrationPage rp = null;

	@BeforeMethod
	public void setUp() {

		config();
		driver = startBrowser(driver, config.getProperty("browser"));
		rp = new RegistrationPage(driver);
		hp = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test(priority = 1)
	public void verifyRegistrationByFillingAllDetails() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnRegisterOption();

			rp.enterFirstName(testData.getProperty("firstname"));
			rp.enterLastName(testData.getProperty("lastname"));
			rp.enterEmail(Utility.generateTimeStamp() + "@gmail.com");
			rp.enterTelephone(testData.getProperty("telephone"));
			rp.enterPassword(testData.getProperty("password"));
			rp.enterConfirmPassword(testData.getProperty("confirmpassword"));
			rp.selectPrivacyPolicy();
			rp.clickOnContinueButton();

			Assert.assertTrue(rp.checkSuccessMessage(), "Success message is not displayed");

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 2)
	public void verifyRegistrationByFillingAllDetailsWithSubscriptionYes() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnRegisterOption();

			rp.enterFirstName(testData.getProperty("firstname"));
			rp.enterLastName(testData.getProperty("lastname"));
			rp.enterEmail(Utility.generateTimeStamp() + "@gmail.com");
			rp.enterTelephone(testData.getProperty("telephone"));
			rp.enterPassword(testData.getProperty("password"));
			rp.enterConfirmPassword(testData.getProperty("confirmpassword"));
			rp.selectSubscribeYes();
			rp.selectPrivacyPolicy();
			rp.clickOnContinueButton();

			Assert.assertTrue(rp.checkSuccessMessage(), "Success message is not displayed");

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 3)
	public void verifyRegistrationWithoutSelectingPrivacyPolicy() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnRegisterOption();

			rp.enterFirstName(testData.getProperty("firstname"));
			rp.enterLastName(testData.getProperty("lastname"));
			rp.enterEmail(Utility.generateTimeStamp() + "@gmail.com");
			rp.enterTelephone(testData.getProperty("telephone"));
			rp.enterPassword(testData.getProperty("password"));
			rp.enterConfirmPassword(testData.getProperty("confirmpassword"));

			rp.clickOnContinueButton();

			Assert.assertTrue(rp.checkPrivacyPolicyValidation(), "Privacy policy validation is not displayed");

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 4)
	public void verifyRegistrationWithoutFillingData() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnRegisterOption();

			rp.clickOnContinueButton();

			Assert.assertTrue(rp.checkFirstNameValidation() && rp.checkLastNameValidation() && rp.checkEmailValidation()
					&& rp.checkTelephoneValidation() && rp.checkPasswordValidation()
					&& rp.checkPrivacyPolicyValidation(), "Validation is missing or incorrect");

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

	@Test(priority = 5)
	public void verifyRegistrationByFillingDifferentPasswords() {

		try {

			hp.clickOnMyAccount();
			hp.clickOnRegisterOption();

			rp.enterFirstName(testData.getProperty("firstname"));
			rp.enterLastName(testData.getProperty("lastname"));
			rp.enterEmail(Utility.generateTimeStamp() + "@gmail.com");
			rp.enterTelephone(testData.getProperty("telephone"));
			rp.enterPassword(testData.getProperty("password"));
			rp.enterConfirmPassword(testData.getProperty("incorrectpassword"));
			rp.selectPrivacyPolicy();
			rp.clickOnContinueButton();

			Assert.assertFalse(rp.checkConfirmPasswordValidation(), "Validation is missing");

		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception occurred: " + e.getMessage());

		}

	}

}
