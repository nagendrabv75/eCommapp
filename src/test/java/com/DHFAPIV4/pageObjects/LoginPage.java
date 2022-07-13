package com.DHFAPIV4.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"i0116\"]")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement Next;
	
	
	@FindBy(xpath="//*[@id=\"i0118\"]")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement SignIn;
	
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement StaySignIn;
	
	@FindBy(xpath="/html/body/div/div/header/div/button")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void clearUserName()
	{
		UserName.clear();
	}
	
	public void clearPassword()
	{
		txtPassword.clear();
	}
	
	
	public void setUserName(String uname)
	{
		UserName.sendKeys(uname);
	}
	
	public void clickNext()
	{
		Next.click();
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
		
	public void clickSignIn()
	{
		SignIn.click();
	}
	
	public void clickStaySignIn()
	{
		StaySignIn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	
	}

}
