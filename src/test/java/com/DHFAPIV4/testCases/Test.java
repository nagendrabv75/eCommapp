package com.DHFAPIV4.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test {
	public static WebDriver driver;
	
	    public static void main(String args[]) {
	    	
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    	

			ChromeOptions o= new ChromeOptions();
			o.addArguments("--incognito");
			
			DesiredCapabilities c = new DesiredCapabilities();
			c.setCapability(ChromeOptions.CAPABILITY, driver);
			
			
			driver=new ChromeDriver(o);
			driver.manage().timeouts().getImplicitWaitTimeout();
			
	        driver.get("https://www.geeksforgeeks.org/"); 
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        //Scroll down till the bottom of the page
	        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	        
	        
	 
	    }
	}

