package com.DHFAPIV4.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class baseClass {

	
	public String baseURL="https://portal.test.cts.cdr.gov.au/";
	public String username="naggi202202@outlook.com";
	public String password="SAIkuteera7-1";
	public String sector="Energy";
	
	public WebDriver driver;
	public Logger logger;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setupMethod()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		ChromeOptions o= new ChromeOptions();
		o.addArguments("--incognito");
		
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability(ChromeOptions.CAPABILITY, driver);
		
		
		driver=new ChromeDriver(o);
		driver.manage().timeouts().getImplicitWaitTimeout();
		
		logger=Logger.getLogger("DHFAPIV4");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}
    
		
}
