package Stepimplementions.Learning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Stepimplementions.Ann_Add_Announcement;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Common;
import Util.TestBase;

public class Links_PrintAllVisibleLinks extends TestBase {

	@Test
		public void Testmethod() throws Exception {
			TestBase.initialization();
			try {
				System.out.println("Test start");
				//driver.get("https://www.incedoinc.com/");
				driver.get("https://www.hdfcbank.com/");
				
				int count =0;
				List<WebElement> links=driver.findElements(By.tagName("a"));
				System.out.println("only links= "+links.size());
				//links.addAll(driver.findElements(By.tagName("img")));
				//System.out.println("links count = "+ links.size());
				
				
//				for (int i = 0; i < links.size(); i++) {
//					count=count+1;
//					System.out.println("text = "+links.get(i).getAttribute("text")+" href = " +links.get(i).getAttribute("href"));
//				}
//				System.out.println("total count = "+count);
//				
//				System.out.println("===================Print only active links ");
//				List<WebElement> finalList = new ArrayList();
//				for (WebElement element : links) {
//					if (element.getAttribute("href") != null && (!element.getAttribute("href").contains("javascript"))) {
//						finalList.add(element);
//					}
//				}
//				System.out.println("******** final list  size = " + finalList.size());
//				for (int i = 0; i < finalList.size(); i++) {
//					System.out.println("text = "+finalList.get(i).getAttribute("text")+" href = " +finalList.get(i).getAttribute("href"));
//					
//				}
				
				
				System.out.println("===================Print only link which are not null links another way ");
				System.out.println(links.size());
				try {
					int counter=0;
					for (int i = 0; i < links.size(); i++) {
						if (!links.get(i).getText().isEmpty()) {
							counter=counter+1;
							System.out.println(links.get(i).getText());
							 links=driver.findElements(By.tagName("a"));
							//links.addAll(driver.findElements(By.tagName("img")));
							
						}
						
						
//						if (!links.get(i).getAttribute("href").isEmpty()) {
//							//counter=counter+1;
//							System.out.println(links.get(i).getAttribute("href"));
//						}
						
					}
					System.out.println("visible links are= "+counter);
					
				} catch (Exception e) {
					e.getMessage();
				}
				
				
				
				
		   
				

			}finally

	{
		Thread.sleep(1000);
		driver.quit();
		log.info("driver.quit Done ");
	}
	}

	// ........Other methods write here .........

	public void GoogleWay2automation() {

		
		
		
		
		
		
	}

}

