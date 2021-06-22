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

public class Ecom_Express extends TestBase {

	@Test
	public void Testmethod_NSE() throws Exception {
		TestBase.initialization();
		try {


			driver.get("https://www.nseindia.com/");

			
			
			
			
			
			
			
		} finally {
			Thread.sleep(1000);
			driver.quit();
		}

	}

}
