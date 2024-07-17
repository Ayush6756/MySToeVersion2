package com.MyStore.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountCreation {

	WebDriver ldriver;

	public MyAccountCreation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = "#uniform-id_gender1")
	WebElement title;

	@FindBy(css = "#customer_firstname")
	WebElement firstName;

	@FindBy(css = "#customer_lastname")
	WebElement lastName;

	@FindBy(css = "#passwd")
	WebElement password;

	@FindBy(xpath = "//select[@id='days']/option[@value='7']")
	WebElement days;

	@FindBy(xpath = "//select[@id='months']/option[@value='5']")
	WebElement months;

	@FindBy(xpath = "//select[@id='years']/option[@value='1998']")
	WebElement years;

	@FindBy(css = "#submitAccount")
	WebElement register;

	public void getTitle() {
		title.click();
	}

	public void firstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void lastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void password(String passWord) {
		password.sendKeys(passWord);
	}

	public void selectDate() {
		days.click();
		months.click();
		years.click();

	}
	
	public void clickOnRegister() {
		register.click();
	}

}
