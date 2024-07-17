package com.MyStore.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//
public class ExtentReportClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureExtentReport() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String reportName = "My Report name" +timeStamp +".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" +reportName);
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Machine", "TestPC1");
		reports.setSystemInfo("Windows", "10");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("Username", "Ayush");
		
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);;
	}
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
		configureExtentReport();
		System.out.println("On Start method invoked...");
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On Finish method invoked...");
		reports.flush();
	}
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The Test failed on " +result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of Failed Test case is "+ result.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+ "//Screenshots//" +result.getName() + ".png";
		File screnshotFile = new File(screenshotPath);
		if(screnshotFile.exists()) {
			test.fail("Failed test case screnshot is below "+ test.addScreenCaptureFromPath(screenshotPath));
		}
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the Test method started"+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The Test passed on test case name"+result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the test case Passed "+result.getName(), ExtentColor.GREEN));
	}

	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedWithTimeout(result);
	}

}
