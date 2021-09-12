package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import actions.find;
import actions.wait;
import actions.table;

public class completedsurveypage {

	private find aFind;
	private wait aWait;
	private table aTable;
	private WebElement _element = null;
	
	public completedsurveypage(RemoteWebDriver driver) {
	  aFind = new find(driver);
	  aWait = new wait(driver);
	  aTable = new table(driver);
    }
	
	By ReviewComplete = By.cssSelector("body > div > section > div > div.panel-box > div.review_compt > p");
	By TableSubmission = By.id("Your_submission");
	By ElementFind = By.xpath("//td[@class='reviewed_Data score_data']");
	
	public void ValidateCompletedSurvey(RemoteWebDriver driver, String testname)
	{
		aWait.waitForElementToBeVisible(driver, ReviewComplete);
		LoggedInElementFind(driver, ReviewComplete, testname);
	}
	
	
	public void ValidateScoreAppears(RemoteWebDriver driver, String testname)
	{
		_element = aTable.Table(driver, TableSubmission, "How many Factors of Authentication do you use?", ElementFind);
		
		if (!_element.getText().contains("14"))
		{
			Assert.fail();
		}
		
	}
	
	private void LoggedInElementFind(RemoteWebDriver driver, By element, String testname)
	{
		aFind.ElementExists(driver, element, testname);
	}
}
