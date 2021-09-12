package tests;

import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class SuperUserTest extends BaseClass{
	
	public SuperUserTest() 
	{
		home = new homepage(_driver);
	}
		
	@Test
	public void TestEntityExists()
	{
		try {
			home.loginUser(_driver, "TestEntityExists", su_email)
			.Entitypage(_driver, "TestEntityExists")
			.ValidateTest4Entity(_driver, "TestEntityExists");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestEntitySettingsExists()
	{
		try {
			home.loginUser(_driver, "TestEntitysettingsExists", su_email)
			.Entitypage(_driver, "TestEntitysettingsExists")
			.ClickEditEntity(_driver, "TestEntitysettingsExists");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestResponsibleUserExists()
	{
		try {
			home.loginUser(_driver, "TestResponsibleUserExists", su_email)
			.Responsiblepage(_driver, "TestResponsibleUserExists")
			.ValidateTest4RespinsibleUser(_driver, "TestResponsibleUserExists");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestResponsibleUserSettingsExists()
	{
		try {
			home.loginUser(_driver, "TestResponsibleUserSettingsExists", su_email)
			.Responsiblepage(_driver, "TestResponsibleUserSettingsExists")
			.ClickEditResponsibleUser(_driver, "TestResponsibleUserSettingsExists");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
