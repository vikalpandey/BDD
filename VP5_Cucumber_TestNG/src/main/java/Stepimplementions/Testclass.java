package Stepimplementions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Stepdefinitions.Hooks;
import Util.Common;
import Util.Constant;
import Util.ExcelUtils;
import Util.MonitoringMail;
import Util.TestBase;
import Util.TestConfig;

public class Testclass extends TestBase {
	LoginPage_steps lpobj=new LoginPage_steps();
	Goto go=new Goto();

	

	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();		
		try {
			
			lpobj.loginwith_emp1();
			log.info("log.info in test class");
			
			
			
			By Clientlabel=By.xpath("//label[contains(text(), 'Client')]");
			By Client=By.xpath("//input[@id='AutoComplete']");
			By Client_autocomplete_list=By.xpath("//ul[@id='AutoComplete_listbox']");
			By completed_by_label=By.xpath("//label[contains(text(), 'Completed By')]");
			By completed_by_textbox=By.xpath("//input[@id='txtCompletedBy' and @name='CompletedBy']");
			By employeename_label=By.xpath("//label[contains(text(), 'Employee Name')]");
			By employeename_textbox=By.xpath("//input[@id='EmployeeAutoComplete' and @name='EmployeeAutoComplete']");
			By employeename_Listbox=By.xpath("//ul[@id='EmployeeAutoComplete_listbox']");
			By employeename_Listbox_li=By.xpath("//ul[@id='EmployeeAutoComplete_listbox']/li");
			By employeename_Listbox_popup=By.xpath("//div[contains(text(), 'This employee already has been initiated or processed for separation.')]"); 
			By PrimaryEmail=By.xpath("//input[@id='txtWorkEmail' and @name='WorkEmail']");
			By Hiredate=By.xpath("//input[@name='OriginalHireDate']");
			By LastDayofwork =By.xpath("//input[@name='ActualLastDayWork' and @data-role='datepicker' ]");
			By LastDayofwork_calander_icon=By.xpath("//*[@id='txtActualLastDayWork']//ancestor::span//span[@class='k-icon k-i-calendar']");
			By SeparationDate=By.xpath("//input[@name='SeparationEffectiveDate' and @data-role='datepicker' ]");
			By SeparationDate_calander_icon=By.xpath("//*[@id='txtEffectiveDate']//ancestor::span//span[@class='k-icon k-i-calendar']");
			By calander_locator_day=By.xpath("//*[@class='k-link']");
			By FinalHoursDue_textbox_id=By.id("txtFinalHoursDue");
			
			
			driver.findElement(By.xpath("//a[@class='adminWrap active']")).click();
			System.out.println("clicked on admin tab ");
		  //WebDriverWait wait=new WebDriverWait(driver, 20);         // explicit wait 
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  // Fluent wait 
				       .withTimeout(30, TimeUnit.SECONDS)  // depreciated methods
				       .pollingEvery(3, TimeUnit.SECONDS) // depreciated methods
				       .withTimeout(Duration.ofSeconds(30)) //this is new
				       .pollingEvery(Duration.ofSeconds(3))
				       .withMessage("Timeoutafter 30 sec")
				       .ignoring(NoSuchElementException.class);
			// now we can use wait object any - explicit or fluentwait 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='adminWrap active']"))).click();


	
			
	

			
			
	
			
			

			       
			
			
			
			
			
			
			
	/*		
			Common.waitForElementvisible(driver, Clientlabel);
			Common.waitForElementvisible(driver, Client);
			Common.sendkeys(Client, "am");
			Common.waitForElementvisible(driver, Client_autocomplete_list);
			Common.selectOptionWithText("Vikal`s Boost (AM1)",Client_autocomplete_list);
			Common.waituntilPageLoadComplete(driver, 20L);
			
			Common.waitForElementvisible(driver, completed_by_textbox);
			Common.sendkeys(completed_by_textbox, "VP completed by text box ");
			Common.waituntilPageLoadComplete(driver, 3L);
			
			Common.waitForElementvisible(driver, employeename_textbox);
			Common.sendkeys(employeename_textbox, "am1");
			Common.waituntilPageLoadComplete(driver, 2L);
			Thread.sleep(3000);
			Common.selectOptionWithIndex(2,employeename_Listbox,employeename_Listbox_li );
			Common.waituntilPageLoadComplete(driver, 40L);
			Common.waitForElementvisible(driver, PrimaryEmail);
			//WebElement PrimaryEmail=driver.findElement(By.xpath("//input[@id='txtWorkEmail' and @name='WorkEmail']"));
			WebElement PrimaryEmailvar =driver.findElement(PrimaryEmail);
			System.out.println("PrimaryEmailvar_text= "+PrimaryEmailvar.getAttribute("value"));
			WebElement hiredate_var=driver.findElement(Hiredate);
			System.out.println("hire date var text = "+ hiredate_var.getAttribute("value"));
			

*/		
			 

			Thread.sleep(10000);
			System.out.println("end");
		
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
	
	
	
	
	
	
}




