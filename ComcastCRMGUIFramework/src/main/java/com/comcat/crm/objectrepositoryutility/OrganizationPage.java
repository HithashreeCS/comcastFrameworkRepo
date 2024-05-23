package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	WebDriver driver;
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindBy(name = "search_text")
	private WebElement searchlnk;

	@FindBy(name = "search_field")
	private WebElement serachDD;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbtn;

	public OrganizationPage(WebDriver driver) 
		 {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchlnk() {
		return searchlnk;
	}

	public WebElement getSerachDD() {
		return serachDD;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
}
