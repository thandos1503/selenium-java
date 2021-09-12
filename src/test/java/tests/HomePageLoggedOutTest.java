package tests;

import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class HomePageLoggedOutTest extends BaseClass{
	
	public HomePageLoggedOutTest()
	{
		home = new homepage(_driver);
	}

	@Test
	public void HomePageOpens()
	{
		try {
			home.ValidateLoggedOutState(_driver, "HomePageOpens");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
