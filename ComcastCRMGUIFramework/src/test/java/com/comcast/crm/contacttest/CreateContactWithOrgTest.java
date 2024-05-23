package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcat.crm.objectrepositoryutility.ContactHomePage;
import com.comcat.crm.objectrepositoryutility.CreateContactPage;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcat.crm.objectrepositoryutility.OrganizationPage;
import com.crm.baseUtility.BaseClass;

public class CreateContactWithOrgTest extends BaseClass {
	@Test

	public void createContactWithOrgTest() throws Throwable {

		String orglastname = ELib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();

		String lastname = ELib.getDataFromExcel("Contacts", 1, 2) + jLib.getRandomNumber();

//Step 2: Navigate to Organization Module

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationPage op = new OrganizationPage(driver);

		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);

		cop.createOrg(orglastname);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actOrg = oip.getHeaderMsg().getText();

		if (actOrg.contains(orglastname))

		{

			System.out.println("pass");

		}

		else {

			System.out.println("fail");

		}

		// HomePage hp1 = new HomePage(driver);

//Step 3: Click on "Create Organization" Button

		hp.getContact().click();

		ContactHomePage cp = new ContactHomePage(driver);
		cp.getCraeteContactLnk().click();

//Step 4: Enter all the details and create an organization

		CreateContactPage ccp = new CreateContactPage(driver);

		ccp.getLastname().sendKeys(lastname);
		ccp.getOrglookup().click();
		 WLib.swithToTabOnUrl(driver, "module=Accounts");
		//WLib.windowHandle(driver);
		op.getSearchlnk().sendKeys(orglastname);
		op.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='" + orglastname + "']")).click();// dynamic Xpath
		 WLib.swithToTabOnUrl(driver, "contacts&action");
		//WLib.windowHandle(driver);
		ccp.getSavelnk().click();

//verify Header msg Excepted Result

//		ContactsInfoPage cip1 = new ContactsInfoPage(driver);
//
//		headerInfo = cip1.getContHeaderInfo().getText();
//
//		if (headerInfo.contains(contactLastName)) {
//
//			System.out.println(contactLastName + "is Created==PASS");
//
//		} else {
//
//			System.out.println(contactLastName + "is not Created==FAIL");
//
//		}
//
////verify Header orgName info
//
//		String actorgName = cip.getOrgSavedInConDtlView().getText();
//
//		if (actorgName.trim().equals(orgName)) {
//
//			System.out.println(orgName + "is Created==PASS");
//
//		} else {
//
//			System.out.println(orgName + "is not Created==FAIL");
//
//		}
//
//	}
	}
}
