package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	//Object creation
@FindBy(linkText="Organizations")
private WebElement orglink;

@FindBy(linkText="Contacts")
private WebElement contact;

@FindBy(linkText="Campaigns")
private WebElement compaignslnk;

@FindBy(linkText="More")
private WebElement morelnk;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminIMG;

@FindBy(linkText ="Sign Out")
private WebElement signoutlnk;

//Rule3:object Initialization
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContact() {
		return contact;
		
	}
	public WebElement getCompaignslnk() {
		return compaignslnk;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

	public WebElement getAdminIMG() {
		return adminIMG;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}

	public void navigateToCampaginPage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(morelnk).perform();
		compaignslnk.click();
	}
	
	public void logOut()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminIMG).perform();
		signoutlnk.click();
	}

}
