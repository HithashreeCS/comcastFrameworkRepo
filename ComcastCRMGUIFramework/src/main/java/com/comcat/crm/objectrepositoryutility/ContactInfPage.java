package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement contactheaderlnk;
@FindBy(id="dtlview_Last Name")
private WebElement cantactLastnamelnk;

@FindBy(id="dtlview_Support End Date")
private WebElement enddatelnk;

@FindBy(id="dtlview_Support Start Date")
private WebElement startdatelnk;

WebDriver driver;
public ContactInfPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public WebElement getContactheaderlnk() {
	return contactheaderlnk;
}
public WebElement getCantactLastnamelnk() {
	return cantactLastnamelnk;
}
public WebElement getEnddatelnk() {
	return enddatelnk;
}
public WebElement getStartdatelnk() {
	return startdatelnk;
}






}
