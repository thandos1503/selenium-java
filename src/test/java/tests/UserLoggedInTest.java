package tests;
 
import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class UserLoggedInTest extends BaseClass{
	
	public UserLoggedInTest()
	{
		home = new homepage(_driver);
	}
	
	@Test
	public void ToBeReviewedTable()
	{
		try {
			home.loginUser(_driver, "ToBeReviewedTable", ra_email)
			.TobeReviewTable(_driver, "ToBeReviewedTable");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void CompletedTable()
	{
		try {
			home.loginUser(_driver, "CompletedTable", ra_email)
			.CompletedTable(_driver, "CompletedTable");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void CurrentTable()
	{
		try {
			home.loginUser(_driver, "CurrentTable", ra_email)
			.CompletedTable(_driver, "CurrentTable");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
