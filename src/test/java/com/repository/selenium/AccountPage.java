package com.repository.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver = null;

	public AccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountText;

	public Boolean checkVisibilityOfEditAccountText() {

		return editAccountText.isDisplayed();

	}

}
