package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	WebDriver ldriver;
	
	public MyAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement createEmailId;
	
	@FindBy(id = "SubmitCreate")
	WebElement submitCreate;
	
	@FindBy(css = "#email")
	WebElement signInEmail;
	
	@FindBy(css = "#passwd")
	WebElement signInPass;
	
	@FindBy(css = "#SubmitLogin")
	WebElement signIn;
	
	public void enterCreateEmailAddress(String email) {
		createEmailId.sendKeys(email);
	}
	
	public void clickSubmitCreate() {
		submitCreate.click();
	}
	
	public void signIn(String signEmail) {
		signInEmail.sendKeys(signEmail);
	}
	
	public void signInPassword(String signPass) {
		signInPass.sendKeys(signPass);
	}
	
	public void enterSignIn() {
		signIn.click();
	}
	

}
