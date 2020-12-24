package Stepimplementions.Learning;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class ActionAPI_Mouse_Keyboard extends TestBase{
	
		
			LoginPage_steps lpobj=new LoginPage_steps();
			Goto go=new Goto();
			
			
			
			@Test
			public void Testmethod() throws Exception {
				TestBase.initialization();		
				try {
					System.out.println("Test start");
					
					driver.get("https://www.hdfcbank.com/");
					driver.findElement(By.xpath("//*[@id='custom-button']/button")).click();
					
					

					

					
					

					
					
					
					
				
					
					
					
					
					
					
					

					

					

					
			
					
					
					
					
					
				
				} finally {
					Thread.sleep(1000);
					driver.quit();
					log.info("driver.quit Done ");
				}	}
			//........Other methods write here .........

			

			
			public void GoogleWay2automation() 
			{
				System.out.println("Google search start");
				driver.get("https://www.google.co.in/");
				driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("way2automation");
				driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
				//By firstsearchlink=By.xpath("//div[@id='rso']/div[1]//a[@href='http://www.way2automation.com/']");
				By firstsearchlink=By.xpath("//div[@id='rso']/div[1]//a//*[contains(text(),'Way2Automation')]");
				try {
					Common.waitForElementtobeclickable(driver, firstsearchlink);
				} catch (Exception e) {
					System.out.println("Element not clickable " + firstsearchlink);
					e.printStackTrace();
				}
				driver.findElement(firstsearchlink).click();
				System.out.println("first searched link clicked");
				//Common.waitForLoad(driver);
				//Common.waitForPageLoaded(driver);
				
				System.out.println(driver.getTitle());
				String title=driver.getTitle();
				Assert.assertEquals(title, "Selenium Training By Rahul Arora |Best Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
				
				System.out.println("---Common classwithfor pagettle method start ");
				String wtitle=Common.waitForPageTitle(driver, "Selenium Training By Rahul Arora |Best Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
				System.out.println("=> waitForPageTitle method return string = "+ wtitle);
				System.out.println("---Common classwithfor pagettle method  End ");
				
				String ctitle=Common.getTitleByJS();
				System.out.println("=> common class gettitle byjs = "+ctitle);
				
			}
			
			
			public void ActionMouseover() throws InterruptedException
			{
				driver.get("http://www.way2automation.com/");
				Actions action=new Actions(driver);
				WebElement mainmenu= driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
				WebElement submenu= driver.findElement(By.xpath("//a[contains(text(),'Practice site 1')]"));
	
//				action.moveToElement(mainmenu).perform(); // now it will mouse over the manin menuelemen 
//				driver.findElement(By.xpath("//a[contains(text(),'Practice site 1')]")).click();
				action.moveToElement(mainmenu).perform();
				action.moveToElement(submenu).click().perform();
							
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);
				WebElement mainmenu2= driver.findElement(By.xpath("//a[contains(text(),'VIDEO TUTORIALS')]"));
				action.moveToElement(mainmenu2).build().perform();
				Thread.sleep(3000);	
			}
			
			
			public void SwitchTo_Iframe_Slider_DragDrop() throws InterruptedException
			{
				driver.get("https://jqueryui.com/slider/");
				//Print all iframe available on page --
				List <WebElement> iframeid=driver.findElements(By.tagName("iframe"));
				System.out.println("total iframeid= " + iframeid.size());	
				for (WebElement frame : iframeid) {
					System.out.println("get attribute id= "+frame.getAttribute("id"));
				}
				
				//Switch to iframe using webelement or id or name 
				WebElement iframe=driver.findElement(By.xpath("//*[@id='content']/iframe"));
				Common.flash(driver, iframe);
				driver.switchTo().frame(iframe);
				
				//Find main slider width so that we can move our courser according to width
				WebElement mainSlider=driver.findElement(By.xpath("//div[@id='slider']"));
				Common.flash(driver, mainSlider);
				int width=mainSlider.getSize().width/2;
				System.out.println("slider width/2 ="+ width);
				
				WebElement slider=driver.findElement(By.xpath("//*[@id='slider']/span"));
				Common.flash(driver, slider);
				
				Actions action=new Actions(driver); // Use Drag and Drop
				action.dragAndDropBy(slider, width, 0).perform();					
				System.out.println("slider performed");

				//Switching back from frame to orignal window , u can also give to id or name
				driver.switchTo().defaultContent();
				List <WebElement> iframeid2=driver.findElements(By.tagName("iframe"));
				System.out.println("We are out of frame total iframeid= " + iframeid2.size());	

			}
			
			
			public void Resize_Element() throws Exception
			{
				driver.get("https://jqueryui.com/resizable/");
				//Print all iframe available on page --
				List <WebElement> iframeid=driver.findElements(By.tagName("iframe"));
				System.out.println("total iframeid= " + iframeid.size());	
				for (WebElement frame : iframeid) {
					System.out.println("get attribute id= "+frame.getAttribute("id"));
				}
				
				//Switch to iframe using webelement or id or name 
				WebElement iframe=driver.findElement(By.xpath("//*[@id='content']/iframe"));
				driver.switchTo().frame(iframe);
				
				//Find resizeble element and hight, width and pass on in drag and drop method
				WebElement resizeelement=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
				System.out.println("resizeelement hight= "+resizeelement.getSize().height/2);
				System.out.println("resizeelement width= "+resizeelement.getSize().width/2);
				int hight =resizeelement.getSize().height/2;
				int width =resizeelement.getSize().width/2;
				
				Actions action=new Actions(driver); // 
				action.dragAndDropBy(resizeelement, width, hight ).perform();
				Thread.sleep(8000);
			
				//Switching back from frame to orignal window , u can also give to id or name
				driver.switchTo().defaultContent();
				List <WebElement> iframeid2=driver.findElements(By.tagName("iframe"));
				System.out.println("We are out of frame total iframeid= " + iframeid2.size());	
			}

			public void dragAndDrop_element() throws Exception
			{
				driver.get("https://jqueryui.com/droppable/");
				//Print all iframe available on page --
				List <WebElement> iframeid=driver.findElements(By.tagName("iframe"));
				System.out.println("total iframeid= " + iframeid.size());	
				for (WebElement frame : iframeid) {
					System.out.println("get attribute id= "+frame.getAttribute("id"));
				}
				//Switch to iframe using webelement or id or name 
				WebElement iframe=driver.findElement(By.xpath("//*[@id='content']/iframe"));
				Common.flash(driver, iframe);
				driver.switchTo().frame(iframe);
				
				//Find drag and drop element 
				WebElement dragable=driver.findElement(By.xpath("//*[@id='draggable']"));
				WebElement dropable=driver.findElement(By.xpath("//*[@id='droppable']"));

				Actions action=new Actions(driver); // 
				action.dragAndDrop(dragable, dropable).perform();
				Thread.sleep(8000);

				//Switching back from frame to orignal window , u can also give to id or name
				driver.switchTo().defaultContent();
				List <WebElement> iframeid2=driver.findElements(By.tagName("iframe"));
				System.out.println("We are out of frame total iframeid= " + iframeid2.size());		
			}
			
			
			public void Rightclick() throws Exception
			{
				driver.get("http://deluxe-menu.com/popup-mode-sample.html");
				WebElement element=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		
				Actions action =new Actions(driver);
				action.contextClick(element).perform();
				
				Thread.sleep(3000);
				System.out.println("Right click performed");
			}
			
			public void keyBoardEvent() throws Exception
			{
				driver.get("https://www.google.co.in/");
				WebElement searchBox =driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
				searchBox.sendKeys("vikal pandey");
				//in above line element have to attach with keys but in action class no need to element
				//But best approach is use action incase of if you handling keyboard event
				WebElement searchButton =driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']"));
		        // click outside the search box so that we can ctrl+a and go to text box for ctrl+v
				driver.findElement(By.xpath("//*[@id='hplogo']")).click();

				Actions action =new Actions(driver);
	 
				action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
				driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).click();
				action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				
				Thread.sleep(8000);
				//click on google search button 
				action.sendKeys(Keys.ENTER).perform();
			}
			
			public void Alerthanle()
			{
				driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
				driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
				//driver.switchTo().alert().accept();
				//OR
				Alert alert=driver.switchTo().alert();
				System.out.println("Alert text = "+alert.getText());
				alert.accept();
				//OR you can handle it using Explicit wait
				
//				WebDriverWait wait=new WebDriverWait(driver, 30);
//				Alert alert=wait.until(ExpectedConditions.alertIsPresent());
//				System.out.println("Alert text = "+alert.getText());
//				alert.accept();

				Boolean b=Common.isElementPresent(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]"));
				if (b==true) {
					System.out.println("Element present");
				} else {
					System.out.println("Element not present");
				}	
			}
			
			
			
			
			
			
			
			
			
			
		}

		
		
		
		
		
		
		
		
		


