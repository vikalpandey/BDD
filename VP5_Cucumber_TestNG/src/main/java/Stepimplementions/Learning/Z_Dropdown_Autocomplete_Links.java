package Stepimplementions.Learning;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class Z_Dropdown_Autocomplete_Links extends TestBase {
	LoginPage_steps lpobj=new LoginPage_steps();
	Goto go=new Goto();
	Ann_Add_Announcement annobj=new Ann_Add_Announcement();
	
	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();		
		try {
			//lpobj.loginwith_ca1();
			log.info("log.info in test class");
			System.out.println("Test start");
			
			wayToAutomationGoogleSearchMethods();
			
//****Dropdown-- print all dropdown text
//			lpobj.loginwith_sa1();
//			go.admintab();
//			go.admin_Announcements_Add_Announcement();
//			annobj.CheckAnnouncementCheckbox();
//			annobj.SelectTargetAudienceDropDownAsEmp();
			
//****Links --			
//			driver.get("https://www.makemytrip.com/");
//			List<WebElement> list=driver.findElements(By.tagName("a"));
//			System.out.println(list.size());
//			for (WebElement element : list) {
//				System.out.println(element.getText());
//				
//			}
//****Links --	Print all page links with URL		

//			driver.get("https://www.wikipedia.org/");
			
//			List<WebElement> list=driver.findElements(By.tagName("a"));
//			System.out.println(list.size());
//			for (WebElement element : list) {
//				System.out.println(element.getText()+" -- URL is-- "+ element.getAttribute("href"));
//				
//			}
//****Links --	Print perticular section  links with URL	************************			
//			List<WebElement> list=driver.findElements(By.xpath("//*[@class='other-projects']//a"));
//			System.out.println(" list size= "+list.size());
//			for (WebElement element : list) {
//				System.out.println("links list== "+element.getText());
//			}
			
//			System.out.println("another way start ------");
//			System.err.println("another way start --- of printing all links or dropdown of perticular section-");
//			
//			
//			WebElement box =driver.findElement(By.xpath("//*[@class='other-projects']"));
//			List<WebElement> listbox=box.findElements(By.tagName("a"));
//			System.out.println(" list size= "+listbox.size());
//			for (WebElement element : listbox) {
//				System.out.println("links of listbox are == "+element.getText());
//			}

//**** isElementPresent, isDisplayed, isEnabled,  isSelected			
//			boolean display =driver.findElement(By.xpath("//*[contains(text(), 'The Free Encyclopedia')]")).isDisplayed();
//			boolean enable =driver.findElement(By.xpath("//*[contains(text(), 'The Free Encyclopedia')]")).isEnabled();
//			boolean selected =driver.findElement(By.xpath("//*[contains(text(), 'The Free Encyclopedia')]")).isSelected();
//			System.out.println(display);  // True
//			System.out.println(enable); // True
//			System.out.println(selected); // false
			
	
			
			
			
			
			
		
		} finally {
			Thread.sleep(1000);
			driver.quit();
			log.info("driver.quit Done ");
		}	}
	//........Other methods write here .........

	
	public void methodoutside1()
	{
		System.out.println("this is methda");
	}
	// open google > search text> click on 1st search link > search all links count and print name 
	public void wayToAutomationGoogleSearchMethods() throws Exception
	{
		System.out.println("Google search start");
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("way2automation");
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
		//By firstsearchlink=By.xpath("//div[@id='rso']/div[1]//a[@href='http://www.way2automation.com/']");
		By firstsearchlink=By.xpath("//div[@id='rso']/div[1]//a//*[contains(text(),'Way2Automation')]");
		Common.waitForElementtobeclickable(driver, firstsearchlink);
		driver.findElement(firstsearchlink).click();
		Common.waitForLoad(driver);
		Common.waitForPageLoaded(driver);
		
		 List<WebElement>  list_links=driver.findElements(By.tagName("a"));
		 System.out.println(list_links.size());
		 
		 for (WebElement webElement : list_links) {
			System.out.println(webElement.getText()+" -- URL is-- "+ webElement.getAttribute("href"));
	
		}
		 
	}
	
	
	
	

}
