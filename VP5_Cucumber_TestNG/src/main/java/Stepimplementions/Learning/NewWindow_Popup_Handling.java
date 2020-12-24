package Stepimplementions.Learning;


	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Common;
	import Util.Constant;
	import Util.ExcelUtils;
	import Util.MonitoringMail;
	import Util.TestBase;
	import Util.TestConfig;

	public class NewWindow_Popup_Handling extends TestBase {
		LoginPage_steps lpobj=new LoginPage_steps();
		Goto go=new Goto();

		

		@Test
		public void Testmethod() throws Exception {
			TestBase.initialization();		
			try {
				
				System.out.println("Test start");
				driver.get("http://demo.guru99.com/popup.php");
				Common.waitForElementvisible(driver, By.xpath("/html/body/p/a"));

				System.out.println("--genrating window id from 1st window");
				Set<String> winids = driver.getWindowHandles();
				
				System.out.println("winids="+ winids);
				Iterator<String> iterate=winids.iterator();
				String first_window =iterate.next();
				System.out.println("first_window= " + first_window);
				
				
				driver.findElement(By.xpath("/html/body/p/a")).click();

				
				//W2 will open  and Working on W2
				Thread.sleep(3000);
				System.out.println("------genrating window id from 2nd  window");
				 winids = driver.getWindowHandles();
				System.out.println("winids="+ winids);
				 iterate=winids.iterator();
				 System.out.println("first window"+iterate.next());  // first window
				String second_window =iterate.next();                         // second window
				System.out.println("second_window= " + second_window);
				
				
				driver.switchTo().window(second_window);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("vikal.pandey@incedo.com");
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
				Thread.sleep(3000);
				
				Common.waitForElementvisible(driver, By.xpath("/html/body/p/a"));
				driver.findElement(By.xpath("/html/body/p/a")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/p/a")).click();
				// 3rd new tab will open
				
				
				//W3 will open  and Working on W3
				Thread.sleep(3000);
				System.out.println("---------genrating window id from 3rd  window");
				 winids = driver.getWindowHandles();
				System.out.println("winids="+ winids);
				 iterate=winids.iterator();
				 System.out.println("first window"+iterate.next());  // first window
				 System.out.println("second window"+iterate.next());  // second window
				String third_window =iterate.next();                  // third window
				System.out.println("third_window= " + third_window);

				
				driver.switchTo().window(third_window);
				
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
				Thread.sleep(3000);
				System.out.println("clicked on 3rd window element ");
				
				driver.close();
				System.out.println("3rd window closed");
				Thread.sleep(3000);
				driver.switchTo().window(second_window);
				System.out.println("switch to 2nd window");
				driver.close();
				System.out.println("2nd window closed");
				Thread.sleep(3000);
				driver.switchTo().window(first_window);
				System.out.println("switch to 1st window");
				driver.close();
				Thread.sleep(3000);
				System.out.println("1st window closed");
				
				
				
				
				
				
				
				
				
				
				
				
			
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





	
	
	
