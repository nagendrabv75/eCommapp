package com.DHFAPIV4.pageObjects;

import org.testng.annotations.Test;

import com.DHFAPIV4.testCases.baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class selectScenario {
	
	public WebDriver SCdriver;
	

	public selectScenario(WebDriver rdriver)
	{
		SCdriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	
	
	
	//Rerun Button
	@FindBy(xpath="//*[@id=\"root\"]/div/main/div/div[2]/div/div/button[1]")
	@CacheLookup
	WebElement ReRun;
	
	//Scenario -Removed SW Product
	@FindBy(xpath="//*[@id=\"scenario-7\"]/td[1]/a")
	@CacheLookup
	WebElement RSP;
	
	//Click continue button after polling
	@FindBy(id="continue-test-execution-button")
	@CacheLookup
	WebElement Continue;
	
	//Click the Run manual browser step
	@FindBy(xpath="/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[17]/td[2]/a")
	@CacheLookup
	WebElement RunManualBrowserStep;
	
	//Enter the Customer Id
	@FindBy(id="CustomerId")
	@CacheLookup
	WebElement CustId;

	//Click Continue button in Customer Page
	@FindBy(xpath="/html/body/div/div/div/form/div[3]/div/div[1]/button")
	@CacheLookup
	WebElement CustIdContiue;
	
	
	//Enter the OTP
	@FindBy(xpath="/html/body/div/div/div/form/div[3]/div/input")
	@CacheLookup
	WebElement OTP;

	
	//Click Continue button in OTP Page
	@FindBy(xpath="html/body/div/div/div/form/div[4]/div/div[1]/button")
	@CacheLookup
	WebElement OTPContinue;
	
	//Select an Account
	@FindBy(xpath="/html/body/div/div/div/form/div[1]/div[3]/ul/ul[1]/li/div/label/h6")
	@CacheLookup
	WebElement EnableAccount;
	
	
	//Click Continue button in Account Page
	@FindBy(xpath="/html/body/div/div/div/form/div[1]/div[4]/div/div[1]/button")
	@CacheLookup
	WebElement AccContinue;
		
	
	//Click on IConfirm Button
	@FindBy(xpath="/html/body/div/div/div/form/div[2]/div[5]/div/div[1]/button")
	@CacheLookup
	WebElement iConfirm;
	
	//Click on Continue Button after second polling
	@FindBy(xpath="/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[35]/td[2]/button")
	@CacheLookup
	WebElement ContinueAftPolling;
	
	//Click the Back to test plan button
	@FindBy(xpath="/html/body/div[1]/div/main/div/div[2]/div/div/button[2]")
	@CacheLookup
	WebElement BackToTP;
	
	
	
	public void clickRSP()
	{
		RSP.click();
	}
	
		
	public void reRunButton()
	{
		ReRun.click();
	}
	
	public void Continue()
	{
		
		Continue.click();
		
	}
	
	public void RunManualBrowserStep()
	{
		RunManualBrowserStep.click();
	}
	
	public void CustId()
	{
		CustId.sendKeys("mmoss");
			
	}
	
	public void CustIdContinue()
	{
		CustIdContiue.click();
		
	}
	
	public void EnterOTP()
	{
		OTP.sendKeys("000789");
	}
	
	public void OTPContinue()
	{
		OTPContinue.click();
		
	}
	
	public void SelectAcc()
	{
		EnableAccount.click();
	}
	
	public void AccContinue()
	{
		AccContinue.click();
		
	}
	
	public void iConfirm()
	{
		iConfirm.click();
		
	}
	
	public void CAfterPolling()
	{
		ContinueAftPolling.click();
		
	}
	
	public void BackToTP()
	{
		BackToTP.click();
		
	}
	
	
	
}
