package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.baseUtility.BaseClass;

public class Retry extends BaseClass
{
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryAnalyzerImp.class)
	public  void activateSim()
	{
		System.out.println("execute  createInvoiceTest");
		//String actTitle=driver.getTitle();
		//Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
}
