package com.crm.baseUtility;



import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility ELib = new ExcelUtility();
	public JavUtility jLib = new JavUtility();
	public WebDriverUtility WLib = new WebDriverUtility();

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws SQLException {
		System.out.println("===connect to DB,Report Config=====");
		dbLib.getdbConcection();

	}

	// @Parameters ("BROWSER")
	// public void configBC(String browser) throws Throwable {
	// String BROWSER =browser;
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Throwable {
		System.out.println(" ==Lanuch the browser===");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		{
			sdriver = driver;
			UtilityClassObject.setDriver(driver);
		}
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		WLib.waitForPageToload(driver);
		driver.manage().window().maximize();

	}

	@BeforeMethod(alwaysRun = true)
	public void createConfig() throws Throwable {

		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println(" ==Login==");

	}

	@AfterMethod(alwaysRun = true)
	public void createAM() {
		HomePage hp = new HomePage(driver);
		hp.logOut();
		System.out.println("==logout==");
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
		System.out.println("===close the Browser===");
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException {
		dbLib.closedbConnection();
		System.out.println("====Close DB,Report backup");
		
	}

}
