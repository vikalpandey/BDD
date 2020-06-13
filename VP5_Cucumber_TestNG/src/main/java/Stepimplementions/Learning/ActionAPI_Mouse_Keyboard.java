package Stepimplementions.Learning;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Stepimplementions.Ann_Add_Announcement;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Common;
import Util.TestBase;

public class ActionAPI_Mouse_Keyboard extends TestBase{
	
		
			LoginPage_steps lpobj=new LoginPage_steps();
			Goto go=new Goto();
			
			@Test
			public void Testmethod() throws Exception {
				TestBase.initialization();		
				try {
					log.info("log.info in test class");
					System.out.println("Test start");
					//GoogleWay2automation();
					driver.get("http://www.way2automation.com/");
					Actions action=new Actions(driver);
					WebElement mainmenu= driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
					//WebElement submenu= driver.findElement(By.xpath("//a[contains(text(),'Practice site 1')]"));
					action.moveToElement(mainmenu);  // This will not directly execute
					action.moveToElement(mainmenu).perform(); // now it will mouse over the manin menuelemen 
					driver.findElement(By.xpath("//a[contains(text(),'Practice site 1')]")).click();
					Thread.sleep(3000);
					driver.navigate().back();
					Thread.sleep(3000);
					WebElement mainmenu2= driver.findElement(By.xpath("//a[contains(text(),'VIDEO TUTORIALS')]"));
					action.moveToElement(mainmenu2).build().perform();
					Thread.sleep(3000);
					
			
					
					
					
					
					
					
					//a[contains(text(),'Practice site 1')]
					

					

					

					
			
					
					
					
					
					
				
				} finally {
					Thread.sleep(1000);
					driver.quit();
					log.info("driver.quit Done ");
				}	}
			//........Other methods write here .........

			

			
			public void GoogleWay2automation() 
			{
				System.out.println("Google search start");
				driver.get("https://www.google.co.in/");
				driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("way2automation");
				driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
				//By firstsearchlink=By.xpath("//div[@id='rso']/div[1]//a[@href='http://www.way2automation.com/']");
				By firstsearchlink=By.xpath("//div[@id='rso']/div[1]//a//*[contains(text(),'Way2Automation')]");
				try {
					Common.waitForElementtobeclickable(driver, firstsearchlink);
				} catch (Exception e) {
					System.out.println("Element not clickable " + firstsearchlink);
					e.printStackTrace();
				}
				driver.findElement(firstsearchlink).click();
				System.out.println("first searched link clicked");
				//Common.waitForLoad(driver);
				//Common.waitForPageLoaded(driver);
				
				System.out.println(driver.getTitle());
				String title=driver.getTitle();
				Assert.assertEquals(title, "Selenium Training By Rahul Arora |Best Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
				
				System.out.println("---Common classwithfor pagettle method start ");
				String wtitle=Common.waitForPageTitle(driver, "Selenium Training By Rahul Arora |Best Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
				System.out.println("=> waitForPageTitle method return string = "+ wtitle);
				System.out.println("---Common classwithfor pagettle method  End ");
				
				String ctitle=Common.getTitleByJS();
				System.out.println("=> common class gettitle byjs = "+ctitle);
				
			}
			
			
			
			

			
		}

		
		
		
		
		
		
		
		
		


