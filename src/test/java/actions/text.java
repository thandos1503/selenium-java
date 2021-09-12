package actions;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class text {
	
	public wait aWait;
		
	public text(RemoteWebDriver driver) {
		aWait = new wait(driver);
	}
	
	public String readText(RemoteWebDriver driver, By elementLocation, @Nullable String testname) {
        try {
        	aWait.waitForElementToBeVisible(driver, elementLocation);
		}
		catch (Exception e)
		{
			if(testname.isEmpty())
        	{
        		testname = "Name not Specified";
        	}
        	System.out.println("Test : " + testname +" Failed due to " + e.getMessage());
		}
        return driver.findElement(elementLocation).getText();
    }
	
	public void writeText(RemoteWebDriver driver, By elementLocation, String text, @Nullable String testname) {
		try {
			aWait.waitForElementToBeVisible(driver, elementLocation);
			driver.findElement(elementLocation).sendKeys(text);
		}
		catch (Exception e)
		{
			if(testname.isEmpty())
        	{
        		testname = "Name not Specified";
        	}
        	System.out.println("Test : " + testname +" Failed due to " + e.getMessage());
		}
	}
}
