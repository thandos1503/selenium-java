package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.PropertiesFile;

public class wait {

	public RemoteWebDriver _driver;
	WebDriverWait wait;
	
	public wait(RemoteWebDriver driver) {
		this._driver = driver;
	}
	
	public void waitForAwhile(int timeinseconds)
	{
		try {
			long timeInMilliseconds = timeinseconds * 1000;
			Thread.sleep(timeInMilliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean waitForElementToBeVisible(RemoteWebDriver driver, By elementLocation)
	{
		try {
			wait = new WebDriverWait(driver, Integer.parseInt(PropertiesFile.getImplicitWait()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean waitForElementToBeClickable(RemoteWebDriver driver, By elementLocation)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PropertiesFile.getImplicitWait())); 
            wait.until(ExpectedConditions.elementToBeClickable(elementLocation));
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void waitForPageLoaded(RemoteWebDriver driver) {
		
		wait = new WebDriverWait(driver, Integer.parseInt(PropertiesFile.getImplicitWait()));
		
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(RemoteWebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }

					@Override
					public Boolean apply(WebDriver input) {
						return null;
					}
                };
        try {
            Thread.sleep(1000);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
