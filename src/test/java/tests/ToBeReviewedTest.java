package tests;

import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class ToBeReviewedTest extends BaseClass{
	
	public ToBeReviewedTest()
	{
		home = new homepage(_driver);
	}
	
	@Test
	public void ValidateNoChangeOnToBeReviewedSurvey()
	{
		try {
			home.loginUser(_driver, "ValidateNoChangeOnToBeReviewedSurvey", ra_email)
			.ClickToBereviewedSurveyStart(_driver, "ValidateNoChangeOnToBeReviewedSurvey")
			.ReportNoChangesExists(_driver, "ValidateNoChangeOnToBeReviewedSurvey");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidateNonComplianceOnToBeReviewedSurvey()
	{
		try {
			home.loginUser(_driver, "ValidateNonComplianceOnToBeReviewedSurvey", ra_email)
			.ClickToBereviewedSurveyStart(_driver, "ValidateNonComplianceOnToBeReviewedSurvey")
			.ValidateNONCommpliantExists(_driver, "ValidateNonComplianceOnToBeReviewedSurvey");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidateScoreOnToBeReviewedSurvey()
	{
		try {
			home.loginUser(_driver, "ValidateScoreOnToBeReviewedSurvey", ra_email)
			.ClickToBereviewedSurveyStart(_driver, "ValidateScoreOnToBeReviewedSurvey")
			.ValidateScoresAreCorrect(_driver, "ValidateScoreOnToBeReviewedSurvey");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
