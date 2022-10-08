package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName ="contacts";
	
	public ContactsPageTest() {
		
		super();
	}
	
	
	@BeforeMethod
		public void setUp() {
			
		initialization();
		testUtil=new TestUtil();
		contactsPage= new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
		}
	
	@DataProvider 
	public Object[][] getCRMTestData() throws InvalidFormatException {
		
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority =1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname, String email, String position) throws InterruptedException {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("shajahan", "mutalib", "shajahan@yahoo.com", "Technial Engineer");
		contactsPage.createNewContact(firstname, lastname, email, position);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
