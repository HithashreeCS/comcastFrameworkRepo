package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule-1 create a separate java class
public class LoginPage  {
	
	/**
	 * 
	 * @author hitha
	 * 
	 * Contains Login Page elements & busness lib like login()
	 */
	WebDriver driver;

//Rule3:object Initialization
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// rule-2 object creation
	@FindBy(xpath="//input[@type='text']")
	private WebElement usernameEdt;

	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordEdt;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;

	// rule :4 object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Rule 5 provide Action or bussniss lib
	/**
	 * login to application based username, password arguments
	 * @param userName
	 * @param passWord
	 */
	public void loginToApp(String userName, String passWord) {
		usernameEdt.sendKeys(userName);
		passwordEdt.sendKeys(passWord);
		loginBtn.click();
	}

}
