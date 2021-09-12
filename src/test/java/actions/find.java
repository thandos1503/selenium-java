package actions;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class find {

	public RemoteWebDriver _driver;
	private wait aWait;
	
	public find(RemoteWebDriver driver) {
		this._driver = driver;
		aWait = new wait(driver);
	}
	
	public void ElementExists(RemoteWebDriver driver, By elementLocation, @Nullable String testname) {
    try {
    		aWait.waitForElementToBeVisible(driver, elementLocation);
        	driver.findElement(elementLocation);
        } catch (Exception e) {
        	
        	if(testname.isEmpty())
        	{
        		testname = "Name not Specified";
        	}
        	System.out.println("Test : " + testname +" Failed due to " + e.getMessage());
        	org.testng.Assert.fail(testname + " Failed, please investigate");
            Assert.fail();
        }
    }
}
