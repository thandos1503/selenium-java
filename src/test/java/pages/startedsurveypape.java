package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.find;
import actions.wait;

public class startedsurveypape {
	
	public RemoteWebDriver _driver;
	private find aFind;
	private wait aWait;
	
	public startedsurveypape(RemoteWebDriver driver) {
		this._driver = driver;
		aFind = new find(driver);
		aWait = new wait(driver);
    }
	
	By StartedSurveyHeading = By.cssSelector("#surveyElement > div > form > div.sv-container-modern > div.sv-title.sv-container-modern__title > div > h3 > span");
	By StartedSurveySubHeading = By.cssSelector("#sp_100 > div > h4 > span");
	
	public void ValidateOnPreSurveyStarted(RemoteWebDriver driver, String testname)
	{
		aWait.waitForElementToBeVisible(driver, StartedSurveyHeading);
		LoggedInElementFind(driver, StartedSurveyHeading, testname);
		LoggedInElementFind(driver, StartedSurveySubHeading, testname);
	}
	
	private void LoggedInElementFind(RemoteWebDriver driver, By element, String testname)
	{
		aFind.ElementExists(driver, element, testname);
	}
	
}
