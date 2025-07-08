package com.repository.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver = null;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement telephone;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameValidation;

	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameValidation;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailValidation;

	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneValidation;

	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement passwordValidation;

	@FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
	private WebElement confirmPasswordValidation;

	@FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement privacyPolicyValidation;

	@FindBy(xpath = "//label[@class='radio-inline'][1]/input")
	private WebElement subscribeYes;

	@FindBy(xpath = "//label[@class='radio-inline'][2]/input")
	private WebElement subscribeNo;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//a[text()='login page']")
	private WebElement loginPageLink;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement successMessage;

	public void enterFirstName(String firstName1) {

		firstName.sendKeys(firstName1);

	}

	public void enterLastName(String lastName1) {

		lastName.sendKeys(lastName1);

	}

	public void enterEmail(String email1) {

		email.sendKeys(email1);

	}

	public void enterTelephone(String telephone1) {

		telephone.sendKeys(telephone1);

	}

	public void enterPassword(String password1) {

		password.sendKeys(password1);

	}

	public void enterConfirmPassword(String confirmPassword1) {

		confirmPassword.sendKeys(confirmPassword1);

	}

	public void selectSubscribeYes() {

		subscribeYes.click();

	}

	public void selectSubscribeNo() {

		subscribeNo.click();

	}

	public void selectPrivacyPolicy() {

		privacyPolicy.click();

	}

	public void clickOnContinueButton() {

		continueButton.click();

	}

	public Boolean checkFirstNameValidation() {

		return firstNameValidation.isDisplayed();

	}

	public Boolean checkLastNameValidation() {

		return lastNameValidation.isDisplayed();

	}

	public Boolean checkEmailValidation() {

		return emailValidation.isDisplayed();

	}

	public Boolean checkTelephoneValidation() {

		return telephoneValidation.isDisplayed();

	}

	public Boolean checkPasswordValidation() {

		return passwordValidation.isDisplayed();

	}

	public Boolean checkConfirmPasswordValidation() {

		return confirmPasswordValidation.isDisplayed();

	}

	public Boolean checkPrivacyPolicyValidation() {

		return privacyPolicyValidation.isDisplayed();

	}

	public void clickOnLoginPageLink() {

		loginPageLink.click();

	}

	public Boolean checkSuccessMessage() {

		return successMessage.isDisplayed();

	}

}
