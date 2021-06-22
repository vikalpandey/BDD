package Stepimplementions.Learning;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Util.Common;
import Util.TestBase;

public class Links_broken extends TestBase {
	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();
		try {
			// https://www.toolsqa.com/selenium-webdriver/finding-broken-links-selenium-automation/
			System.out.println("Test start");
			driver.get("https://ui.freecrm.com/");
			driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("vpincedo@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pass@555");
			driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
			Thread.sleep(3000);
			System.out.println("Login and wait done");
			Common.waitForLoad(driver);
			Common.waitForPageLoaded(driver);
			// Step 1=> is to find all image and anchor tag elements. In this
			// step, you would also like to filter out elements that don’t have
			// href attributes.

			List<WebElement> allImages =findAllLinks(driver);
			System.out.println("Total number of elements found " + allImages.size());

			// step 2. ( check in the links are working or not ?) Here I will
			// introduce to you a Class from Java, called HttpURLConnection
			// class. This class is used to make HTTP requests to the webserver
			// hosting the links extracted in step 1.
			
			for (WebElement element : allImages) {
				try {
					System.out.println("URl: "+ element.getAttribute("href") + " returned " +isLinkBroken(new URL(element.getAttribute("href"))) );
					
				} catch (Exception e) {
					e.getMessage();
					System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + e.getMessage());	    		
				}	
			}
			
//Unable to connect to SSL services due to "PKIX Path Building Failed" error
		
		//O/p=> when we ru program then some times gives stal eelement exceptin but most of the time it gives below exception when any one run broken link related code
		//exception =	sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
		//
		// this exception is may be due to certificate not install or due to office laptop proxy issue or some security 
	// this is link of this exception for further info 
			//link URL = https://stackoverflow.com/questions/21076179/pkix-path-building-failed-and-unable-to-find-valid-certification-path-to-requ
			
			
	//Cause URL = (https://confluence.atlassian.com/kb/unable-to-connect-to-ssl-services-due-to-pkix-path-building-failed-error-779355358.html)
//			Whenever Java attempts to connect to another application over SSL (e.g.: HTTPS, IMAPS, LDAPS), 
//			it will only be able to connect to that application if it can trust it. The way trust is handled 
//			in the Java world is that you have a keystore (typically $JAVA_HOME/lib/security/cacerts), 
//			also known as the truststore.		
			
			
		//Imp URL ==	http://www.littlebigextra.com/how-to-fix-pkix-path-building-failed-sun-security-provider-certpath-suncertpathbuilderexception/		
			
			

		} finally {
			Thread.sleep(1000);
			driver.quit();
			log.info("driver.quit Done ");
		}
	}

	// ........Other methods write here .........

	public static List findAllLinks(WebDriver driver) {
		List<WebElement> elementList = new ArrayList();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("******* elementList size  = " + elementList.size());
		List<WebElement> finalList = new ArrayList();

		for (WebElement element : elementList) {
			if (element.getAttribute("href") != null && (!element.getAttribute("href").contains("javascript"))) {
				finalList.add(element);
			}
		}
		System.out.println("******** final list  size = " + finalList.size());
		return finalList;
	}

	
	
	public static String isLinkBroken(URL url) throws Exception
	{
		//url = new URL("https://yahoo.com");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		try
		{
		    connection.connect();
		    String response = connection.getResponseMessage();	        
		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}				
	}
	
	
	
	
	
}
