package com.MyStore.TestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.MyStore.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseURL();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
//		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		
		TakesScreenshot screenshot =  ((TakesScreenshot) driver);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+ "//Screenshots//" + testName +".png");
		
		FileUtils.copyFile(src, des);
	}
	
	
	
	

}
