package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SwitchingWin {

	@Test
	public void switchPage()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		//getWindowHandle()-- is a method used to get the current window id
		//getWindowHandles()-- is a method used to get all the window ids opened by the driver object.

		Set<String> winIds=driver.getWindowHandles();
		//count no. of windows
		System.out.println("Total windows opened="+winIds.size());  //2
		String win1=null;
		String win2=null;
		Iterator<String> itr = winIds.iterator();
		win1=itr.next();
		win2=itr.next();
		System.out.println("Window1 id="+win1);
		System.out.println("Window2 id="+win2);
		System.out.println("Window1 Title="+driver.getTitle());
		if(driver.getTitle().equals("W3Schools Tryit Editor"))
		{
			System.out.println("title matched...");
			Reporter.log("title matched...");
		}
		driver.switchTo().window(win2);
		System.out.println("Window2 Title="+driver.getTitle());
		if(driver.findElement(By.id("tnb-login-btn")).isEnabled())
		{
			System.out.println("Signin button is enabled...");
			Reporter.log("Sign in button is enabled...");
		}


		driver.quit();
	}
}
