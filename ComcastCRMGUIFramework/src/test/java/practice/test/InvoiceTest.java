package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.baseUtility.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementionClass.class)
public class InvoiceTest extends BaseClass {

	@Test
	public  void createInvoiceTest()
	{
		System.out.println("execute  createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	
	@Test
	public  void createInvoiceWithContactTest()
	{
		System.out.println("execute  createInvoiceWithContactTest");
		
	}

}
