package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcat.crm.objectrepositoryutility.ContactHomePage;
import com.comcat.crm.objectrepositoryutility.ContactInfPage;
import com.comcat.crm.objectrepositoryutility.CreateContactPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.crm.baseUtility.BaseClass;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Throwable {
//read testScript data from excel file
		String lastname = ELib.getDataFromExcel("Contacts", 1, 2) + jLib.getRandomNumber();

//navigate to Cantacts Module
		HomePage hp = new HomePage(driver);
		hp.getContact().click();
		ContactHomePage chp=new ContactHomePage(driver);
		chp.getCraeteContactLnk().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact(lastname);

//verify
		String element = ccp.getHeaderlnk().getText();

		if (element.contains(lastname)) {
			System.out.println(lastname + "Created==PASS");
		} else {
			System.out.println(lastname + " Not Created==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {

		String LastName = ELib.getDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();

		// Click on Contacts from homePage
		HomePage hp = new HomePage(driver);
		hp.getContact().click();

		// Click on create contact plus icon
		ContactHomePage chp = new ContactHomePage(driver);
		chp.getCraeteContactLnk().click();

		// Enter the contact details and save the contact
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastname().sendKeys(LastName);

		// Generating the support date
		String StartDate = jLib.GetSystemDateYYYYDDMM();
		String requiredDate = jLib.getrequiredYYYYDDMM(30);
		ccp.getStartDate().clear();
		ccp.getStartDate().sendKeys(StartDate);
		ccp.getEndDate().clear();
		ccp.getEndDate().sendKeys(requiredDate);

		// save the contact created
		ccp.getSavelnk().click();

		// Verification
		ContactInfPage cip = new ContactInfPage(driver);

		// Verify header info w.r.t contact name
		String headerName = cip.getContactheaderlnk().getText();
		if (headerName.contains(LastName)) {
			System.out.println("Contact detail is driven == PASS");
		} else {
			System.out.println("Contact detail is not driven == FAIL");
		}

	}

}
