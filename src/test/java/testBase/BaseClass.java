package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger;// Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger;// log4j
	public Properties prop;
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	
	public void setup(String os, String br) throws InterruptedException, IOException
	{
		//Loading config.properties file
		try 
		{
			FileReader file=new FileReader("D:\\Workspace\\Ecommerce\\src\\test\\resources\\config.properties");
			prop = new Properties();
			prop.load(file);
			
		} 
		catch (FileNotFoundException e) 
		{			
			e.printStackTrace();
		}
		
		//Logging
		logger=LogManager.getLogger(this.getClass());// dynamically we are getting the name of class name
		
		//below block will execute the browser
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); 
		break;
		case "edge" : driver = new EdgeDriver();
		break;
		case "firefox": driver = new FirefoxDriver();
		break;
		default: System.out.println("Invalid browser name...");
		return;
		}
				
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appURL"));//reading url from properities file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(3000);
		 
	}
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}
	
	//Reusable Methods
	public String randomString() 
	{
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    SecureRandom random = new SecureRandom();
	    StringBuilder sb = new StringBuilder(10);
	    
	    for (int i = 0; i < 10; i++) {
	        int index = random.nextInt(characters.length());
	        sb.append(characters.charAt(index));
	    }
	    
	    return sb.toString();
	}
	public String randomNumber()
	{
	    SecureRandom random = new SecureRandom();
	    StringBuilder sb = new StringBuilder(10); // Set desired length here

	    for (int i = 0; i < 10; i++) {
	        int digit = random.nextInt(10); // 0 to 9
	        sb.append(digit);
	    }

	    return sb.toString();
	}
	
	//Capture screenshot Method
	public String captureScreen(String tname)
	{
		//Step:1-Giving the timestamp to differentiate the screenshots
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot tss=(TakesScreenshot)driver;
		File sourcefile = tss.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		File targetFile = new File(targetFilePath);
		sourcefile.renameTo(targetFile);
		return targetFilePath;
		
	}
	
	
	
}
