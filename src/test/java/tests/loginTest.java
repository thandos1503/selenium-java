package tests;

import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class loginTest extends BaseClass {
	
	public loginTest() throws Exception
	{
		home = new homepage(_driver);
	}
	
	@Test
	public void TestUserCanLogin()
	{
		try {
			home.loginUser(_driver, "TestUserCanLogin", ra_email)
			.VerifyLoggedIn(_driver, "TestUserCanLogin");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
