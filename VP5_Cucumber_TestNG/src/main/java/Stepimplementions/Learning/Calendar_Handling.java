package Stepimplementions.Learning;

	import java.text.SimpleDateFormat;
import java.time.Duration;
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
	public class Calendar_Handling extends TestBase{


LoginPage_steps lpobj=new LoginPage_steps();
Goto go=new Goto();
				
@Test
public void Testmethod() throws Exception {
TestBase.initialization();		
try {
		

			
						
						
					
					} finally {
						Thread.sleep(1000);
						driver.quit();
						log.info("driver.quit Done ");
					}	}
				//........Other methods write here .........
	
	
	public void pickcalanderdate() throws InterruptedException, java.text.ParseException
	{
		
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//*[@id='departureCalendar']")).click();
		Thread.sleep(3000);
		String d= "29/7/2020";  //"31/3/2021";    //  dd/mm/yyyy format
		String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

		//extract day, month and year from the date string using an object of existing java class ‘SimpleDateFormat’.
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		//We than parse the predefined date ‘d’ with help of parse method. This parse method returns an object of ‘Date’ class
		Date mydate = df.parse(d);

		//we will create a calendar instance as mentioned below
		java.util.Calendar cal=java.util.Calendar.getInstance();

		//we will set date in calendar using setTime method
		cal.setTime(mydate);
		//we have ‘set’ the date. We will now ‘get’ the day, month and year using ‘get’ method,
		int day=cal.get(java.util.Calendar.DAY_OF_MONTH);
		int month=cal.get(java.util.Calendar.MONTH);
		int year=cal.get(java.util.Calendar.YEAR);
		System.out.println(day);   //o/p=31
		//System.out.println(month);  //o/p=2
		System.out.println(months[month]);  //o/p=2
		System.out.println(year);   //o/p=2021

		//Now in the website, the calendar shows the month as alphabetical ex- ‘March’, April etc..
		//The month is getting printed as numeric (2) as of now. We don’t want numeric month name, 
		//we want alphabetical, viz ‘March’ or April etc.
		//=> To handle this situation, we will create a month array & enter all the months inside it (line#23)
		//String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

			

		//When you click the calendar, by default, the current month would be shown. The date that we have set in 
		//our program is a future date viz 31st Mar 2021. Now we have to develop a logic that will keep clicking forward 
		//arrow > till we get March 2021 calendar

		By calforwardarrow=By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']");

		//If you notice the website calendar, it shows month followed by space followed by year, example ‘March 2020’	
		//So we can create a string that is equal to month concatenated by white space concatenated by year,

		String travelMonth=months[month] +" "+year;
		System.out.println(travelMonth);
		////div[@class='fareCalFlt ']/div/div[2]/div[1] is xpath of ‘March 2020’ or any month 
		By xpathmonthyearsection=By.xpath("//div[@class='fareCalFlt ']/div/div[2]/div[1]");

		/*Now the logic we will be coding is: we will keep on clicking the forward arrow button till the time
		xpathMonthYearSection is NOT equal to travelMonth. A time will come when both of these would equal to 
		‘March 2021’. At that point, we would stop clicking any further. This can be done using while loop. 
		The exclaimation mark ! in the ‘while’ loop is a negation viz till the time xpathMonthYearSection is 
		NOT equal to travelMonth, the body of while loop keeps getting executed
		*/

		while (!driver.findElement(xpathmonthyearsection).getText().equalsIgnoreCase(travelMonth)) {
			Thread.sleep(1000);
			driver.findElement(calforwardarrow).click();
			Thread.sleep(2000);
		}

		driver.findElement(By.xpath("//div[text()='" + day + "']")).click();//select desired date 
		Thread.sleep(1000);
				
		
	}

	
	
	
	
	
}