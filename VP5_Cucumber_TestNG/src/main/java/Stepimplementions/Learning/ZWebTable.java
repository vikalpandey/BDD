package Stepimplementions.Learning;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import Stepimplementions.Ann_Add_Announcement;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Common;
import Util.TestBase;

public class ZWebTable extends TestBase {
		LoginPage_steps lpobj=new LoginPage_steps();
		Goto go=new Goto();
		Ann_Add_Announcement annobj=new Ann_Add_Announcement();
		
		@Test
		public void Testmethod() throws Exception {
			TestBase.initialization();		
			try {
				//lpobj.loginwith_ca1();
				log.info("log.info in test class");
				System.out.println("Test start");
				
// ***Webtable ** Open money control and go to webtable of top gainer or top loser list 
				
				driver.get("https://www.moneycontrol.com/");
				// below xpath is up to rows 
				WebElement element =driver.findElement(By.xpath("//*[@id='tgNifty']/table/tbody/tr"));
				System.out.println("scroll method start" );
				//Common.scrollUpToElementByJS(driver, element);
				Common.scrollPageDownByJS();
				System.out.println("scroll method end and is element start " );
				Common.isElementPresent(element);
				if (Common.isElementPresent(element)==true) {
					System.out.println("Common.isElementPresent(element)==true");
				} else {
					System.out.println("Common.isElementPresent(element)==false");
				}
				
			List<WebElement> rowlist	=driver.findElements(By.xpath("//*[@id='tgNifty']/table/tbody/tr"));
			System.out.println("Row count ="+rowlist.size());
			
			
			List<WebElement> columnlist	=driver.findElements(By.xpath("//*[@id='tgNifty']/table/tbody/tr[1]/td"));
			System.out.println("Column count ="+columnlist.size());
			
			//Now we know that rows are 1 to 5 and column are 1 to 4 then we go for for loop for row and column
			
			for (int rows = 1; rows <= rowlist.size(); rows++) {
				
				for (int cols = 1; cols <= columnlist.size(); cols++) {
					//driver.findElement(By.xpath("//*[@id='tgNifty']/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()
					System.out.print(driver.findElement(By.xpath("//*[@id='tgNifty']/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()+"  ");
					
				}
				System.out.println();
			}
			
			
			
	
				
				
				
				
				
				
				
				
				
				
			
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

	
	
	


