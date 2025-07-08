package com.repository.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver = null;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']/div/div)[2]/div/h4")
	private List<WebElement> productNames;

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement searchText;

	public List<WebElement> getProductsData() {

		return productNames;

	}

	public Boolean checkSearchedProducts(String productName) {

		for (WebElement product : productNames) {

			if (!product.getText().equalsIgnoreCase(productName)) {

				return false;

			}

		}

		return true;

	}

	public String getSearchText() {

		return searchText.getText();

	}

}
