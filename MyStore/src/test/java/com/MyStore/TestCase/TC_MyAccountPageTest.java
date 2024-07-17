package com.MyStore.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyStore.PageObject.IndexPage;
import com.MyStore.PageObject.MyAccount;
import com.MyStore.PageObject.MyAccountCreation;
import com.MyStore.PageObject.RegisteredUseraAccount;

public class TC_MyAccountPageTest extends BaseClass {
	
	@Test(enabled = false)
	public void verifyRegistrationAndLogin() throws InterruptedException {
		
		//driver.get(url);
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		
		MyAccount ma = new MyAccount(driver);
		ma.enterCreateEmailAddress("Ayush123@gmail.com");
		ma.clickSubmitCreate();
		
		MyAccountCreation accCreation = new MyAccountCreation(driver);
		accCreation.getTitle();
		accCreation.firstName("Ayush");
		accCreation.lastName("Srivastava");
		accCreation.password("Ayush1234");
		accCreation.selectDate();
		accCreation.clickOnRegister();
	}
	
	@Test
	public void sigInLogin() throws IOException {
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		
		MyAccount ma = new MyAccount(driver);
		ma.signIn("Ayush123@gmail.com");
		ma.signInPassword("Ayush1234");
		ma.enterSignIn();
		
		RegisteredUseraAccount user = new RegisteredUseraAccount(driver);
		String userName = user.accountName();
		System.out.println(userName);
		if(userName.equals("Ayush Srivastava1")) {
			System.out.println("Verify username - PASSED");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Verify username - FAILED");
			Assert.assertTrue(false);
			captureScreenshot(driver,"sigInLogin");
			
		}
		
	}

}
