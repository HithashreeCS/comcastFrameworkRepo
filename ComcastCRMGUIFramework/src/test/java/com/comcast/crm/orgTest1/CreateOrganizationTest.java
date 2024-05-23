package com.comcast.crm.orgTest1;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImplementionClass;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcat.crm.objectrepositoryutility.OrganizationPage;
import com.crm.baseUtility.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementionClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createORganizationTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");
		String data = ELib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();

		// navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage op = new HomePage(driver);
		op.getOrglink().click();

		// click on "create Organization button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		OrganizationPage omp = new OrganizationPage(driver);
		omp.getCreateNewOrgBtn().click();

		// enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO,"create a new Org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(data);
		UtilityClassObject.getTest().log(Status.INFO,data+"==>Create a new Org");

		// verify Header msg Expexted Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		WebElement actOrgName = oip.getHeaderMsg();
		WLib.waitForElementPresent(driver, actOrgName);
		String text = actOrgName.getText();
		boolean act=text.contains(data);
		Assert.assertEquals(act, true);
//		if (text.contains(data)) {
//			System.out.println(data + " name is verfied==PASS");
//		} else {
//			System.out.println(data + " name is not  verfied==Fail");
//		}

	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationIndustriesTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");

		String data = ELib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();

		// String orgname = ELib.getDataFromExcel("Org", 4, 2) + jLib.getRandomNumber();
		String industry = ELib.getDataFromExcel("Org", 4, 3);

		String type = ELib.getDataFromExcel("Org", 4, 4);

		UtilityClassObject.getTest().log(Status.INFO,"navigate to Org");

		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");

		OrganizationPage oP = new OrganizationPage(driver);
		oP.getCreateNewOrgBtn().click();

		// Click on "create organization" button
		UtilityClassObject.getTest().log(Status.INFO,"create new org,industry,type");

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(data, industry, type);
		
		UtilityClassObject.getTest().log(Status.INFO,data+"=="+industry+"=="+type+"==>Create a new Org<==");

		// enter all the details and create new Organization

		// verify dropdown industries and type info expected result

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		WebElement actOrgName = oip.getHeaderMsg();
		WLib.waitForElementPresent(driver, actOrgName);
		String text = actOrgName.getText();
		boolean act=text.contains(data);
		Assert.assertEquals(act, true);
//		if (text.contains(data)) {
//			System.out.println(data + " name is verfied==PASS");
//		} else {
//			System.out.println(data + " name is not  verfied==Fail");
//		}

		// verify type

		String actType = oip.getTypelnk().getText();
		
		Assert.assertEquals(type, actType);
//		if (actType.equals(type)) {
//			System.out.println(type + "is verified==PASS");
//		} else {
//			System.out.println(type + "is not verified");
//		}

		String industries = oip.getIndrustrieslnk().getText();
		Assert.assertEquals(industry, industries);
//		if (industries.equals(industry)) {
//			System.out.println(industry + "is verified==PASS");
//		} else {
//			System.out.println(industry + "is not verified");
//		}

	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationWithPhoneNumberTest() throws Throwable {

		String data = ELib.getDataFromExcel("Org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = ELib.getDataFromExcel("Org", 7, 3);

		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Click on "create organization" button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// enter all the details and create new Organization
		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(data, phoneNumber);
		// verify dropdown industries and type info expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		// WebElement actOrgName = oip.getHeaderMsg();
		// WLib.waitForElementPresent(driver, actOrgName);

		WebElement actOrgName = oip.getHeaderMsg();
		WLib.waitForElementPresent(driver, actOrgName);
		String text = actOrgName.getText();
		boolean act=text.contains(data);
		Assert.assertEquals(act, true);
		//String header = oip.getHeaderMsg().getText();
		//boolean status = text.contains(data);
		
//		if (text.contains(data)) {
//			System.out.println(data + " name is verfied==PASS");
//		} else {
//			System.out.println(data + " name is not  verfied==Fail");
//		}

		String actph = oip.getVerifyphonelnk().getText();
		Assert.assertEquals(phoneNumber, actph);

//		if (actph.equals(phoneNumber)) {
//			System.out.println(phoneNumber + "is verified==PASS");
//		} else {
//			System.out.println(phoneNumber + "is not verified");
//		}
		// verify type

		// logout
		// driver.quit();
	}

}
