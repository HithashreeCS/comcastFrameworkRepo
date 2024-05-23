package com.comcast.crm.contactTest1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listenerutility.ListenerImplementionClass;
import com.comcat.crm.objectrepositoryutility.ContactHomePage;
import com.comcat.crm.objectrepositoryutility.ContactInfPage;
import com.comcat.crm.objectrepositoryutility.CreateContactPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.crm.baseUtility.BaseClass;
/**
 * @author hitha
 */
//@Listeners(com.comcast.crm.listenerutility.ListenerImplementionClass.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Throwable {
		
		ListenerImplementionClass.test.log(Status.INFO,"read data from Excel");
//read testScript data from excel file
		String lastname = ELib.getDataFromExcel("Contacts", 1, 2) + jLib.getRandomNumber();

//navigate to Cantacts Module
		ListenerImplementionClass.test.log(Status.INFO,"navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContact().click();
		ListenerImplementionClass.test.log(Status.INFO,"navigate to create contact page");
		
		ContactHomePage chp = new ContactHomePage(driver);
		chp.getCraeteContactLnk().click();
		ListenerImplementionClass.test.log(Status.INFO,"create new contact");
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact(lastname);
		
		ListenerImplementionClass.test.log(Status.INFO,lastname+"==>Create a new contact");
		ContactInfPage cip = new ContactInfPage(driver);
		String actHeader = cip.getContactheaderlnk().getText();
		boolean status = actHeader.contains(lastname);
		Assert.assertEquals(status, true);

		String actLastName = cip.getCantactLastnamelnk().getText();
//Assert.assertEquals(actLastName,lastname);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actLastName, lastname);
		sa.assertAll();
//boolean status=actHeader.contains(lastname);
		// Verify header info w.r.t contact name
//		String headerName = cip.getContactInflnk().getText();
//		if (headerName.contains(lastname)) {
//			System.out.println(lastname+"Header is Verified == PASS");
//		} else {
//			System.out.println(lastname+"Header is Verified == Fail");
//		}
//		String element = ccp.getHeaderlnk().getText();
//
//		if (element.contains(lastname)) {
//			System.out.println(lastname + "information is Verified==PASS");
//		} else {
//			System.out.println(lastname + "information is Verified==Fail");
//		}

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
		String startdate = jLib.GetSystemDateYYYYDDMM();
		String requiredDate = jLib.getrequiredYYYYDDMM(30);
		ccp.getStartDate().clear();
		ccp.getStartDate().sendKeys(startdate);
		ccp.getEndDate().clear();
		ccp.getEndDate().sendKeys(requiredDate);

		// save the contact created
		ccp.getSavelnk().click();

		// Verification
		ContactInfPage cip = new ContactInfPage(driver);

		String actHeader = cip.getContactheaderlnk().getText();
		boolean status = actHeader.contains(LastName);
		Assert.assertEquals(status, true);

//expected
		String actLastName = cip.getCantactLastnamelnk().getText();
		// Assert.assertEquals(actLastName,LastName);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(LastName, actLastName);
		sa.assertAll();

		String verifystartdate = cip.getStartdatelnk().getText();
		sa.assertEquals(verifystartdate, startdate);

		String verifyenddate = cip.getEnddatelnk().getText();
		sa.assertEquals(verifyenddate, requiredDate);
//		// Verify header info w.r.t contact name
//		String headerName = cip.getContactheaderlnk().getText();
//		if (headerName.contains(LastName)) {
//			System.out.println("Contact detail is driven == PASS");
//		} else {
//			System.out.println("Contact detail is not driven == FAIL");
//		}

		System.out.println("paas");
	}

}
