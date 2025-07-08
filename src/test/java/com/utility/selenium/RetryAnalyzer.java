package com.utility.selenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private static final int MAX_RETRY_LIMIT = 3;

	@Override
	public boolean retry(ITestResult result) {

		count++;
		if (count < MAX_RETRY_LIMIT) {

			System.out.println("Retrying test " + result.getTestName() + " for the count " + count + " time");
			return true;

		}

		return false;
	}

}
