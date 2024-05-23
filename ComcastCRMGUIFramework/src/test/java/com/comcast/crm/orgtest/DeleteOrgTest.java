package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.comcat.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcat.crm.objectrepositoryutility.OrganizationPage;

public class DeleteOrgTest {

	
		public static void main(String[] args) throws Throwable {
			FileUtility fLib = new FileUtility();
			ExcelUtility ELib = new ExcelUtility();
			JavUtility jLib = new JavUtility();
			WebDriverUtility wDu=new WebDriverUtility();

			String BROWSER = fLib.getDataFromPropertiesFile("browser");
			String URL = fLib.getDataFromPropertiesFile("url");
			String USERNAME = fLib.getDataFromPropertiesFile("username");
			String PASSWORD = fLib.getDataFromPropertiesFile("password");

			

			String data = ELib.getDataFromExcel("Contacts",8,2) + jLib.getRandomNumber();

			// launch browser
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);

			// login to app
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			// navigate to organization module
			HomePage op = new HomePage(driver);
			op.getOrglink().click();

			// click o "create Organization button
			OrganizationPage omp = new OrganizationPage(driver);
			omp.getCreateNewOrgBtn().click();

			// enter all the details and create new organization
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(data);

			// verify Header msg Expexted Result
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String actOrgName = oip.getHeaderMsg().getText();
	if(actOrgName.contains(data))
	{
		System.out.println(data +" name is verfied==PASS");
	}
	else
	{
		System.out.println(data +" name is not  verfied==Fail");
	}
	
	//go back  organization page
	
	op.getOrglink().click();

	
	//search for organization
	omp.getSearchlnk().sendKeys(data);
	wDu.select( omp.getSerachDD(),"Organization Name");
	omp.getSearchbtn().click();
	
	//In dynamic webTable select and delete Org
	driver.findElement(By.xpath("(//a[text()='"+data+"'])[2]/../../td[8]/a[2]")).click();
	
 Alert alert=driver.switchTo().alert();
 alert.accept();
	//logout 
	op.logOut();
	driver.quit();
		}

	}


