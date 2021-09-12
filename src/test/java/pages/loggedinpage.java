package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.find;
import actions.click;
import actions.table;

public class loggedinpage {

	public RemoteWebDriver _driver;
	private find aFind;
	private click aClick;
	private table aTable;
	private WebElement _element = null;
		
	public loggedinpage(RemoteWebDriver driver) {
	  this._driver = driver;
	  aFind = new find(driver);
	  aClick = new click(driver);
	  aTable = new table(driver);
    }
		
	By UserSection = By.cssSelector("#dropdownMenuButton");
	By TableToBeReviewed = By.partialLinkText("To be reviewed:");
	By TableCompleted = By.xpath("//a[contains(text(),'Completed:')]");
	By TableCurrentSurvey = By.partialLinkText("Current Survey:");
	By WelcomeBack = By.cssSelector("body > div > section > div > div.Dashboard-content1 > div > div.user-title-text > h3");
	By StartCurrentSurvey =By.cssSelector("#currentSur > tbody > tr:nth-child(1) > td.start_btn1 > div > a");
	By ToBeReviewsSurveyStart = By.cssSelector("#reviewedtable > tbody > tr.odd > td:nth-child(5) > div > a");
	By CompletedSurveyStart = By.cssSelector("#Completedtable > tbody > tr:nth-child(1) > td.start_btn3 > div > a");
	By Entity = By.cssSelector("body > div > div > div > div.col-md-3 > div > div.card-body > ul > li:nth-child(3) > a");
	By ResponsibleUser = By.cssSelector("body > div > div > div > div.col-md-3 > div > div.card-body > ul > li:nth-child(1) > ul > li:nth-child(3) > a"); 
		
	
	//Update for test
	By Table = By.id("currentSur");
	By StartCurrSurvey = By.xpath("//td[@class='start_btn1']");
	
	
	public void TobeReviewTable(RemoteWebDriver driver, String testname) throws InterruptedException
	{
		LoggedInElementFind(driver,TableToBeReviewed, testname);
	}
	
	public void CompletedTable(RemoteWebDriver driver, String testname) throws InterruptedException
	{
		LoggedInElementFind(driver, TableCompleted, testname);
	}
	
	public void CurrentServeyTable(RemoteWebDriver driver, String testname) throws InterruptedException
	{
		LoggedInElementFind(driver, TableCurrentSurvey, testname);
	}
	
	public currentsurveypage ClickCurrentSurveyStart(RemoteWebDriver driver, String testname) throws InterruptedException
	{
		LoggedInElementFind(driver,StartCurrentSurvey, testname);
		aClick.Click(driver, StartCurrentSurvey, testname);
		
		return new currentsurveypage(_driver);
	}
	
	public tobereviewedsurveypage ClickToBereviewedSurveyStart(RemoteWebDriver driver, String testname) throws InterruptedException
	{
		LoggedInElementFind(driver,ToBeReviewsSurveyStart, testname);
		aClick.Click(driver, ToBeReviewsSurveyStart, testname);
		
		return new tobereviewedsurveypage(_driver);
	}
	
	public completedsurveypage ClickCompletedSurveyStart(RemoteWebDriver driver, String testname) throws InterruptedException
	{
		LoggedInElementFind(driver,CompletedSurveyStart, testname);
		aClick.Click(driver, CompletedSurveyStart, testname);
		
		return new completedsurveypage(_driver);
	}
	
	public superuserpage Entitypage(RemoteWebDriver driver, String testname) throws InterruptedException {
		
		LoggedInElementFind(driver,Entity, testname);
		aClick.Click(driver, Entity, testname);
		
		return new superuserpage(_driver);
	}
	
	public superuserpage Responsiblepage(RemoteWebDriver driver, String testname) throws InterruptedException {
		
		LoggedInElementFind(driver, ResponsibleUser, testname);
		aClick.Click(driver, ResponsibleUser, testname);
		
		return new superuserpage(_driver);
	}
		
	private void LoggedInElementFind(RemoteWebDriver driver, By element, String testname)
	{
		aFind.ElementExists(driver, element, testname);
	}
	
	public void VerifyLoggedIn(RemoteWebDriver driver, String testname)
	{
		aFind.ElementExists(driver, WelcomeBack, testname);
	}
}
