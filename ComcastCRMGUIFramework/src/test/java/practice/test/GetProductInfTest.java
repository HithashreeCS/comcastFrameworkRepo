package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfTest {

	@Test(dataProvider = "getData")
	public void getProductInfTest(String brandName, String ProductName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		// serach Product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brandName, Keys.ENTER);

		// capture product Info
		String x = "(//span[text()='" + ProductName
				+ "'])[1]/../../../../div[3]/div/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int RowCount = eLib.getRowCount("Product");
		Object[][] objArr = new Object[RowCount][2];
		
		for (int i = 0; i < RowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcel("Product", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcel("Product", i + 1, 1);
		}
		return objArr;
	}
}

/*
 * @DataProvider public Object[][] getData() { Object[][] objArr= new
 * Object[3][2]; objArr[0][0]="iphone";
 * objArr[0][1]="Apple iPhone 13 (128GB) - Starlight";
 * 
 * 
 * objArr[1][0]="iphone"; objArr[1][1]="Apple iPhone 15 (128 GB) - Black";
 * 
 * objArr[2][0]="iphone"; objArr[2][1]="Apple iPhone 15 (256 GB) - Blue";
 * 
 * return objArr;
 * 
 */
