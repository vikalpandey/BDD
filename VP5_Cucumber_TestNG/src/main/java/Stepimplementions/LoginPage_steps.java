package Stepimplementions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import Util.Common;
import Util.TestBase;


public class LoginPage_steps extends TestBase {
	Logger logger  = Logger.getLogger( Homepage_steps.class.getName()); 

	
	
	public void enterusername(String uname) throws Exception
	{
		driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_username_xpath"))).sendKeys(uname);	
	}
	public void enterpassword(String password) throws Exception
	{
		driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_password_xpath"))).sendKeys(password);
	}
	public void clickonLoginButton() throws Exception
	{
		driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_loginbutton_xpath"))).click();
	}
	
	
	
//--- method for fill username , password & click on sign in button single method
	public void directlogin(String username, String password) {
	try {
	WebElement userName = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_username_xpath"))); 	// Enter User Name
	userName.clear();
	userName.sendKeys(username);
	// Enter Password
	WebElement passWord = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_password_xpath")));
	passWord.clear();
	passWord.sendKeys(password);
	// Click on the Sign In Button
	WebElement signin = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_loginbutton_xpath")));
	signin.click();
	Util.Common.waitForLoad(driver);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	
	//--- method for login with employee 
		public void loginwith_emp1() {
		try {
		WebElement userName = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_username_xpath"))); 	// Enter User Name
		userName.clear();
		userName.sendKeys("emp1@gmail.com");
		// Enter Password
		WebElement passWord = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_password_xpath")));
		passWord.clear();
		passWord.sendKeys("User@1234");
		// Click on the Sign In Button
		WebElement signin = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_loginbutton_xpath")));
		signin.click();
	
		Util.Common.waitForLoad(driver);
		System.out.println("Login with emp1 done ");
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		//--- method for login with client admin 
				public void loginwith_ca1() {
				try {
				WebElement userName = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_username_xpath"))); 	// Enter User Name
				userName.clear();
				userName.sendKeys("ca1@gmail.com");
				// Enter Password
				WebElement passWord = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_password_xpath")));
				passWord.clear();
				passWord.sendKeys("User@1234");
				// Click on the Sign In Button
				WebElement signin = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_loginbutton_xpath")));
				signin.click();
				log.info("sign in by ca1 user done ");
				Util.Common.waitForLoad(driver);
				System.out.println("Login with ca1 done ");
				} catch (Exception e) {
				e.printStackTrace();
				}
				}
				//--- method for login with system admin 
				public void loginwith_sa1() {
				try {
				WebElement userName = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_username_xpath"))); 	// Enter User Name
				userName.clear();
				userName.sendKeys("sa1@gmail.com");
				// Enter Password
				WebElement passWord = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_password_xpath")));
				passWord.clear();
				passWord.sendKeys("User@1234");
				// Click on the Sign In Button
				WebElement signin = driver.findElement(By.xpath(Util.Utility.fetchlocatorvalue("login_loginbutton_xpath")));
				signin.click();
				Util.Common.waitForLoad(driver);
				System.out.println("Login with sa1 done ");
				} catch (Exception e) {
				e.printStackTrace();
				}
				}
	

}
