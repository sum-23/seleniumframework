package com.repository.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver = null;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "(//a[text()='Login'])[1]")
	private WebElement loginOption;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerOption;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount() {

		myAccount.click();

	}

	public void clickOnLoginOption() {

		loginOption.click();

	}

	public void clickOnRegisterOption() {

		registerOption.click();

	}

	public void performSearch(String searchData) {

		searchField.sendKeys(searchData);
		searchButton.click();

	}

}
