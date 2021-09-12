package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.find;

public class tobereviewedsurveypage {

	private find aFind;
	
	public tobereviewedsurveypage(RemoteWebDriver driver) {
	  aFind = new find(driver);
    }
	
	By NONCompliant = By.id("noCompId");
	By ReportNoChanges = By.cssSelector("#devel-generate-content-form > div > div.row.mt-4 > div:nth-child(2) > div > a");
	By Score = By.xpath("//td//div[text()='4'][1]");
	By Potential = By.xpath("//td//div[text()='0'][1]");
	
	public void ReportNoChangesExists(RemoteWebDriver driver, String testname)
	{
		aFind.ElementExists(driver, ReportNoChanges, testname);
	}
	
	public void ValidateNONCommpliantExists(RemoteWebDriver driver, String testname)
	{
		aFind.ElementExists(driver, NONCompliant, testname);
	}
	
	public void ValidateScoresAreCorrect(RemoteWebDriver driver, String testname)
	{
		aFind.ElementExists(driver, Score, testname);
		aFind.ElementExists(driver, Potential, testname);
	}
}
