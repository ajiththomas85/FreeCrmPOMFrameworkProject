package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory: OR (Objects Repository)
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath= "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	//@FindBy(xpath= "//img[contains(@class,'img-responsive')]")
	//WebElement crmLogo;
	
	// Initializing the Page objects
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	//public boolean validateCRMImage() {
		//return crmLogo.isDisplayed();
	//}
	
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
