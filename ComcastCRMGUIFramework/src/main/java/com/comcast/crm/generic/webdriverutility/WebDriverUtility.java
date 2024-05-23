package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
//	public void windowHandle(WebDriver driver)
//	{
//		String id=driver.getWindowHandle();
//		String title=driver.getCurrentUrl();
//		String parentWindowId=id+title;
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String> it = set.iterator();
//		while (it.hasNext()) {
//			String WindowId = it.next();
//			String ChildWindowId=driver.switchTo().window(WindowId).getCurrentUrl();
//			if(ChildWindowId.contains(parentWindowId))
//			{
//				break;
//			}
//		}
		
	
	public void swithToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String WindowId = it.next();
			driver.switchTo().window(WindowId);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	public void swithToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String WindowId = it.next();
			driver.switchTo().window(WindowId);
			String actTitl = driver.getTitle();
			if (actTitl.contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String NameId) {
		driver.switchTo().frame(NameId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public Select dropDown(WebElement element)
	{
		Select s=new Select(element);
		return s;
		
	}
	public void select(WebElement element,String text) {
		
		dropDown(element).selectByVisibleText(text);
	}

	public void select(int index,WebElement element) {
		
		dropDown(element).selectByIndex(index);
	}
	
	public Actions mouseOver(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	public void mouseMoveOnElement(WebDriver driver,WebElement element)
{
	mouseOver(driver).moveToElement(element);
}
public void doubleClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
}
