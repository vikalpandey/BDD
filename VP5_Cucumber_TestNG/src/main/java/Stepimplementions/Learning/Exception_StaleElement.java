package Stepimplementions.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Util.Common;
import Util.TestBase;

public class Exception_StaleElement extends TestBase {

	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();
		try{
		//By about=By.xpath("//*[@id='menu-item-25']/a");
		//By aboutincedo=By.xpath("//*[@id='menu-item-24']/a");
		By contact =By.xpath("//*[@id='menu-item-679']/a");
		
		driver.get("https://www.incedoinc.com/");
		Common.waitForLoad(driver);
		//driver.findElement(about).click();
		WebElement about=driver.findElement(By.xpath("//*[@id='menu-item-25']/a"));
		WebElement aboutincedo=driver.findElement(By.xpath("//*[@id='menu-item-24']/a"));
		Actions action=new Actions(driver);
		action.moveToElement(about).perform();
		System.out.println("action.move to about done ");
		aboutincedo.click();
		System.out.println("*****action.move to aboutincedo click done ");

//		driver.navigate().refresh();
//		 about=driver.findElement(By.xpath("//*[@id='menu-item-25']/a"));
//		 aboutincedo=driver.findElement(By.xpath("//*[@id='menu-item-24']/a"));
//		action.moveToElement(about).perform();
//		aboutincedo.click();
//// refresh load the page again and we have found the about element become stale , page is reloadedd, dom is build again so we have find the element again 		
////O/p => org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
//		
		
		driver.navigate().back();
//		action.moveToElement(about).perform();
//		aboutincedo.click();
	//O/p=> 	org.openqa.selenium.StaleElementReferenceException
	//	solution is use try catch block 
 		for (int i = 0; i <2 ; i++) {
			try {
				 about=driver.findElement(By.xpath("//*[@id='menu-item-25']/a"));
				 aboutincedo=driver.findElement(By.xpath("//*[@id='menu-item-24']/a"));
				action.moveToElement(about).perform();
				aboutincedo.click();
				System.out.println("click using try block");

				break;
			} catch (Exception e) {

					System.out.println(e.getMessage());
			}
		}
		
		
//		try {
//			action.moveToElement(about).perform();
//			aboutincedo.click();
//			System.out.println("click using try block");
//		} catch (StaleElementReferenceException e) {
//			 about=driver.findElement(By.xpath("//*[@id='menu-item-25']/a"));
//			 aboutincedo=driver.findElement(By.xpath("//*[@id='menu-item-24']/a"));
//			 
//				action.moveToElement(about).perform();
//				aboutincedo.click();
//				System.out.println("**** click using catch block");
//		}
		
		
		
		
		}
		finally{
			Thread.sleep(10000);
			driver.quit();
			System.out.println("finally block executed and quit");
		}
			
	}

	// ........Other methods write here .........

	public void GoogleWay2automation() {

		
	
		
		
	}

}
