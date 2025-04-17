package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public WebDriver driver;
	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	//Locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailloc;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordloc;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtnloc;
	//Action methods for locators
	public void enterEmailAddress(String email)
	{
		emailloc.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordloc.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginbtnloc.click();
	}

}
