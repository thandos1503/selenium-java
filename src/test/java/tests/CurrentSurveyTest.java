package tests;

import org.testng.annotations.Test;

import browser.BaseClass;
import pages.startedsurveypape;
import pages.homepage;

public class CurrentSurveyTest extends BaseClass {
	
	public CurrentSurveyTest()
	{
		home = new homepage(_driver);
		startedsurvey = new startedsurveypape(_driver);
	}
	
	@Test
	public void ValidateStartSurvey()
	{
		try {
			home.loginUser(_driver, "ValidateStartSurvey", ra_email)
			.ClickCurrentSurveyStart(_driver, "ValidateStartSurvey");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	@Test
	public void ValidateSurveyStarted()
	{
		try {
			home.loginUser(_driver, "ValidateSurveyStarted", ra_email)
			.ClickCurrentSurveyStart(_driver, "ValidateSurveyStarted");
			
			startedsurvey.ValidateOnPreSurveyStarted(_driver, "ValidateSurveyStarted");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
