package Stepimplementions.Learning;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import Stepimplementions.Ann_Add_Announcement;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Common;
import Util.TestBase;

public class StaleElementException extends TestBase {

	LoginPage_steps lpobj = new LoginPage_steps();
	Goto go = new Goto();
	Ann_Add_Announcement annobj = new Ann_Add_Announcement();

	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();
		try {
			log.info("log.info in test class");
			System.out.println("Test start");
			// WebElement username= driver.findElement(By.id("UserName"));
			// WebElement pw= driver.findElement(By.id("planPassword"));
			// WebElement login= driver.findElement(By.id("btnGo"));
			//
			// //username.sendKeys("emp11@gmail.com");
			// //pw.sendKeys("User@12345");
			// //login.click();
			// //OR
			// driver.navigate().refresh();
			//
			// Thread.sleep(10000);
			// username.sendKeys("emp1@gmail.com");
			// pw.sendKeys("User@1234");
			// login.click();
			//
			//
			// System.out.println("clicked on login button");
			// String title=driver.getTitle();
			// System.out.println("Title= "+ title);

			driver.get("https://www.incedoinc.com/");
			WebElement ele = driver.findElement(By.xpath("//li[@id='menu-item-303']//a[contains(text(),'Careers')]"));
			ele.click();
			// Common.waitForPageLoaded(driver);

			driver.findElement(By.xpath("//li[@id='menu-item-679']//a[contains(text(),'Contact')]")).click();
			System.out.println("clicked on contact ");
			// driver.findElement(By.xpath("//input[@placeholder='First
			// Name']")).sendKeys("this is first name");
			// driver.findElement(By.xpath("//input[@placeholder='Last
			// Name']")).sendKeys("this is last name");
			driver.navigate().back();
			System.out.println("driver.navigate.back executed");

			// ele.click();
			 try {
				 ele.click();
				 System.out.println("this line run or not");
			} catch (StaleElementReferenceException  e) {
				
				System.out.println("VP = stale element exception is showing ");
			}
			 
			 System.out.println("ele.click executed");
			// O/p=>
			// driver.navigate.back executed , FAILED: Testmethod
			// org.openqa.selenium.StaleElementReferenceException: stale
			// Because of that ele element is now old so soln is use try catch
			// block and move on to next ststmnt or find the same element again

//			WebElement ele2 = driver.findElement(By.xpath("//li[@id='menu-item-303']//a[contains(text(),'Careers')]"));
//			ele2.click();
			System.out.println("ele2.click executed");
			
			
			
			
			

		} finally {
			Thread.sleep(1000);
			driver.quit();
			log.info("driver.quit Done ");
		}
	}
	// ........Other methods write here .........

	public void methodoutside1() {
		System.out.println("this is methda");

		
		driver.get("https://www.incedoinc.com/");
		WebElement ele = driver.findElement(By.xpath("//li[@id='menu-item-303']//a[contains(text(),'Careers')]"));
		ele.click();
		driver.findElement(By.xpath("//li[@id='menu-item-679']//a[contains(text(),'Contact')]")).click();
		System.out.println("clicked on contact ");
		driver.navigate().back();
		System.out.println("driver.navigate.back executed");
		// ele.click();  => it throw stale element exception but now we use try catch 
		 try {
			 ele.click();
			 System.out.println("this line run or not");
		} catch (StaleElementReferenceException  e) {
			System.out.println("VP = stale element exception is showing ");
		}
		 
		 System.out.println("ele.click executed");
		System.out.println("ele2.click executed");
		
		
		
	}

}
