package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage extends BasePage
{
	public WebDriver driver;

	//Constructor
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	//Locator
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myaccountheaderloc;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccloc;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutloc;
	
	
	
	//Action Method
	public boolean isMyAccountHeaderExist() 
	{
		try
		{
			return(myaccountheaderloc.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogout()
	{
		logoutloc.click();
	}
	

}
