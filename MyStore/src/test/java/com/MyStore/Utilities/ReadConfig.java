package com.MyStore.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ReadConfig {

	Properties property;
	String path = "C:\\Users\\Ayush.Srivastava1\\Downloads\\Store-main\\MyStore\\Configuration\\config.properties";

	public ReadConfig() {
		try {
			property = new Properties();
			FileInputStream fil;

			fil = new FileInputStream(path);
			property.load(fil);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// To read the base URL from properties file

	public String getBaseURL() {
		String getValue = property.getProperty("baseURL");
		if (getValue != null) {
			return getValue;
		} else {
			throw new RuntimeException("URL not found");
		}
		// return getValue;

	}

	public String getBrowser() {
		String browser = property.getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser not found");
		}
	}

}
