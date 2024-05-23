package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavUtility;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.comcat.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcat.crm.objectrepositoryutility.OrganizationPage;
import com.crm.baseUtility.BaseClass;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createORganizationTest() throws Throwable {

		String data = ELib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();

		// navigate to organization module
		HomePage op = new HomePage(driver);
		op.getOrglink().click();

		// click on "create Organization button
		OrganizationPage omp = new OrganizationPage(driver);
		omp.getCreateNewOrgBtn().click();

		// enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(data);

		// verify Header msg Expexted Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		WebElement actOrgName = oip.getHeaderMsg();
		WLib.waitForElementPresent(driver, actOrgName);
		String text = actOrgName.getText();
		if (text.contains(data)) {
			System.out.println(data + " name is verfied==PASS");
		} else {
			System.out.println(data + " name is not  verfied==Fail");
		}

	}

	@Test(groups = "regressionTest")

		public void CreateOrganizationIndustriesTest() throws Throwable {

			String data = ELib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();

			// String orgname = ELib.getDataFromExcel("Org", 4, 2) + jLib.getRandomNumber();
			String industry = ELib.getDataFromExcel("Org", 4, 3);

			String type = ELib.getDataFromExcel("Org", 4, 4);

			// navigate to organization module
			HomePage hp = new HomePage(driver);
			hp.getOrglink().click();

			OrganizationPage oP = new OrganizationPage(driver);
			oP.getCreateNewOrgBtn().click();

			// Click on "create organization" button
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(data, industry, type);

			// enter all the details and create new Organization

			// verify dropdown industries and type info expected result

			OrganizationInfoPage oip = new OrganizationInfoPage(driver);

			WebElement actOrgName = oip.getHeaderMsg();
			WLib.waitForElementPresent(driver, actOrgName);
			String text = actOrgName.getText();
			if (text.contains(data)) {
				System.out.println(data + " name is verfied==PASS");
			} else {
				System.out.println(data + " name is not  verfied==Fail");
			}

			// verify type

			String actType = oip.getTypelnk().getText();
			if (actType.equals(type)) {
				System.out.println(type + "is verified==PASS");
			} else {
				System.out.println(type + "is not verified");
			}

			String industries = oip.getIndrustrieslnk().getText();
			if (industries.equals(industry)) {
				System.out.println(industry + "is verified==PASS");
			} else {
				System.out.println(industry + "is not verified");
			}

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

		WebElement actOrgName = oip.getHeaderMsg();
		WLib.waitForElementPresent(driver, actOrgName);
		String text = actOrgName.getText();
		if (text.contains(data)) {
			System.out.println(data + " name is verfied==PASS");
		} else {
			System.out.println(data + " name is not  verfied==Fail");
		}

		String actph = oip.getVerifyphonelnk().getText();

		if (actph.equals(phoneNumber)) {
			System.out.println(phoneNumber + "is verified==PASS");
		} else {
			System.out.println(phoneNumber + "is not verified");
		}
		// verify type

		// logout
		// driver.quit();
	}

}
