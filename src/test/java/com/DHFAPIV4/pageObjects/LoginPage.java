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
	
	
	@FindBy(id="i0116")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement Next;
	
	
	@FindBy(xpath="/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement SignIn;
	
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement StaySignIn;
	
	@FindBy(id="continue")
	@CacheLookup
	WebElement continueLogin;
	
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
	
	public void continueLogin()
	{
		continueLogin.click();
	}

}
