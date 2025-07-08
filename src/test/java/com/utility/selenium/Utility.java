package com.utility.selenium;

import java.util.Date;

public class Utility {

	public static final int WAIT_TIME = 10;
	public static final int LOAD_TIME = 10;

	public static String generateTimeStamp() {

		Date date = new Date();
		return date.toString().replace(":", "_").replace(" ", "_");

	}

}
