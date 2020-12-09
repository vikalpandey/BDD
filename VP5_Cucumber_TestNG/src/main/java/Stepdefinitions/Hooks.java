package Stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import Util.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {
	

	@Before
	public void initDriver(Scenario scenario) throws Exception {
		System.out.println("hooks Before method");
		TestBase.initialization();
		// driver.manage().deleteAllCookies();

	}

	@After

	public void afterScenario(Scenario scenario) throws Exception {
		//scenario class
		if (scenario.isFailed()) {
			// Take a screenshot..
			try {
				String src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				// Add it in the report.
				Reporter.addScreenCaptureFromPath("data:image/jpeg;base64," + src);

			} catch (WebDriverException e) {
				e.getMessage();
			}
		}
//we can capture screen shot using byte also 
//https://medium.com/@priyank.it/cucumber-report-taking-screenshot-embedding-inside-47d6d3c723bc

		
		
		
		//------------------------

		System.out.println("Hooks after method");
		try {
			//driver.quit();
			TestBase.quit();
		} catch (Exception e) {
			System.out.println("some exception occurred while quitting the browser= "+e);
		}

		// this reporter class will write the text in extent report
		Reporter.assignAuthor("Vikal pandey");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10 " + "- 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Maven", "3.6.1");
		Reporter.setSystemInfo("Java Version", "1.8.0_73");
		Reporter.addStepLog("Step Log message goes here");
		Reporter.addScenarioLog("Scenario Log message goes here");

	
		
		
		//----------------------
	
	}

//Tagged hooks	
//	@Before("prod")
//	@After("prod")  
// you need to mentons same in fearure file as welll	
	
	
	
//	public void TearDown() {
//		System.out.println("Hooks after method");
//		try {
//			driver.quit();
//		} catch (Exception e) {
//			System.out.println("some exception occurred while quitting the browser");
//		}
//
//		// this reporter class will write the text in extent report
//		Reporter.assignAuthor("Vikal pandey");
//		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//		Reporter.setSystemInfo("Machine", "Windows 10 " + "- 64 Bit");
//		Reporter.setSystemInfo("Selenium", "3.141.59");
//		Reporter.setSystemInfo("Maven", "3.6.1");
//		Reporter.setSystemInfo("Java Version", "1.8.0_73");
//		Reporter.addStepLog("Step Log message goes here");
//		Reporter.addScenarioLog("Scenario Log message goes here");
//
//	}

}
