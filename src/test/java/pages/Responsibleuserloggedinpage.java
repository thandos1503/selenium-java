package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.click;
import actions.scroll;
import browser.BaseClass;

public class Responsibleuserloggedinpage extends BaseClass{

	public RemoteWebDriver _driver;
	private scroll aScroll;
	private click aClick;
	
	
	public Responsibleuserloggedinpage(RemoteWebDriver driver)
	{
		this._driver = driver;
		aScroll = new scroll(driver);
		aClick = new click(driver);
	}
	
	By startElement = By.cssSelector("#reviewedtable > tbody > tr > td.start_btn1 > div > a");
	
	public void clickStartToBeReviewed(RemoteWebDriver driver)
	{
		//aScroll.ScrollBy(driver);
		//aClick.Click(driver, startElement);
	}
	
	
}
