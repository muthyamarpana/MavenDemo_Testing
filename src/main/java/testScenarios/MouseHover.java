package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {

	@Test
	public void dragAndDrop() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();

		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void radAndChkBox() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		WebElement radBMW=driver.findElement(By.id("bmwradio"));
		WebElement chkBenz=driver.findElement(By.id("benzcheck"));
		WebElement chkHonda=driver.findElement(By.id("hondacheck"));
		radBMW.click();

		chkBenz.click();
		chkHonda.click();

		if(radBMW.isSelected())
		{
			System.out.println("BMW Radio button is selected...");
		}
		else
		{
			System.out.println("BMW Radio button is not selected...");
		}

		if(chkBenz.isSelected() && chkHonda.isSelected())
		{
			System.out.println("Benz and Honda are selected...");
		}
		else
		{
			System.out.println("Benz and Honda are not selected...");
		}

		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void selDate() throws InterruptedException
	{
		//04/01/2027
		Integer exp_yr=2027;
		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		while(true)
		{
			String act_month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String act_year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
			if(act_year.equals(String.valueOf(exp_yr)) && act_month.equals("April"))
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[5]/a")).click();
				break;
			}
			if(exp_yr<2026)
			{
				//click on previous button
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
			}
			else
			{
				//click on next button
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}
			
		}

		Thread.sleep(3000);
		driver.quit();
	}
}
