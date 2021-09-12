package browser;


import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.PropertiesFile;
import pages.homepage;
import pages.startedsurveypape;

import java.net.URL;

public class BaseClass {
	
	public homepage home;
	public startedsurveypape startedsurvey;
	
	public String ra_email = "ra_automation@rapidassurance.ai";
	public String su_email = "Luthando@rapidassurance.ai";

	public RemoteWebDriver _driver;
	
	@BeforeMethod
	public void setup() {
			
		String browserType = PropertiesFile.getBrowserType();
		String browser = PropertiesFile.getBrowser();
		String baseurl = PropertiesFile.getBaseUrl();
		String gridvalue = PropertiesFile.getGridValue();
		String os = PropertiesFile.getOs();
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
		
			if (browserType.equals("chromebrowser")) {
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-gpu");
				options.addArguments("disable-infobars");
				options.setAcceptInsecureCerts(true);
				
				caps.setBrowserName(browser);
				
				if(os.equals("windows"))
				{
					caps.setPlatform(Platform.WINDOWS);
				}
				else if (os.equals("linux"))
				{
					caps.setPlatform(Platform.LINUX);
				}
								
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				
				_driver = new RemoteWebDriver(new URL(gridvalue), caps);
			}
			else if (browserType.equals("DesktopMobileEmulator")) {
			}
			else if (browserType.equals("localdriver")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				_driver = new ChromeDriver();
			}
			
			_driver.get(baseurl);		
			_driver.manage().window().maximize();
			
		}catch(Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
		}

	}

	@AfterMethod
	public void MethodTearDown()
	{
		try {
			_driver.quit();
		}
		catch(Exception ignore)
		{
			_driver =null;
		}
	}
}
