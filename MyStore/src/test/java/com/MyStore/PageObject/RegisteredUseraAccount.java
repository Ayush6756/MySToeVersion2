package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUseraAccount {
	
	WebDriver ldriver;
	
	public RegisteredUseraAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = ".account")
	WebElement accountName;
	
	public String accountName() {
		String text = accountName.getText();
		return text;
	}
	

}
