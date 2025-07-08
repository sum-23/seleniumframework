package com.repository.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver = null;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;

	public WebElement locateEmail() {

		return emailField;
	}

	public WebElement locatePassword() {

		return passwordField;
	}

	public WebElement locateLoginButton() {

		return loginButton;

	}

	public String readWarningMessage() {

		return warningMessage.getText();

	}

	public void performLogin(String email, String password) {

		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();

	}

}
