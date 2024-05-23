package practice.test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;

		@BeforeSuite
		public void configBS() {
			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Result");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
		// add env information &create test
		report = new ExtentReports();
			report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
				}

	@AfterSuite
		public void configAS() {
			report.flush();
		}

		@Test
		public void createContact() {
			// spark report config
           WebDriver driver=new ChromeDriver();
           driver.get("http://localhost:8888/");
           TakesScreenshot tse = (TakesScreenshot)driver;
      String src= tse.getScreenshotAs(OutputType.BASE64);
     // File desc=new File(/.)
			
			

			ExtentTest test = report.createTest("createContact");

			test.log(Status.INFO, "login to app");
			test.log(Status.INFO, "navigate to contact page");
			test.log(Status.INFO, "create contact");
			if ("HDFC".equals("HDFC")) {
				test.log(Status.PASS, " contact is created ");
			} else {
				test.log(Status.FAIL, " contact is not created ");

			}
		}
}
