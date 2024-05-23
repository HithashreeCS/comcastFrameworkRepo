package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orglookup;

	public WebElement getOrglookup() {
		return orglookup;
	}

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savelnk;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerlnk;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNum;

	@FindBy(name="support_start_date")
	private WebElement startDate;

	@FindBy(name="support_end_date")
	private WebElement endDate;

	WebDriver driver;

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavelnk() {
		return savelnk;
	}

	public WebElement getHeaderlnk() {
		return headerlnk;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public void createContact(String Lastname) {
		lastname.sendKeys(Lastname);
		savelnk.click();

	}

}
