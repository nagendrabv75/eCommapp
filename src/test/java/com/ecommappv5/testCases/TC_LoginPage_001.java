package com.ecommappv5.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommappv5.pageObjects.LoginPage;

public class TC_LoginPage_001 extends baseClass {
	
	
	
	
	@Test
	public void loginPageMethod() throws InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("Launched the Page");
		Thread.sleep(5000);
		
		
		LoginPage LP=new LoginPage(driver);
		
		LP.clearUserName();
		LP.setUserName(username);
		logger.info("UserName provided");
		
		
		LP.clearPassword();
		LP.setPassword(password);
		logger.info("Password provided");

		
		LP.clickLogin();
		logger.info("Successfully logged in");
		
		String Title= driver.getTitle();
		if (Title.equals("Dashboard / nopCommerce administration"))
		{
			AssertJUnit.assertTrue(true);
		}
		else
		{
			AssertJUnit.assertTrue(false);
		}
		
		
		LP.clickLogout();
		logger.info("Successfully Logged out");

	}

}
