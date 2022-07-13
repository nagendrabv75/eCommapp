package com.DHFAPIV4.testCases;

import org.testng.annotations.Test;

import com.DHFAPIV4.pageObjects.LoginPage;
import com.DHFAPIV4.pageObjects.selectScenario;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EnergyV4 extends baseClass {
	
		
	//Login and Navigate to CTS Participant Portal Home Page
	@Test(priority=1)
	public void loginPageMethod() throws InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("Launched the Page");
			
		LoginPage LP=new LoginPage(driver);
		
		//Enter the email/username
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
		Thread.sleep(5000);
		logger.info("Successfully Authenticated using Authenticator");
				
		String Title= driver.getTitle();
			
		if (Title.equals("Conformance Test Suite - Test Plans"))
		{
			logger.info(("Launched CTS Participant Portal"));
			
		}
		Thread.sleep(3000);
		
	
		//LP.clickLogout();
		//logger.info("Successfully Logged out");
		
	}
	
	//Select and run the scenario Removed SW Product
	@Test(priority=2)
	public void selectScenarios() throws InterruptedException, IOException
	{
		
		selectScenario SC=new selectScenario(driver);
		SC.clickRSP();
		logger.info("Selected Removed SW product Scenario");
		Thread.sleep(2000);
		String SCWindow=driver.getWindowHandle();
		
		SC.reRunButton();
		logger.info("Clicked on reRun Button");
		
		logger.info("Waiting for polling to complete");
		
		JavascriptExecutor EOPage = (JavascriptExecutor) driver;
		EOPage.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement FirstContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[12]/td[2]/button")));
				
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		WebElement FirstContinueButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[12]/td[2]/button")));
				
		
		//FirstContinueButton1.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", FirstContinueButton1);
		logger.info("Clicked continue after polling to completed");
		Thread.sleep(10000);
			
		SC.RunManualBrowserStep();
		logger.info("Clicked the Run Manual Browser Step");
		
		Set <String> Handles=driver.getWindowHandles();
		for(String i:Handles)
		{
			driver.switchTo().window(i);
			//System.out.println(driver.getTitle());
		}
			
		SC.CustId();
		logger.info("Customer Id Entered");
				
		SC.CustIdContinue();
		logger.info("Clicked the continue button on Customer Id page");
		
		SC.EnterOTP();
		logger.info("Valid OTP Entered");
		
		SC.OTPContinue();
		logger.info("Clicked the continue button on OTP page");
		
		SC.SelectAcc();
		logger.info("Selected an Account");
		
		SC.AccContinue();
		logger.info("Clicked the continue button in Account page");
		
		
		SC.iConfirm();
		logger.info("Clicked the iConfirm Button");
		Thread.sleep(5000);
		driver.close();
		
		driver.switchTo().window(SCWindow);
		logger.info("Switched to Scenario Page");
		logger.info("Waiting for second set of polling");
		EOPage.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			

		
		WebDriverWait waitagain=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement SecondContinueButton = waitagain.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[35]/td[2]/button")));
		
		Thread.sleep(4000);
		WebElement SecondContinueButton1 = waitagain.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[4]/div[2]/div/table/tbody/tr[35]/td[2]/button")));
				
		SecondContinueButton1.click();
		
		logger.info("Clicked the Continue Button after polling");
		
		logger.info("Scenario Successfully Completed");
		Thread.sleep(5000);
		
		WebDriverWait Completed=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement Complete = Completed.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/div/span[1]/span/strong")));
		Thread.sleep(5000);
		
		captureFullPageScreenshot();
		
		SC.BackToTP();
		logger.info("Navigated back to Scenario Testplan Page");
		
	
	}
	
	public void captureFullPageScreenshot() throws IOException, InterruptedException {
	 
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\Users\\nagendra.venugopal\\ScreenShots\\RSP.jpg"));
	    Thread.sleep(10000);
		
	}
	
			
	
}
