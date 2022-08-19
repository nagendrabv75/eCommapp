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
	

	//Searching for WebElements
	
	//Rerun Button
	@FindBy(xpath="/html/body/div[1]/div/main/div/div[2]/div/div/button[1]")
	@CacheLookup
	WebElement ReRun;
	
	//Scenario -DCR
	@FindBy(linkText="Dynamic Client Registration")
	@CacheLookup
	WebElement DCR;
	
	
	//Scenario -Concurrent Consent
	@FindBy(linkText="Concurrent Consent")
	@CacheLookup
	WebElement CC;
	
	
	//Get Software Product Status Register Polling
	@FindBy(linkText="Get Software Product Status Register Polling")
	@CacheLookup
	WebElement getSPS;
	
	//Ensure Infosec Endpoints Using MTLS
	@FindBy(linkText="Ensure Infosec Endpoints Using MTLS")
	@CacheLookup
	WebElement MTLS;
		
	//Ensure Holder Of Key For Resource Requests
	@FindBy(linkText="Ensure Holder Of Key For Resource Requests")
	@CacheLookup
	WebElement HOK;
	
	//Ensure Client Assertion Data In Token Request
	@FindBy(linkText="Ensure Client Assertion Data In Token Request")
	@CacheLookup
	WebElement ECADTR;
	
	//Scenario -Removed SW Product
	@FindBy(xpath="/html/body/div/div/main/div/div/div[3]/section/div/div[1]/div/table/tbody/tr[8]/td[1]/a")
	//@FindBy(linkText="Removed Software Product")
	@CacheLookup
	WebElement RSP;
	
	//Amending Existing Consent
	@FindBy(linkText="Amending Existing Consent")
	@CacheLookup
	WebElement AEC;
	
	
	//Data Holder Initiated Revocation
	@FindBy(linkText="Data Holder Initiated Revocation")
	@CacheLookup
	WebElement DHIR;
	
	//Data Recipient Initiated Revocation
	@FindBy(linkText="Data Recipient Initiated Revocation")
	@CacheLookup
	WebElement DRIR;
	
	
	//Data Recipient Initiated Token Revocation
	@FindBy(linkText="Data Recipient Initiated Token Revocation")
	@CacheLookup
	WebElement DRITR;	
	
	
	//Click continue button after polling
	@FindBy(id="continue-test-execution-button")
	@CacheLookup
	WebElement Continue;
	
	//Click continue button after SPS polling 
	@FindBy(id="continue-test-execution-button")
	@CacheLookup
	WebElement ContinueSPS;
	
	//Click the Run manual browser step
	//@FindBy(xpath="/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[17]/td[2]/a")
	@FindBy(id="run-manual-browser-step")
	@CacheLookup
	WebElement RunManualBrowserStep;
	
	//Click the Run manual browser step Again
	@FindBy(id="run-manual-browser-step")
	@CacheLookup
	WebElement RunManualBrowserStepAgain;
	
	//Click the Run Manual Browser Step again for AEC
	@FindBy(xpath="/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[41]/td[2]/a")
	@CacheLookup
	WebElement RMBAEC;
	
	
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
	
	
	
	
	//Action Methods
	
	public void clickDCR()
	{
		DCR.click();
	}
	
	public void clickCC()
	{
		CC.click();
	}
	public void getSPS()
	{
		getSPS.click();
	}
	
	public void clickMTLS()
	{
		MTLS.click();
	}
	
	public void clickHOK()
	{
		HOK.click();
	}
	
	public void clickECADTR()
	{
		ECADTR.click();
	}
	
	public void clickRSP()
	{
		RSP.click();
	}
	
	public void clickAEC()
	{
		AEC.click();
	}
	
	public void clickDHIR()
	{
		DHIR.click();
	}
	
	public void clickDRIR()
	{
		DRIR.click();
	}
	
	public void clickDRITR()
	{
		DRITR.click();
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
	
	public void RunManualBrowserStepAgain()
	{
		RunManualBrowserStepAgain.click();
	}
	
	
	public void RMBAEC()
	{
		RMBAEC.click();
	}
	
	public void CustIdEnergy()
	{
		CustId.sendKeys("mmoss");
			
	}
	public void CustIdBanking()
	{
		CustId.sendKeys("ksmith");
			
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
	
	public void continueSPS()
	{
		ContinueSPS.click();
		
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
