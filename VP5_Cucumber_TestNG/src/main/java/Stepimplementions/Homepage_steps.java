package Stepimplementions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import Util.TestBase;

public class Homepage_steps extends TestBase {
	
	Logger logger  = Logger.getLogger( Homepage_steps.class.getName()); 


	
	
	By UserName = By.xpath("//input[@id='UserName']");
	
	public void user_should_be_on_login_page_or_not()
	{
		 Assert.assertEquals(driver.getTitle(), "Avitus Net Login");
		 logger.info("hello");
		 log.info("this is log in step impplementastion");
	}
	
	public void Fill_sa1_username()
	{
		//driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("sa1@gmail.com");
		driver.findElement(UserName).sendKeys("sa1@gmail.com");

Reporter.addStepLog("Step Log message goes here2");
Reporter.addScenarioLog("Scenario Log message goes here2");
	}
	public void Fill_ca1_username()
	{
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("ca1@gmail.com");
	}
	public void Fill_emp1_username()
	{
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("emp1@gmail.com");
	}
	public void Fill_Password()
	{
		driver.findElement(By.xpath("//input[@id='planPassword']")).sendKeys("User@1234");
		log.info("This is  log test for password ");
	}
	
	

}
