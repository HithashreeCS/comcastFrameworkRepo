package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHomePage {

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement craeteContactLnk;
	WebDriver driver;
	 public ContactHomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	public WebElement getCraeteContactLnk() {
		return craeteContactLnk;
	}
	 
	 
}
