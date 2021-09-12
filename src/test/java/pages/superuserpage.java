package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import actions.find;
import actions.table;
import actions.wait;

public class superuserpage {

	private find aFind;
	private wait aWait;
	private table aTable;
	
	public superuserpage(RemoteWebDriver driver) {
	  aFind = new find(driver);
	  aWait = new wait(driver);
	  aTable = new table(driver);
    }
	
	By Table = By.id("example");
	By EditClick = By.xpath("//i[@class='fa fa-edit']");
	By BtnUpdate = By.cssSelector("#app > main > div > div > div > div > div > form:nth-child(2) > div:nth-child(5) > button");
	By ResetSurvey = By.cssSelector("#app > main > div > div > div > div > div > form:nth-child(3) > div > label");
	By CheckBoxReset = By.cssSelector("#app > main > div > div > div > div > div > form:nth-child(3) > div > div > label:nth-child(17) > input[type=checkbox]");
	By BtnReset = By.cssSelector("#app > main > div > div > div > div > div > form:nth-child(3) > div > div > button");
	By SelectEntity = By.cssSelector("#app > main > div > div > div > div > div > form > div:nth-child(6) > div > span > div > button");
	By SelectGroup = By.cssSelector("#groupName");
	By BtnRepsonsibleUpdate = By.cssSelector("#app > main > div > div > div > div > div > form > div:nth-child(8) > button");

	
	public void ValidateTest4Entity(RemoteWebDriver driver, String testname)
	{
		
		if (!aTable.TableItemExists(driver, Table, "Test_Automation_User"))
		{
			Assert.fail("Entity Does not exists, Please investigate");
		}
 	 }
	
	public void ClickEditEntity(RemoteWebDriver driver, String testname)
	{
		WebElement returnValue = null;
		
		returnValue = aTable.Table(driver, Table, "Test_Automation_User", EditClick);
		returnValue.click();
		
		ValidateEntityUpdate(driver, testname);
	}
	
	private void ValidateEntityUpdate(RemoteWebDriver driver, String testname)
	{
		aWait.waitForElementToBeVisible(driver, BtnUpdate);
		LoggedInElementFind(driver, BtnUpdate, testname);
		LoggedInElementFind(driver, ResetSurvey, testname);
		LoggedInElementFind(driver, CheckBoxReset, testname);
		LoggedInElementFind(driver, BtnReset, testname);
	}
	
	public void ValidateTest4RespinsibleUser(RemoteWebDriver driver, String testname)
	{
		if (!aTable.TableItemExists(driver, Table, "Automation_User"))
		{
			Assert.fail("Entity Does not exists, Please investigate");
		}
	}
	
	public void ClickEditResponsibleUser(RemoteWebDriver driver, String testname)
	{
		WebElement returnValue = null;
		
		returnValue = aTable.Table(driver, Table, "Automation_User", EditClick);
		returnValue.click();
		
		ValidateResponsibleUpdate(driver, testname);
	}
	
	private void ValidateResponsibleUpdate(RemoteWebDriver driver, String testname)
	{
		aWait.waitForElementToBeVisible(driver, SelectEntity);
		LoggedInElementFind(driver, SelectEntity, testname);
		LoggedInElementFind(driver, SelectGroup, testname);
		LoggedInElementFind(driver, BtnRepsonsibleUpdate, testname);
	}
	
	private void LoggedInElementFind(RemoteWebDriver driver, By element, String testname)
	{
		aFind.ElementExists(driver, element, testname);
	}
}
