package Stepimplementions.Learning;

	import java.time.Duration;
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

	public class N_JavaScriptExecutor extends TestBase {

LoginPage_steps lpobj=new LoginPage_steps();
Goto go=new Goto();
				
@Test
public void Testmethod() throws Exception {
TestBase.initialization();		
try {
						
						
//Eercise travel portal select city from suggestion list //https://www.udemy.com/course/selenium-training/learn/lecture/18873198#notes
driver.get("https://ksrtc.in/oprs-web/guest/home.do");
Common.waitForElementvisible(driver, By.xpath("//*[@id='fromPlaceName']"));
driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys("BEN");
driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
//driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

JavascriptExecutor js=(JavascriptExecutor)driver;
String script = "return document.getElementById('fromPlaceName').value;";
													
String text=(String) js.executeScript(script);
System.out.println(text);
Thread.sleep(5000);

						
//When we type BENG in the ‘Leaving From’ field, we get a lot of options in the dropdown. 
//The task here is to keep performing keyDown operation till BENGALURU INTERNATION AIRPORT gets selected.
// will use while loop the ‘text’ is not equal to BENGALURU INTERNATION AIRPORT, we will keep executing 
//the code inside the ‘while’ block. Once the text equals BENGALURU INTERNATION AIRPORT, the control out

//while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
//	driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
//	Thread.sleep(3000);
//	 text=(String) js.executeScript(script);
//	 System.out.println(text);
//}
// above code is working finedue to city match but if name not match from the list then it will be infinite loop 
//The approach that we will follow here is that: we will perform keydown operation for only 10 times viz we will 
//check just 10 options. If the match text not found in any 10 option than we will break out from the ‘while’ loop
//We initiate the counter i=0 at increment it , put an ‘if’ condition ,break at line

int i=0;
while (!text.equalsIgnoreCase("BENGALURU NATION AIRPORT")) {
	i++;
	driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
	Thread.sleep(3000);
	 text=(String) js.executeScript(script);
    // we can do usingget text method but actually text name not capture properly, however blank text is printed in console  so in this time 
   //text=driver.findElement(By.xpath("//*[@id='fromPlaceName']")).getText();
	 //use below line not up line 
	// text=driver.findElement(By.xpath("//*[@id='fromPlaceName']")).getAttribute("value");
	 
	 System.out.println(text);
	 if (i>10) 
	 break;
}

if (i>10)
	 {
		System.out.println("element not found");
	} else {
System.out.println("element found");
	}

						
						
						
						
				
//						driver.get("http://demo.guru99.com/V4/");			        		
//				        WebElement button =driver.findElement(By.name("btnLogin"));			
//				        		
//				        //Login to Guru99 		
//				        driver.findElement(By.name("uid")).sendKeys("mngr34926111");					
//				        driver.findElement(By.name("password")).sendKeys("amUpenu111");					
//				        		
//				        //Perform Click on LOGIN button using JavascriptExecutor	
//				        JavascriptExecutor  js=(JavascriptExecutor)driver;
//				      //  js.executeScript("arguments[0].click();", button);
//				                                
//				      //Fetching the Domain Name of the site. Tostring() change object to name.		
//				        String DomainName = js.executeScript("return document.domain;").toString();			
//				        System.out.println("Domain name of the site = "+DomainName);
//				      //Fetching the URL of the site. Tostring() change object to name		
//				        String url = js.executeScript("return document.URL;").toString();			
//				        System.out.println("URL of the site = "+url);
//				        //Method document.title fetch the Title name of the site. Tostring() change object to name		
//				        String TitleName = js.executeScript("return document.title;").toString();			
//				        System.out.println("Title of the page = "+TitleName);
//				        
//				      //Navigate to new Page i.e to generate access page. (launch new url)		
//				        js.executeScript("window.location = 'http://demo.guru99.com/'");
//				        Thread.sleep(3000);
//				      //Vertical scroll down by 600  pixels		
//				        js.executeScript("window.scrollBy(0,200)");	
//				        Thread.sleep(3000);
//				        //To generate Alert window using JavascriptExecutor. Display the alert message 			
//				        js.executeScript("alert('Welcome to Guru99');"); 
//
//						
//						
//						
//						
//						driver.get("https://www.gmail.com");
//						 WebElement loginButton = driver.findElement(By.xpath("//*[@id='next']"));
						 
						 /*Syntax:
						 JavascriptExecutor js = (JavascriptExecutor) driver;  
						 js.executeScript(Script,Arguments);
						 script - The JavaScript to execute
						 Arguments - The arguments to the script.(Optional)*/
						 
					//JavascriptExecutor js = (JavascriptExecutor)driver;
						 //Uncomment each scenario by using Ctrl + Shift + \ (backslash) and find the solution
						 
			    /*to type text in Selenium WebDriver without using sendKeys() method
				 js.executeScript("document.getElementById('some id').value='someValue';");
				 js.executeScript("document.getElementById('Email').value='SoftwareTestingMaterial.com';");
				 */ 
						 
			     /*//to click a button in Selenium WebDriver using JavaScript
			    //js.executeScript("arguments[0].click();", loginButton);
						   //or
			   js.executeScript("document.getElementById('enter your element id').click();");
				js.executeScript("document.getElementById('next').click();");*/
						 
				/*//to handle checkbox
			   js.executeScript("document.getElementById('enter element id').checked=false;");*/
						 
						 /*//to generate Alert Pop window in selenium
						 js.executeScript("alert('hello world');");*/
						 
						 /*//to refresh browser window using Javascript 
						 js.executeScript("history.go(0)");*/
						 
						 /*// to get innertext of the entire webpage in Selenium
						 String sText =  js.executeScript("return document.documentElement.innerText;").toString();
						 System.out.println(sText);*/
						 
						 /*//to get the Title of our webpage
						 String sText =  js.executeScript("return document.title;").toString();
						 System.out.println(sText);*/
						 
						 /*//to get the domain
						 String sText =  js.executeScript("return document.domain;").toString();
						 System.out.println(sText);*/
						 
						 /*//to get the URL of our webpage
						 String sText =  js.executeScript("return document.URL;").toString();
						 System.out.println(sText);*/
						 
						 /*//to perform Scroll on application using  Selenium
						 //Vertical scroll - down by 50  pixels
						 js.executeScript("window.scrollBy(0,50)");
						 // for scrolling till the bottom of the page we can use the code like
						 //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");*/
						 
						 /* // to click on a SubMenu which is only visible on mouse hover on Menu?
						 //Hover on Automation Menu on the MenuBar
						         js.executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");*/
						 
						 /*//to navigate to different page using Javascript?
						         //Navigate to new Page
						         js.executeScript("window.location = 'https://www.softwaretestingmaterial.com");*/
						 
					
						
						

					
						
						
					
					} finally {
						Thread.sleep(1000);
						driver.quit();
						log.info("driver.quit Done ");
					}	}}
				//........Other methods write here .........
