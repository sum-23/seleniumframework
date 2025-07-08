package com.utility.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {

	WebDriver driver = null;
	protected Properties config = null;
	protected Properties testData = null;

	public void config() {

		config = new Properties();
		testData = new Properties();

		File configFile = new File(
				"C:\\Users\\SumitKumar\\eclipse-workspace\\SeleniumFramework\\Files\\config.properties");
		File testDataFile = new File(
				"C:\\Users\\SumitKumar\\eclipse-workspace\\SeleniumFramework\\Files\\testdata.properties");

		FileInputStream fisConfig = null;
		FileInputStream fisTestData = null;

		try {
			fisConfig = new FileInputStream(configFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			config.load(fisConfig);
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			fisTestData = new FileInputStream(testDataFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			testData.load(fisTestData);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public WebDriver startBrowser(WebDriver driver, String browser) {

		this.driver = driver;

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.LOAD_TIME));
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));

		return driver;

	}

}
