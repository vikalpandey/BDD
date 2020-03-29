package Util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestBase {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	 
	
	
	

	public static void initialization() throws Exception {
		System.out.println("inside initialization method ");
		if (Utility.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Utility.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Utility.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		         //set the amount of time to wait for a page load to complete before throwing an error.
		        //when use timeout,page navigation should be executed under the control of try-catch clauses that catch the TimeoutException.
		//driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		        // implicit wait is only for checking the presence of element
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		       //set the amount of time to wait for an asynchronous script to finish execution before throwing any error
		
		driver.get(Utility.fetchpropertyvalue("url").toString());// utility
		System.out.println("Opening the url");
		log.info("log.info url filled");
		//Assert.assertEquals(driver.getTitle(), "Avitus Net Login");
		System.out.println("Opening the Login Page url");

		// method return the object so we convert it to String

	}

	
	
}
