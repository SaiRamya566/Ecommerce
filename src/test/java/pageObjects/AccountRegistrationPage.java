package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	WebDriver driver;
    //Step:1 Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Step:2 Identify the WebElements on Registration Page
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstnameloc;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastnameloc;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailloc;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephoneloc;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordloc;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpassloc;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement policycheckboxloc;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continuebuttonloc;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmationloc;
	
	//Step:3 For the identified elements perform the actions
	public void enterFirstName(String fname)
	{
		firstnameloc.sendKeys(fname);
	}
	public void enterLastName(String lname)
	{
		lastnameloc.sendKeys(lname);
	}
	public void enterEmail(String email)
	{
		emailloc.sendKeys(email);
	}
	public void enterPhoneNumber(String pnumber)
	{
		telephoneloc.sendKeys(pnumber);
	}
	public void enterPassword(String pwd)
	{
		passwordloc.sendKeys(pwd);
	}
	public void enterConfirmPassword(String cpwd)
	{
		confirmpassloc.sendKeys(cpwd);
	}
	public void clickPolicy()
	{
		policycheckboxloc.click();
	}
	public void clickContinuebutton()
	{
		continuebuttonloc.click();
	}
	public String getCofirmationMessage()
	{
		try
		{
			return(msgconfirmationloc.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

	

}
