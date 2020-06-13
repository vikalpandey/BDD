package Stepimplementions.Learning;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Common;
import Util.ExcelReader;
import Util.TestBase;

public class NSE extends TestBase{

		LoginPage_steps lpobj=new LoginPage_steps();
		Goto go=new Goto();
//		E_Employee_MyDetails_steps mydetailsobj=new E_Employee_MyDetails_steps();
		
		@Test
		public void Testmethod_NSE() throws Exception 
		{
			TestBase.initialization();	
			try {
				By oldnselink=By.xpath("//*[@id='betaVerBand']/a[1]");
				By Searchbox=By.xpath("//input[@id='keyword']");
				By searchboxdropdown=By.xpath("//span[@id='ajax_response']");
				By Name=By.xpath("//*[contains(text(), 'HDFC Bank Limited') and @id='companyName']");
				By LastPrise=By.xpath("//*[@id='lastPrice']");
				By Delivery_Position=By.xpath("//*[contains(text(), 'Security-wise Delivery Position (')]");
				By Quantity_Traded=By.xpath("//*[@id='quantityTraded']");
				By delivery_Quantity=By.xpath("//*[@id='deliveryQuantity']");
				By delivery_Quan_Percentage=By.xpath("//*[@id='deliveryToTradedQuantity']");
				
				
				
				driver.get("https://www.nseindia.com/");
				Common.waitForPageLoaded(driver);
				Common.waitForLoad(driver);
				Common.click(oldnselink);
				Common.waitForPageLoaded(driver);
				Common.waitForLoad(driver);
				
				driver.findElement(Searchbox).sendKeys("HDFCBANK");
				driver.findElement(Searchbox).sendKeys(Keys.ENTER);
				Assert.assertEquals(driver.findElement(Name).getText(),"HDFC Bank Limited");
				String name=driver.findElement(Name).getText();
				String Lastprice=driver.findElement(LastPrise).getText();
				System.out.println("Lastprice of "+name +"="  +Lastprice);
				Common.click(Delivery_Position);
				
				String Q_Traded=driver.findElement(Quantity_Traded).getText();
				System.out.println("Quantity_Traded = "+Q_Traded);
				
				String d_Quantity=driver.findElement(delivery_Quantity).getText();
				System.out.println("delivery_Quantity = "+d_Quantity);
				
				
				String d_Quan_P=driver.findElement(delivery_Quan_Percentage).getText();
				System.out.println("delivery_Quan_Percentage = "+d_Quan_P);
				
				
				
				
				

			//	System.out.println("excel start ");
			//	ExcelReader ex=new ExcelReader("E:\\2 Selenium\\2.1 local github for VP5 BDD\\VP5_Cucumber_TestNG\\TestData\\TestData.xlsx");

				
				
				
				
			} finally {
				Thread.sleep(1000);
				driver.quit();
			}
			
			
			
			
			
			
			
			
		}
		
		


	}

	
	
	
	

