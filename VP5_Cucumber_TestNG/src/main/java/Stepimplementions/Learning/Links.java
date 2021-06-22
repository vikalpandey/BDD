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

public class Links extends TestBase {

	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();
		try {
			System.out.println("Test start");
		//	driver.get("https://www.makemytrip.com/");
			// driver.get("https://www.incedoinc.com/");
			driver.get("https://ui.freecrm.com/");
			driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("vpincedo@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pass@555");
			driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
			Thread.sleep(3000);
			System.out.println("Login and wait done");
			Common.waitForLoad(driver);
			Common.waitForPageLoaded(driver);

			// Step 1
			By alllinks_tagname = By.tagName("a");
			By allimages_tagname = By.tagName("img");

			List<WebElement> linkslist = driver.findElements(alllinks_tagname);
			linkslist.addAll(driver.findElements(allimages_tagname));
			// may be some links do not have href // req is this is a link but
			// do not want to redirect to some other site
			// we need to check that if href is avaialble then href or url
			// should not be broken
			System.out.println("******* linkslist size= " + linkslist.size());

			List<WebElement> activelinks = new ArrayList<WebElement>();

			// Step 2 iterate linkslist -exclude all the links or image which
			// does not have any href attribute
			for (int i = 0; i < linkslist.size(); i++) {
				if (linkslist.get(i).getAttribute("href") != null
						&& (!linkslist.get(i).getAttribute("href").contains("javascript"))) {
					activelinks.add(linkslist.get(i));
				}
			}
			System.out.println("#### activelinks size =  " + activelinks.size());
			// some time java script link found in place of href url the it
			// goves exception then ? , links not found in correct form as href

			// Step 3 check the href url with http connection api
			for (int j = 0; j < activelinks.size(); j++) {
				HttpsURLConnection connection = (HttpsURLConnection) new URL(activelinks.get(j).getAttribute("href"))
						.openConnection();
				connection.connect();
				String response = connection.getResponseMessage();// OK
				connection.disconnect();

				System.out.println(activelinks.get(j).getAttribute("href") + "---->" + response);
				// response code200-> ok, 400-> bad request , 404-> not found,
				// 500 --> internal server error
			}

		} finally {
			Thread.sleep(1000);
			driver.quit();
			log.info("driver.quit Done ");
		}
	}

	// ........Other methods write here .........

	public void GoogleWay2automation() {

	}

}
