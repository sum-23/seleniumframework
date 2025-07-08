package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.repository.selenium.HomePage;
import com.repository.selenium.SearchPage;
import com.utility.selenium.ReadExcel;
import com.utility.selenium.StartBrowser;

public class Search extends StartBrowser {

	WebDriver driver = null;
	HomePage hp = null;
	SearchPage sp = null;

	@BeforeMethod
	public void setup() {

		config();
		driver = startBrowser(driver, config.getProperty("browser"));
		hp = new HomePage(driver);
		sp = new SearchPage(driver);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test(priority = 1, groups = "search", dataProvider = "searchData")
	public void verifySearchWithValidData(String searchData, String expectedResult) {

		hp.performSearch(searchData);
		String actualSearchText = sp.getSearchText();
		Boolean isAllSearchDisplay = sp.checkSearchedProducts(searchData);

		Assert.assertEquals(actualSearchText, expectedResult);
		Assert.assertTrue(isAllSearchDisplay);

	}

	@DataProvider(name = "searchData")
	public Object[][] getSearchData() {

		config();
		String file = "./Files/search_data.xlsx";
		return ReadExcel.readExcel(file, testData.getProperty("sheetname"));

	}

}
