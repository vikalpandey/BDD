package Stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.Common;
import Util.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Incedodatadriven extends TestBase {
	

@Given("^open this url \"([^\"]*)\"$")
public void open_this_url(String url) throws Throwable {
  driver.get(url);
}

@Then("^user will fill firstname as \"([^\"]*)\"$")
public void user_will_fill_firstname_as(String arg1) throws Throwable {
	WebElement firstnameaboveelement= driver.findElement(By.xpath("//*[@class='contact__title']"));
	Common.scrollUpToElementByJS(driver,firstnameaboveelement );
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@name='fname']")).sendKeys(arg1);
	
   
}

@Then("^user will fill Lastname as \"([^\"]*)\"$")
public void user_will_fill_Lastname_as(String arg1) throws Throwable {
	driver.findElement(By.xpath("//*[@name='lname']")).sendKeys(arg1); 
	Thread.sleep(1000);
}
	
@Then("^User will fill officialmailas \"([^\"]*)\"  and jobtitle as \"([^\"]*)\"$")
public void user_will_fill_officialmailas_and_jobtitle_as(String arg1, String arg2) throws Throwable {
 driver.findElement(By.xpath("//*[@name='company-email']")).sendKeys(arg1);
 driver.findElement(By.xpath("//*[@name='job-title']")).sendKeys(arg2);
 Thread.sleep(3000);
}	
	


@Then("^user will fill firstname and Lastname$")
public void user_will_fill_firstname_and_Lastname(DataTable name) throws Throwable {
	WebElement firstnameaboveelement= driver.findElement(By.xpath("//*[@class='contact__title']"));
    Common.scrollUpToElementByJS(driver,firstnameaboveelement );
	Thread.sleep(3000);
   List<List<String>> namevalue =name.raw();
	driver.findElement(By.xpath("//*[@name='fname']")).sendKeys(namevalue.get(0).get(0));
	driver.findElement(By.xpath("//*[@name='lname']")).sendKeys(namevalue.get(0).get(1)); 
	Thread.sleep(1000);
}

@Then("^User will fill officialmailas and jobtitle$")
public void user_will_fill_officialmailas_and_jobtitle(DataTable mailtitledata) throws Throwable {
	List<List<String>> mailtitlevalue =mailtitledata.raw();
	 driver.findElement(By.xpath("//*[@name='company-email']")).sendKeys(mailtitlevalue.get(0).get(0));
	 driver.findElement(By.xpath("//*[@name='job-title']")).sendKeys(mailtitlevalue.get(0).get(1));
	 Thread.sleep(1000);
}
	
	

}
