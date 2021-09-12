package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class currentsurveypage {

	public currentsurveypage(RemoteWebDriver driver) {
    }
	
	By StartSurveyV = By.cssSelector("body > div.main-wraper > div > div > div > a");
	By SurveyVHeading = By.xpath("//h3[text()='Vulnerability Management']");
}


