package actions;

import java.util.List;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class table {

	private wait aWait;
	
	public table(RemoteWebDriver driver) {
		aWait = new wait(driver);
	}
	
	public WebElement Table(RemoteWebDriver driver, By element, String content, By elementClick)
	{
		WebElement Table = driver.findElement(element);

		List<WebElement> Rows = Table.findElements(By.tagName("tr"));
			
		int num = 0;
		for (WebElement elemRow : Rows)
		{
			num = num + 1;
			if (elemRow.getText().contains(content))
			{
				List<WebElement> a = elemRow.findElements(elementClick);
				aWait.waitForAwhile(1);
				WebElement i = a.get(num - 2);
			
				return i;
			}
		}
		return null;
	}
	
	public WebElement TableUsers(RemoteWebDriver driver, By element, String content, By elementClick)
	{
		WebElement Table = driver.findElement(element);

		List<WebElement> Rows = Table.findElements(By.tagName("tr"));
			
		int num = 0;
		for (WebElement elemRow : Rows)
		{
			System.out.print(elemRow.getText() + "\t");
			num = num + 1;
			if (elemRow.getText().contains(content))
			{
				List<WebElement> a = elemRow.findElements(elementClick);
				aWait.waitForAwhile(1);
				WebElement i = a.get(num);
			
				return i;
			}
		}
		return null;
	}
	
	public boolean TableItemExists(RemoteWebDriver driver, By element, String content)
	{
		WebElement Table = driver.findElement(element);

		List<WebElement> Rows = Table.findElements(By.tagName("tr"));
			
		for (WebElement elemRow : Rows)
		{
			if (elemRow.getText().contains(content))
			{
				return true;
			}
		}
		return false;
	}
	
}
