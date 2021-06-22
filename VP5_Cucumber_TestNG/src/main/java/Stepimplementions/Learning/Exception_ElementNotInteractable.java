package Stepimplementions.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Util.Common;
import Util.TestBase;

public class Exception_ElementNotInteractable extends TestBase {

	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();
		try {
			By explore=By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[4]/details/summary");
			driver.get("https://github.com/");
			Actions action= new Actions(driver);
			action.moveToElement(driver.findElement(explore)).perform(); 
			System.out.println("clicked");
			driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/div[1]/p/a[1]")).click();
			System.out.println("try to click on open source link");
			
			System.out.println("*****getcurrent url = "+driver.getCurrentUrl());
			System.out.println("*****page title= "+driver.getTitle());
			
			
			
			
			
			
			

			
			
			
			
			
			
		} finally {
			Thread.sleep(10000);
			driver.quit();
			System.out.println("finally block executed and quit");
		}

	}

	// ........Other methods write here .........

	public void GoogleWay2automation() {

	}

}
