package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Ajith Thomas')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//div[@id='main-nav']/div[3]/button[1]")
	WebElement newContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyuserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
	contactsLink.click();
	return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
	dealsLink.click();
	return new DealsPage();
	
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	


}
