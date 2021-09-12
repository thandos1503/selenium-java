package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.click;
import actions.find;
import actions.text;
import actions.wait;
import config.PropertiesFile;
import custom.gmailApi;

public class homepage{
	private text aText;
	private click aClick;
	private wait aWait;
	private find aFind;

	public homepage(RemoteWebDriver driver) {
		aText = new text(driver);
		aClick = new click(driver);
		aWait = new wait(driver);
		aFind = new find(driver);
	  }
	
	//Elements
	By LoginEmail = By.xpath("//input[@id='email']");
	By NextButton = By.xpath("//button[@type='submit'and @class='btn login-btn mt-3']");
	By Otp = By.xpath("//input[@id='otp_val']");
	By SubmitOtp = By.xpath("//button[@id='submit_otp']");
	By UserSection = By.cssSelector("#dropdownMenuButton");
	By LoginText = By.xpath("//h3[text()='Login']");
		
	public loggedinpage loginUser(RemoteWebDriver driver, String testname, String email) throws InterruptedException
	{
		try 
		{
			aWait.waitForElementToBeVisible(driver, LoginEmail);
			enterTextHomePageElement(driver, LoginEmail, email, testname);
			clickHomePageElement(driver, NextButton, testname);
			aWait.waitForElementToBeVisible(driver, Otp);
			if (PropertiesFile.getOtp().equals("yes"))
			{
				aWait.waitForAwhile(10);
    			enterTextHomePageElement(driver, Otp, gmailApi.getEmailOTP(), testname);
			}
    		else
    		{
				enterTextHomePageElement(driver, Otp, "24680", testname);
    		}
			
			clickHomePageElement(driver, SubmitOtp, testname);
		}
		catch(Exception e) {
			
		}
		return new loggedinpage(driver);
	}
	
	public void ValidateLoggedOutState(RemoteWebDriver driver, String testname)
	{
		elementsExists(driver, LoginText, testname);
		elementsExists(driver, LoginEmail, testname);
		elementsExists(driver, NextButton, testname);
	}
		
	private void elementsExists(RemoteWebDriver driver, By element, String testname)
	{
		aFind.ElementExists(driver, element, testname);
	}
	
	private void clickHomePageElement(RemoteWebDriver driver, By element, String testname)
	{
		aClick.Click(driver, element, testname);
	}
	
	private void enterTextHomePageElement(RemoteWebDriver driver, By element, String text, String testname)
	{
		aText.writeText(driver, element, text, testname);
	}
}
