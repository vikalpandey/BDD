package Stepimplementions.Learning;

	import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import bsh.ParseException;

public class Calender_Jquery extends TestBase {

LoginPage_steps lpobj=new LoginPage_steps();
Goto go=new Goto();


static int targetDay =0,
targetMonth =0,
targetYear =0;
static int currentDay =0,
currentMonth =0,
currentYear =0;
static int jumpMonthsBy=0;
static boolean increment =true;


				
@Test
public void Testmethod() throws Exception {
TestBase.initialization();		
try {
	driver.get("https://jqueryui.com/datepicker/");
		System.out.println("Test Start - URL Oppened");
	
	//Print all iFrame available on page --
	List <WebElement> iframeid=driver.findElements(By.tagName("iframe"));
	System.out.println("total iframeid= " + iframeid.size());	
	 for (WebElement frame : iframeid) {
		System.out.println("get attribute id= "+frame.getAttribute("id"));
					}	
	//Switch to iframe using webelement or id or name 
	WebElement iframe=driver.findElement(By.xpath("//*[@id='content']/iframe"));
	Common.flash(driver, iframe);
	driver.switchTo().frame(iframe);
	
	driver.findElement(By.xpath("//*[@id='datepicker']")).click();
	By BackCal_icon=By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span");
	By ForwardCal_icon=By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span");
	Common.isElementPresent(BackCal_icon);
	Common.isElementPresent(ForwardCal_icon);
	// Start working on calander 
	
// target day, month, year
// Current day, month, year  // find difference and select day, month, year
// jump to month
// increment or decrement // create some variable for all these things
	
// define global static variable of target and current day, month, year above the test 
	
	
// calculate the current month and target month
	String dateToSet="25/08/2020"; // we need to remove / from this date and add to variable 
	//created a methods for target date
	
	//get the current date 
	getCurrentDateMonthYear();
	
	getTargetDateMonthAndYear(dateToSet);
	
	// find the month difference between current month and target month
	calculateHowManyMonthToJump();
	System.out.println("jumpMonthsBy= "+jumpMonthsBy);
	System.out.println("increment = " + increment);
	

//Moving or jumping to the target month
	for(int i=0;i<jumpMonthsBy;i++)
	{
		if(increment)
		{
			driver.findElement(ForwardCal_icon).click();
		}else
		{
			driver.findElement(BackCal_icon).click();
		}
		Thread.sleep(2000);
	}
	
// Clicking on the target date
//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[1]
	driver.findElement(By.linkText(Integer.toString(targetDay))).click();
	Thread.sleep(3000);
	
	

			
						
						
					
					} finally {
						Thread.sleep(1000);
						driver.quit();
						log.info("driver.quit Done ");
					}	}
				//........Other methods write here .........
	
// method to calculate the current date 
public static void getCurrentDateMonthYear()
{
	Calendar cal =Calendar.getInstance();
	currentDay = cal.get(cal.DAY_OF_MONTH);
	currentMonth = cal.get(cal.MONTH)+1;
	currentYear = cal.get(cal.YEAR);
	System.out.println("getCurrentDateMonthYear= " + currentDay +" "+ currentMonth +" "+ currentYear);
}
public static void getTargetDateMonthAndYear(String dateString)
{
	int firstIndex= dateString.indexOf("/");
	System.out.println("firstIndex ="+ firstIndex);
	int lastIndex= dateString.lastIndexOf("/");
	System.out.println("lastIndex ="+ lastIndex);
	String day= dateString.substring(0, firstIndex);
	targetDay = Integer.parseInt(day);
	System.out.println("targetDay= "+targetDay);
	
	String month=dateString.substring(firstIndex+1, lastIndex);
	targetMonth=Integer.parseInt(month);
	System.out.println("targetMonth= "+targetMonth);
	
	String year=dateString.substring(lastIndex+1, dateString.length());
	targetYear=Integer.parseInt(year);
	System.out.println("targetYear= "+targetYear);
	
	System.out.println("getTargetDateMonthAndYear =  "+targetDay+" "+ targetMonth +" "+targetYear );	
}

public static void calculateHowManyMonthToJump()
{
	if ((targetMonth-currentMonth)>0) {
		jumpMonthsBy=(targetMonth-currentMonth);
	} else {
        jumpMonthsBy=(currentMonth-targetMonth);
        increment =false;
	}
	System.out.println("jumpMonthsBy= "+jumpMonthsBy);
}


	
	
}
