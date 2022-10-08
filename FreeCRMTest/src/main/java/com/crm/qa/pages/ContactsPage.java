package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailAddress;
	
	
	@FindBy(xpath="//input[@name='position']")
	WebElement position;
	
	@FindBy(xpath="//div[@class='item']/button[2]")
	WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String fName, String lName, String email, String postn) throws InterruptedException {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emailAddress.sendKeys(email);
		position.sendKeys(postn);
		saveButton.click();
		Thread.sleep(10000);
	
		
		
	}
	
}
