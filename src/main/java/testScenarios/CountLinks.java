package testScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CountLinks {
	@Test
	public void googleLinkCount()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		//Find all Anchor tags
		List<WebElement> links=driver.findElements(By.tagName("a"));
		//count links
		System.out.println("total number of links="+links.size());
		//count only visible links
		int visiblelinks=0;
		for(WebElement link:links)
		{
			if(link.isDisplayed())
			{
				visiblelinks++;
			}
		}
		System.out.println("Total number of Visible links="+visiblelinks);
		//print all link names
		for(WebElement link:links)
		{
			if(link.isDisplayed())
			{
				System.out.println(link.getText());
			}
		}
		
		driver.quit();	
	}
}
