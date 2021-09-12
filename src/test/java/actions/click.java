package actions;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class click {
	
	
	private wait aWait;
	
	public click(RemoteWebDriver driver) {
	
		aWait = new wait(driver);
	}

	public void Click(RemoteWebDriver driver, By elementLocation, @Nullable String testname) {
       try {
     	aWait.waitForElementToBeVisible(driver, elementLocation);
        	WebElement element = driver.findElement(elementLocation);
        	
        	javaclick(driver, element);
        }
        catch(Exception e)
        {
        	if(testname.isEmpty())
        	{
        		testname = "Name not Specified";
        	}
        	System.out.println("Test : " + testname +" Failed due to " + e.getMessage());
        	org.testng.Assert.fail();
        }
    }
	
	public void Click_Java(RemoteWebDriver driver, By elementLocation, @Nullable String testname) {
	       try {
	    	   javaclick(driver, elementLocation);
	        }
	        catch(Exception e)
	        {
	        	if(testname.isEmpty())
	        	{
	        		testname = "Name not Specified";
	        	}
	        	System.out.println("Test : " + testname +" Failed due to " + e.getMessage());
	        	org.testng.Assert.fail();
	        }
	    }
	
	private void javaclick(RemoteWebDriver driver, By elementLocation)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", elementLocation);
	}
	
	private void javaclick(RemoteWebDriver driver, WebElement elementLocation)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", elementLocation);
	}
	
}
