package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[13]")
	private WebElement indrustrieslnk;

	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[15]")
	private WebElement typelnk;

	@FindBy(id = "dtlview_Phone")
	private WebElement verifyphonelnk;

	public WebElement getIndrustrieslnk() {
		return indrustrieslnk;
	}

	public WebElement getTypelnk() {
		return typelnk;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getVerifyphonelnk() {
		return verifyphonelnk;
	}

}
