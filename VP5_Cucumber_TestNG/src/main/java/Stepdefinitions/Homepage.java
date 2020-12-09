package Stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Stepimplementions.Homepage_steps;
import Util.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Homepage extends TestBase {

	Homepage_steps hsobj=new Homepage_steps();
	
	//Shortcut for import all cucumber @given @when use =       ctrl+shift+o
	@Given("^User is present on login page of avituent website$")
	public void user_is_present_on_login_page_of_avituent_website() throws Throwable {
	   //Assert.assertEquals(driver.getTitle(), "Avitus Net Login");
	   //System.out.println(" method 1 is running - User is present on login page of avituent website");
		hsobj.user_should_be_on_login_page_or_not();
		log.info("this is log in home page step def");
	  
	}

	@Given("^User fill username$")
	public void User_fill_username() throws Throwable {
//		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("ca1@gmail.com");
//		System.out.println(" method 2 is running - User fill username");
		hsobj.Fill_ca1_username();
	}

	@Given("^User fill password$")
	public void User_fill_password() throws Throwable {
		
		//driver.findElement(By.xpath("//input[@id='planPassword']")).sendKeys("User@1234");
		hsobj.Fill_Password();
	}
	
	@Then("^User verify the login button is present or not in loginpage$")
	public void user_verify_the_login_button_is_present_or_not_in_loginpage() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='btnGo']")).isDisplayed(), 
				"Login button is not present");
		System.out.println("***** This is Just Test Scenario for home page only ******");
	}



}
