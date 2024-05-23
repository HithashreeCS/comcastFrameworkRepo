package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	@FindBy(name = "button")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement acctype;

	@FindBy(name = "phone")
	private WebElement phonelnk;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getAcctype() {
		return acctype;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPhonelnk() {
		return phonelnk;
	}

	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();

	}

	/*
	 * public void createOrg(String orgName, String industry) {
	 * orgNameEdt.sendKeys(orgName); Select s = new Select(industryDD);
	 * s.selectByVisibleText(industry); saveBtn.click();
	 */
	// }

	public void createOrg(String orgName, String industry, String type) throws Throwable {
		orgNameEdt.sendKeys(orgName);
		Select s = new Select(industryDD);
		s.selectByVisibleText(industry);
		Select ss = new Select(acctype);
		ss.selectByVisibleText(type);
		saveBtn.click();

	}

	public void createOrg(String orgName, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		phonelnk.sendKeys(phoneNumber);
		saveBtn.click();
	}
}
