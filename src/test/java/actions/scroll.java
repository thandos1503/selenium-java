package actions;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.remote.RemoteWebDriver;

public class scroll {

	public RemoteWebDriver _driver;
		
	public scroll(RemoteWebDriver driver) {
		this._driver = driver;
	}

	public void ScrollToElement(RemoteWebDriver driver, By elementLocation, @Nullable String testname) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", elementLocation);
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
	
	public void HoverOverElement(RemoteWebDriver driver, By elementLocation, @Nullable String testname)
	{
		try {
			
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, elementLocation);
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