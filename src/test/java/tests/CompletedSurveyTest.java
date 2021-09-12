package tests;

import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class CompletedSurveyTest extends BaseClass{
	
	public CompletedSurveyTest()
	{
		home = new homepage(_driver);
	}
	
	@Test
	public void ValidateCompletedSurvey()
	{
		try {
			home.loginUser(_driver, "ValidateCompletedSurvey", ra_email)
			.ClickCompletedSurveyStart(_driver, "ValidateCompletedSurvey");		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidateCompletedScore()
	{
		try {
			home.loginUser(_driver, "ValidateCompletedScore", ra_email)
			.ClickCompletedSurveyStart(_driver, "ValidateCompletedScore")
			.ValidateScoreAppears(_driver, "ValidateCompletedScore");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
