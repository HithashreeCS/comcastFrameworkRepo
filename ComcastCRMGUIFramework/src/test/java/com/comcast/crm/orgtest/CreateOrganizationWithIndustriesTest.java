package com.comcast.crm.orgtest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcat.crm.objectrepositoryutility.OrganizationPage;
import com.crm.baseUtility.BaseClass;

@Test
public class CreateOrganizationWithIndustriesTest extends BaseClass {

	public void CreateOrganizationIndustriesTest() throws Throwable {

		String data = ELib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNumber();

		// String orgname = ELib.getDataFromExcel("Org", 4, 2) + jLib.getRandomNumber();
		String industry = ELib.getDataFromExcel("Org", 4, 3);

		String type = ELib.getDataFromExcel("Org", 4, 4);

//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationPage oP = new OrganizationPage(driver);
		oP.getCreateNewOrgBtn().click();

//Click on "create organization" button
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(data, industry, type);

//enter all the details and create new Organization

//verify dropdown industries and type info expected result

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		WebElement actOrgName = oip.getHeaderMsg();
		WLib.waitForElementPresent(driver, actOrgName);
		String text = actOrgName.getText();
		if (text.contains(data)) {
			System.out.println(data + " name is verfied==PASS");
		} else {
			System.out.println(data + " name is not  verfied==Fail");
		}

//verify type

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

}
