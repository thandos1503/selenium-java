package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	
	private static String browser;
	private static String baseUrl;
	private static String gridValue;
	private static String browserType;
	private static String enviroment;
	private static String implicitWait;
	private static String os;
	private static String otp;
		
	public static void readPropertiesFile() {

		try {
			
			InputStream input = new FileInputStream("src\\test\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("Browser");
			baseUrl = prop.getProperty("BaseUrl");
			gridValue = prop.getProperty("GridValue");
			browserType = prop.getProperty("BrowserType");
			enviroment = prop.getProperty("Enviroment");
			implicitWait = prop.getProperty("ImplicitWait");
			os = prop.getProperty("os");
			otp = prop.getProperty("Otp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getBrowser()
	{
		//readPropertiesFile();
		//return browser;
		return System.getProperty("browser");
	}
	
	public static String getBaseUrl()
	{
		//readPropertiesFile();
		//return baseUrl;
		return System.getProperty("baseurl");
	}
	
	public static String getGridValue()
	{
		//readPropertiesFile();
		//return gridValue;
		return System.getProperty("gridvalue");
	}
	
	public static String getBrowserType()
	{
		//readPropertiesFile();
		//return browserType;
		return System.getProperty("browsertype");
	}
	
	public static String getEnviroment()
	{
		//readPropertiesFile();
		//return enviroment;
		return System.getProperty("enviroment");
	}
	
	public static String getImplicitWait()
	{
		//readPropertiesFile();
		//return implicitWait;
		return System.getProperty("implicitwait");
	}
	
	public static String getOs()
	{
		//readPropertiesFile();
		//return os;
		return System.getProperty("os");
	}
	
	public static String getOtp()
	{
		//readPropertiesFile();
		//return otp;
		return System.getProperty("otp");
	}
}
