package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(priority=1, groups={"Sanity","Master"})
	
	public void verify_login()
	{
		try 
		{
			logger.info("***Starting TTC002_LoginTest***");
			
			HomePage hp=new HomePage(driver);
			//Step:1
			logger.info("***Clicked on My Account***");
			hp.clickMyAccount();
			//Step:2
			logger.info("***Clicked on Login***");
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			//Step:3
			logger.info("***Entered email address***");
			lp.enterEmailAddress(prop.getProperty("email"));
			//Step:4
			logger.info("***Entered password***");
			lp.enterPassword(prop.getProperty("password"));
			//Step:5
			logger.info("***clicked on login button***");
			lp.clickLogin();
			
			MyAccountPage map=new MyAccountPage(driver);
			//Step:6
			logger.info("***Validate the My Account header***");
			boolean targetPage = map.isMyAccountHeaderExist();
			Assert.assertEquals(targetPage, true, "Login Failed");
			
		}
		catch(Exception e)
		{
			Assert.fail("Testcase is failed");
		}
		
				
		
		
	}
	
	
}
