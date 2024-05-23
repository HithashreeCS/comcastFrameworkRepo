package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavUtility;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcat.crm.objectrepositoryutility.OrganizationPage;
import com.crm.baseUtility.BaseClass;

public class CreateOrganizationWithPhoneNumber extends BaseClass {
	@Test
	public void test() throws Throwable {

		String data = ELib.getDataFromExcel("Org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = ELib.getDataFromExcel("Org", 7, 3);

//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

//Click on "create organization" button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

//enter all the details and create new Organization
		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.createOrg(data, phoneNumber);
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

		String actph = oip.getVerifyphonelnk().getText();

		if (actph.equals(phoneNumber)) {
			System.out.println(phoneNumber + "is verified==PASS");
		} else {
			System.out.println(phoneNumber + "is not verified");
		}
//verify type

// logout
//driver.quit();
	}

}

