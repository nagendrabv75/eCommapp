package com.DHFAPIV4.testCases;

import org.testng.annotations.Test;

import com.DHFAPIV4.pageObjects.LoginPage;
import com.DHFAPIV4.pageObjects.selectScenario;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestPlanV4 extends baseClass {
		
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Login and Navigate to CTS Participant Portal Home Page
	@Test(priority=1)
	public void loginPageMethod() throws InterruptedException
	{
		//Launch the Participant Portal
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("Launched the Page using  Chrome in Incognito Mode");
			
		LoginPage LP=new LoginPage(driver);
		
		//Enter the email/username
		Thread.sleep(5000);
		LP.clearUserName();
		LP.setUserName(username);
		logger.info("UserName provided");
		Thread.sleep(3000);
		LP.clickNext();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement PasswordDialogBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div/input")));
		
		//Enter the password
		LP.clearPassword();
		LP.setPassword(password);
		logger.info("Password provided");
		LP.clickSignIn();
		logger.info("Successfully clicked logged in");
				
		//Staying SignedIn
		LP.clickStaySignIn();
		logger.info("Successfully clicked Stay Signed in");
		
		//Waiting for the authentication via authenticator - Manual intervention
		Thread.sleep(10000);
		LP.continueLogin();
		logger.info("Successfully Authenticated using Authenticator");
				
		String Title= driver.getTitle();
			
		if (Title.equals("Conformance Test Suite - Test Plans"))
		{
			logger.info(("Launched CTS Participant Portal"));
		}
		
		
		WebDriverWait waitForRS=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement waitForRSShowup = waitForRS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[3]/section/div/div[2]/button")));
		
	}
	

	//Create a list of Scenarios
	@Test(priority=2)
	public void listofScenarios() throws InterruptedException, IOException
	{
		
		ArrayList<String> ScenarioList = new ArrayList<String>();
		
		ScenarioList.add("Dynamic Client Registration");
		ScenarioList.add("Concurrent Consent");
		ScenarioList.add("Get Software Product Status Register Polling");
		ScenarioList.add("Ensure Infosec Endpoints Using MTLS");
		ScenarioList.add("Ensure Holder Of Key For Resource Requests");
		ScenarioList.add("Ensure Client Assertion Data In Token Request");
		ScenarioList.add("Amending Existing Consent");
		ScenarioList.add("Removed Software Product");
		ScenarioList.add("Data Holder Initiated Revocation");
		ScenarioList.add("Data Recipient Initiated Revocation");
		ScenarioList.add("Data Recipient Initiated Token Revocation");
		
		
		for(int i=0;i<ScenarioList.size();i++)
		{
			if(ScenarioList.get(i).equals("Dynamic Client Registration"))
			{
		//		Thread.sleep(3000);
				System.out.println("Dynamic Client Registration");
		//		invokeDCR();
			}
			else if(ScenarioList.get(i).equals("Concurrent Consent"))
			{
		//		Thread.sleep(3000);
				System.out.println("Concurrent Consent");
		//		invokeCC();
			}
			else if(ScenarioList.get(i).equals("Get Software Product Status Register Polling"))
			{
				Thread.sleep(3000);
				System.out.println("Get Software Product Status Register Polling");
			invokeSPS();
		}
			else if(ScenarioList.get(i).equals("Ensure Infosec Endpoints Using MTLS"))
			{
		//		Thread.sleep(3000);
				System.out.println("Ensure Infosec Endpoints Using MTLS");
		//		invokeMTLS();
			}
			else if(ScenarioList.get(i).equals("Ensure Holder Of Key For Resource Requests"))
			{
		//		Thread.sleep(3000);
				System.out.println("Ensure Holder Of Key For Resource Requests");
		//		inovkeHOK();
			}
			else if(ScenarioList.get(i).equals("Ensure Client Assertion Data In Token Request"))
			{
		//		Thread.sleep(3000);
				System.out.println("Ensure Client Assertion Data In Token Request");
		//		invokeECADTR();
			}
			else if(ScenarioList.get(i).equals("Amending Existing Consent"))
			{
		//		Thread.sleep(3000);
				System.out.println("Amending Existing Consent");
		//		invokeAmendingCon();
			}
			else if(ScenarioList.get(i).equals("Removed Software Product"))
			{
		//		Thread.sleep(5000);
				System.out.println("Removed Software Product");
		//		invokeRSP();
			}
			else if(ScenarioList.get(i).equals("Data Holder Initiated Revocation"))
			{
			//	Thread.sleep(3000);
				System.out.println("Data Holder Initiated Revocation");
			//	invokeDHIR();
			}
			else if(ScenarioList.get(i).equals("Data Recipient Initiated Revocation"))
			{
		//		Thread.sleep(3000);
				System.out.println("Data Recipient Initiated Revocation");
		//	invokeDRIR();
			}
			else if(ScenarioList.get(i).equals("Data Recipient Initiated Token Revocation"))
			{
		//		Thread.sleep(3000);
				System.out.println("Data Recipient Initiated Token Revocation");
		//		invokeDRITR();
			}
		}
	}
	

	//**** Creating different methods to run the scenarios****//
	
	
	//Method to run the DCR Scenario
	public void invokeDCR() throws InterruptedException, IOException
	{

		selectScenario SCDCR=new selectScenario(driver);
		String SCWindow=driver.getWindowHandle();
		

		logger.info("Selected Dynamic Client Register");
		SCDCR.clickDCR();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		SCDCR.reRunButton();
		
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		
        //Scroll down till the bottom of the page
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
			
		logger.info("Scenario Successfully Completed");
				
		//Waiting for the status message "Completed"
		WebDriverWait Completed=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement Complete = Completed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/div/span[1]/span/strong")));
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//Capture the full page screen 
		captureFullPageScreenshot("DynamicClientRegistration");
		
		//Navigating back to the Scenarios Test Plan page
		SCDCR.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
		
	}
	
	//Method to run the Concurrent Consent Scenario
	private void invokeCC() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		selectScenario SCCC=new selectScenario(driver);
		String SCWindow=driver.getWindowHandle();

		logger.info("Selected Concurrent Consent");
		SCCC.clickCC();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		SCCC.reRunButton();
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		
		//Invoke the RMB to enter Customer Data
		invokeRMB();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		
		logger.info("Waiting for second RunManualBrowser");
		//Invoking the second Run Manual Browser
		invokeRMBAgain();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);


		
		logger.info("Scenario Successfully Completed");
		//Waiting for the status message "Completed"
		
		WebDriverWait Completed=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement Complete = Completed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/div/span[1]/span/strong")));
		Thread.sleep(3000);
		
		//Capture the full page screen 
		captureFullPageScreenshot("ConcurrentConsent");
		
		//Navigating back to the Scenarios Test Plan page
		SCCC.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");	
		
	}


	//Method to run the getSPS polling Scenario
	@SuppressWarnings("unchecked")
	private void invokeSPS() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		selectScenario SCSPS=new selectScenario(driver);
		String SCWindow=driver.getWindowHandle();
		
		//Explict wait until Secon Run Manual Browser link is displayed
		WebDriverWait waitOnContinue=new WebDriverWait(driver, Duration.ofSeconds(120));
		WebDriverWait continueOnSuccess=new WebDriverWait(driver, Duration.ofSeconds(300));
			

		logger.info("Selected SPS TestPlan");
		SCSPS.getSPS();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		SCSPS.reRunButton();
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		
	//Below was the piece of code to invoke SPS API prior to 1.16 changes
		
	/*	((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		//Code prior to 1.16 standards		
		//Awaiting incoming requests to Get Software Product Status Api
		for(int i=1; i<=2; i++)
		{
			Thread.sleep(3000);
			driver.get("https://api.test.cts.cdr.gov.au/"+ConfromanceId+"/cts/register/cdr-register/v1/energy/data-recipients/brands/software-products/status");
			System.out.println("Iteration "+ i);
			Thread.sleep(3000);
		}
		
		driver.close();
		
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().window(SCWindow);
		driver.navigate().refresh();*/
			
		//WebElement continueTestExec = waitOnContinue.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue-test-execution-button")));

				
				
		Thread.sleep(5000);
		SCSPS.continueSPS();
		
		
		//Capture the full page screen 
		captureFullPageScreenshot("getSPSPolling");
		
		//Navigating back to the Scenarios Test Plan page
		SCSPS.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
		
	}

	//Method to run the Ensure Infosec Endpoints using MTLS
	private void invokeMTLS() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		selectScenario SCMTLS=new selectScenario(driver);
		
		SCMTLS.clickMTLS();
		Thread.sleep(2000);
		SCMTLS.reRunButton();
		Thread.sleep(3000);
		//Capture the full page screen 
		captureFullPageScreenshot("InfosecEndpointsMTLS");
				
		//Navigating back to the Scenarios Test Plan page
		SCMTLS.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");	
		
		
	}

	//Method to run the Holder of Key Scenario
	private void inovkeHOK() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		selectScenario SCHOK=new selectScenario(driver);

		logger.info("Ensure Holder Of Key For Resource Requests");
		SCHOK.clickHOK();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		SCHOK.reRunButton();
		
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		
		//Invoke the RMB to enter Customer Data
		invokeRMB();
		
		Thread.sleep(3000);
		//Capture the full page screen 
		captureFullPageScreenshot("HOKRequests");
		
		//Navigating back to the Scenarios Test Plan page
		SCHOK.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
	}
	
	
	//Method to run Ensure Client Assertion Data In Token Request scenario
	private void invokeECADTR() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		selectScenario ECADTR=new selectScenario(driver);

		logger.info("Ensure Client Assertion Data In Token Request");
		ECADTR.clickECADTR();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		ECADTR.reRunButton();
		JavascriptExecutor jsEOP = (JavascriptExecutor)driver;
		
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		
		//Invoke the RMB to enter Customer Data
		invokeRMB();
		
		Thread.sleep(3000);
		//Capture the full page screen 
		captureFullPageScreenshot("EnsureClientAssertionData");
		
		//Navigating back to the Scenarios Test Plan page
		ECADTR.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
		
	}

	//Method to run Ensure Client Assertion Data In Token Request scenario
	private void invokeAmendingCon() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		selectScenario DHAEC=new selectScenario(driver);

		logger.info("Selected Amending Existing Consent Scenario");
		DHAEC.clickAEC();
		
		Thread.sleep(2000);
		DHAEC.reRunButton();
		
		JavascriptExecutor jsEOP = (JavascriptExecutor)driver;
			
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
			
		//invoking the first polling point and click the continue button
		firstContinueButton();
		

		//Invoke the RMB to enter Customer Data
		invokeRMB();
		Thread.sleep(5000);
		
		//Invoke the RMB again
		invokeRMBAgain_AEC();
		Thread.sleep(5000);
		
		//Capture the full page screen 
		captureFullPageScreenshot("AmendingExistingConsent");
		
		//Navigating back to the Scenarios Test Plan page
		DHAEC.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");		
			
	}
	
	
	//Method to run the Removed Software Product Scenario
	private void invokeRSP()throws InterruptedException, IOException
	{
		selectScenario SCRSP=new selectScenario(driver);

		logger.info("Selected Removed SW Product");
		SCRSP.clickRSP();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		SCRSP.reRunButton();
		JavascriptExecutor jsEOP = (JavascriptExecutor)driver;
		
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		
		//Invoke the RMB to enter Customer Data
		invokeRMB();
		
		logger.info("Waiting for second set of polling");

		//Invoking the script to wait for the second continue button after the second poll
		secondContinueButton();
		
		Thread.sleep(3000);
		//Capture the full page screen 
		captureFullPageScreenshot("RemovedSWProduct");
		
		//Navigating back to the Scenarios Test Plan page
		SCRSP.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
		
	
	}

	//Method to run Data Holder Initiated Revocation - Not scripted. Manual execution
	private void invokeDHIR() throws InterruptedException {
		// TODO Auto-generated method stub
		selectScenario DHIR=new selectScenario(driver);

		logger.info("Selected DR holder Initiated  Revocation");
		DHIR.clickDHIR();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		DHIR.reRunButton();
	/*	JavascriptExecutor jsEOP = (JavascriptExecutor)driver;
		
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		
		//Invoke the RMB to enter Customer Data
		invokeRMB();*/
		
		Thread.sleep(5000);

		WebElement stepsTable = driver.findElement(By.xpath("//*[@id=\"log-container\"]/div/table/tbody"));
		
		List <WebElement> col = stepsTable.findElements(By.xpath("//*[@id=\"log-container\"]/div/table/thead/tr"));
		System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
			
		Thread.sleep(5000);
	}

	//Method to run Data Recipient  Initiated Token Revocation
	private void invokeDRITR() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
				selectScenario DRITR=new selectScenario(driver);

				logger.info("Selected DR Initiated Token Revocation");
				DRITR.clickDRITR();
				
				Thread.sleep(2000);
				//Clicking the rerun button to start the run
				DRITR.reRunButton();
				JavascriptExecutor jsEOP = (JavascriptExecutor)driver;
				
				logger.info("Clicked on reRun Button");
				logger.info("Waiting for polling to complete");
				
				//invoking the first polling point and click the continue button
				firstContinueButton();
				
				//Invoke the RMB to enter Customer Data
				invokeRMB();
				
				Thread.sleep(3000);
				//Capture the full page screen 
				captureFullPageScreenshot("DRInitiatedTokenRevoc");
				
				//Navigating back to the Scenarios Test Plan page
				DRITR.BackToTP();
				logger.info("Navigated back to Scenario Testplan Page");		
				
		
	}

	//Method to run Data Recipient Initiated Token Revocation
	private void invokeDRIR() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		selectScenario DRIR=new selectScenario(driver);

		logger.info("Selected Data Recipient Initiated Revocation");
		DRIR.clickDRIR();
		
		Thread.sleep(2000);
		//Clicking the rerun button to start the run
		DRIR.reRunButton();
		JavascriptExecutor jsEOP = (JavascriptExecutor)driver;
		
		logger.info("Clicked on reRun Button");
		logger.info("Waiting for polling to complete");
		
		//invoking the first polling point and click the continue button
		firstContinueButton();
		
		//Invoke the RMB to enter Customer Data
		invokeRMB();
		
		Thread.sleep(3000);
		//Capture the full page screen 
		captureFullPageScreenshot("DRInitiatedRevocation");
		
		//Navigating back to the Scenarios Test Plan page
		DRIR.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
		
		
	}

	//Method to invoke the Run Manual Browser Button
	private void invokeRMB() throws InterruptedException {
		// // TODO Auto-generated method stub
		
		String SCWindow=driver.getWindowHandle();
		
		//Explict wait until Secon Run Manual Browser link is displayed
		selectScenario SCRMB=new selectScenario(driver);
		WebDriverWait waitRMB=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement RMB = waitRMB.until(ExpectedConditions.visibilityOfElementLocated(By.id("run-manual-browser-step")));
		Thread.sleep(4000);
					
		//Clicking the run manual browser link to enter the Customer Details
		SCRMB.RunManualBrowserStep();
		logger.info("Clicked the Run Manual Browser Step");
		
		Set <String> Handles=driver.getWindowHandles();
		for(String i:Handles)
		{
			driver.switchTo().window(i);
			//System.out.println(driver.getTitle());
		}
		
		//Entering the customer details and confirming the data
		if(sector.equals("Energy"))
		{
			SCRMB.CustIdEnergy();
		}
		else
		{
			SCRMB.CustIdBanking();
		}
		logger.info("Customer Id Entered");
				
		SCRMB.CustIdContinue();
		logger.info("Clicked the continue button on Customer Id page");
		
		SCRMB.EnterOTP();
		logger.info("Valid OTP Entered");
		
		SCRMB.OTPContinue();
		logger.info("Clicked the continue button on OTP page");
		
		SCRMB.SelectAcc();
		logger.info("Selected an Account");
		
		SCRMB.AccContinue();
		logger.info("Clicked the continue button in Account page");
		
		SCRMB.iConfirm();
		logger.info("Clicked the iConfirm Button");
		WebElement AuthHandle = waitRMB.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/p")));
		Thread.sleep(3000);
		//Closing the customer page after the data entered is confirmed
		driver.close();
		
		//Switching back to Scenario run page
		driver.switchTo().window(SCWindow);
		logger.info("Switched to current Scenario running Page");
		
		
	}

	//Method to invoke the Second request of Run Manual Browser Button 
	public void invokeRMBAgain() throws InterruptedException
	{
		
		//Explicit wait until Run Manual Browser link is displayed
		selectScenario SCRMBAgain=new selectScenario(driver);
		WebDriverWait waitSRMBAgain=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement RMBAgain = waitSRMBAgain.until(ExpectedConditions.visibilityOfElementLocated(By.id("run-manual-browser-step")));
		
		Thread.sleep(4000);
		SCRMBAgain.RunManualBrowserStepAgain();
		
		Set <String> Handles=driver.getWindowHandles();
		for(String i:Handles)
		{
			driver.switchTo().window(i);
			//System.out.println(driver.getTitle());
		}
		
		WebElement AuthHandleAgain = waitSRMBAgain.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/p")));
		Thread.sleep(3000);
		
		//Closing the second Authorization page request
		driver.close();
		
	}
	
	//Method to process the first Continue button after the first set of Polling end points are run
	void firstContinueButton() throws InterruptedException
	{
		//Explicit wait until the Continue button is visible
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(80));
				WebElement ContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue-test-execution-button")));
						
				//Refreshing the page to avoid obsolete element error
				driver.navigate().refresh();
				Thread.sleep(5000);
				WebElement ContinueButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue-test-execution-button")));
						
				//Clicking the continue button using JavascriptExecutor
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", ContinueButton1);
				logger.info("Clicked continue after polling to completed");

	}
	
	//Method to process the second Continue button after Enter the customer data in Run Manual browser
	void secondContinueButton() throws InterruptedException
	{
		WebDriverWait SCBWait=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement SecondContinueButton = SCBWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[35]/td[2]/button")));
		
		//Finding the element to avoid obselete element error
		WebElement SecondContinueButton1 = SCBWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[35]/td[2]/button")));
				
		Thread.sleep(4000);
		SecondContinueButton1.click();
		
		logger.info("Clicked the Continue Button after polling");
		
		logger.info("Scenario Successfully Completed");
				
		//Waiting for the status message "Completed"
		WebDriverWait SCBWaitCompleted=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement Complete = SCBWaitCompleted.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/div/span[1]/span/strong")));
		Thread.sleep(2000);
		
	}

	
	//Method to run the Run Manual Browser button for Amending Existing Scenario ONLY
	private void invokeRMBAgain_AEC() throws InterruptedException {
		// TODO Auto-generated method stub
			
			String SCWindow=driver.getWindowHandle();	
			selectScenario SCRMBAgainAEC=new selectScenario(driver);
			
			//Explicit wait until Run Manual Browser link is displayed
			WebDriverWait waitSRMBAgainAEC=new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement RMBAgainAEC = waitSRMBAgainAEC.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[41]/td[2]/a")));

			SCRMBAgainAEC.RMBAEC();
			Thread.sleep(4000);
				
				Set <String> Handles=driver.getWindowHandles();
				for(String j:Handles)
				{
					driver.switchTo().window(j);
				}
	
				//Closing the second Authorization page request
				driver.close();
				driver.switchTo().window(SCWindow);
		
	}

	//Method to capture the Screen Shot for the Scenarios
	public void captureFullPageScreenshot(String SCName) throws IOException, InterruptedException 
	{
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\Users\\nagendra.venugopal\\ScreenShots\\"+SCName+".jpg"));
	    Thread.sleep(3000);
		logger.info("Captured the page level screenshot");
	}

}

	
	