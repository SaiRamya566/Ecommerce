package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass
{	
	@Test(priority=1, groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("******Starting TC001_AccountRegistrationTest *****");
		
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("******Clicked on My Account *****");
			hp.clickRegister();
			logger.info("******Clicked on Register *****");
			
			AccountRegistrationPage arp=new AccountRegistrationPage(driver);
			
			logger.info("******Provoide customer details *****");
			arp.enterFirstName(randomString().toUpperCase());
			arp.enterLastName(randomString().toUpperCase());
			arp.enterEmail(randomString()+"@gmail.com");
			arp.enterPhoneNumber(randomNumber());
			arp.enterPassword("SaiRamya@123");
			arp.enterConfirmPassword("SaiRamya@123");
			arp.clickPolicy();
			arp.clickContinuebutton();
			
			logger.info("******Validate the confirmation Page *****");
			
			String cnfmessage=arp.getCofirmationMessage();
			if(cnfmessage.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				logger.error("Account Registration Failed");
				logger.debug("Debug Logs...");			
			}
							
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("********Finished TC001_AccountRegistrationTest************");
	}
	
	
	
	
	
	
	
	
}
