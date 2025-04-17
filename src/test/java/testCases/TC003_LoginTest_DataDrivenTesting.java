package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTest_DataDrivenTesting extends BaseClass
{
	
	@Test(priority=1, dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="Datadriven")// getting data from data provider which is present in DataProviders.class	
	public void verify_login(String email, String password, String exp)
	{
		
			logger.info("***Starting TC003_LoginTest_DataDrivenTesting***");
			try
			{
				//Step:1 HomePage, click MyAccount, Click LoginButton
				HomePage hp=new HomePage(driver);
				logger.info("***clicked**");
				hp.clickMyAccount();				
				hp.clickLogin();
				
				//Step:3 On Login page, Enter EmailID, Enter password, Click Login button
				LoginPage lp=new LoginPage(driver);
				logger.info("***Entered**");
				lp.enterEmailAddress(email);				
                lp.enterPassword(password);
				lp.clickLogin();
				
				//Step:3 On MyAccountPage verify 
				MyAccountPage map=new MyAccountPage(driver);
				boolean targetPage = map.isMyAccountHeaderExist();
				System.out.println("The Target Page: is"+targetPage);
				
				
				//Validation
				/*Scenario:1
				 * valid data - Login successful - Test Passed - logout
				 * valid data - Login unsuccessful-Test Fail, Here logout is not necessary because login itself is not successfull
				 */
				if(exp.equalsIgnoreCase("Valid"))//valid data is passed as parameter
				{
					System.out.println("The Expected Result is:"+exp);
					if(targetPage==true)//login is successsfull
					{
						map.clickLogout();//logout
						Assert.assertTrue(true);//Test is passed
						
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				 /*Provide Invalid data - But logged in successfully - Test should be failed - As it is logged in we need to click on logout
				 * Provided Invalid data - But Login is unsuccessful - Test should be Passed no need of logout as it  */
				
				if(exp.equalsIgnoreCase("Invalid"))//data is invalid, login is not successful Test is passed
					                               //data is invalid, login is successfull Test is failed & logout
					                                // if target is false then only else part will be executed
				{
					System.out.println("The Expected Result is:"+exp);
					if(targetPage==true)//login is passed
					{
						map.clickLogout();//logout
						Assert.assertTrue(false);
						
					}
					else
					{
						Assert.assertTrue(true);// Test should be passed 
					}
					
				}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("***Finished TC003_LoginTest_DataDrivenTesting***");
	}

}
			

