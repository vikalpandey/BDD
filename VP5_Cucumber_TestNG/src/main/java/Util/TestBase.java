package Util;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
//	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Logger log=Logger.getLogger(TestBase.class.getName());
	
	 
	
	
	

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
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		       //set the amount of time to wait for an asynchronous script to finish execution before throwing any error
		
		driver.get(Utility.fetchpropertyvalue("url").toString());// utility
		System.out.println("Opening the url");
		log.info("log.info url filled");
		//Assert.assertEquals(driver.getTitle(), "Avitus Net Login");
		System.out.println("Opening the Login Page url");
		log_method();

		
		
		// method return the object so we convert it to String

	}
	public static void log_method()
	{
		System.out.println("log_method started");
		log.info("log.info started in test base class");
		log.error("log.error started in test base class");
		//genrating time stamp so that log.property file create log file date wise
		Date d=new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		System.out.println("today date ="+d);
		
		PropertyConfigurator.configure("E:/2 Selenium/2.1 local github for VP5 BDD/VP5_Cucumber_TestNG/src/main/resources/log4j.properties");
// if i do not use above propertyconfigurtor and path of peroperty file then also its working fine 
// so question is how to my sytem know that log4j.property file is here so ans is PropertyConfigurator.configure(path pf property file 	
	}

	
	
}
