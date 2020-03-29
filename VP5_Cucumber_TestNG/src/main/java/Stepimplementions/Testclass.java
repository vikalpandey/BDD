package Stepimplementions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Stepdefinitions.Hooks;
import Util.Common;
import Util.Constant;
import Util.ExcelUtils;
import Util.TestBase;

public class Testclass extends TestBase {
	LoginPage_steps lpobj=new LoginPage_steps();
	//Hooks hobj=new Hooks();
	Goto go=new Goto();
	E_Employee_MyDetails_steps mydetailsobj=new E_Employee_MyDetails_steps();
	

	@Test
	public void Testmethod() throws Exception {
		//hobj.initialization();
		TestBase.initialization();
		//lpobj.loginwith_emp1();
		
				
		
		try {
			lpobj.loginwith_ca1();
			Thread.sleep(2000);
			go.admintab();
			//a_clients_xpath=//div[@class='menuWrap' and @id='second']//span[text()='Client']
				//	s_Employee_xpath=//span[contains(text(), 'Employee ')]
			go.admin_Employee_EmployeeList();
			go.admin_Employee_W2Form();
			go.admin_Employee_PayStub();
			
			
	
		
		
		
		
		

		
		} finally {
			Thread.sleep(1000);
			driver.quit();
		}
		
	}
}
