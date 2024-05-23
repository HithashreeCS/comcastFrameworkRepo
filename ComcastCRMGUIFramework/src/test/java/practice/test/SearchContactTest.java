package practice.test;
/**
 * test class for Contact Module
 * @author hitha
 */
import org.testng.annotations.Test;

import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.crm.baseUtility.BaseClass;

public class SearchContactTest  extends BaseClass
{
/**
 *Scenario: login()==>navigateContact==>createContact()==verify
 
 */
	@Test
	public void searchContactTest()
	{
		/* Step :login to app */
		 
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("username", "password");
	}
}
