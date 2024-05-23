package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.baseUtility.BaseClass;

public class ListenerImplementionClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
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

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=========>" + result.getMethod().getMethodName() + "========Start========");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>Started<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=========>" + result.getMethod().getMethodName() + "========End========");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==>Completed<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		TakesScreenshot tse = (TakesScreenshot) BaseClass.sdriver;
		String Filepath = tse.getScreenshotAs(OutputType.BASE64);
		String currentTime = new Date().toString().replace(" ", "_").replace(":", " ");

		test.addScreenCaptureFromBase64String(Filepath, testName+"_"+currentTime);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}

}
