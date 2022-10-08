package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String title = homePage.verifyHomepageTitle();
		Assert.assertEquals(title,"Cogmento CRM", "Homepage title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyuserNameLabel());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage =homePage.clickOnContactsLink();
	}
	

	@Test(priority=4)
	public void verifyDealsLinkTest() {
		dealsPage =homePage.clickOnDealsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
