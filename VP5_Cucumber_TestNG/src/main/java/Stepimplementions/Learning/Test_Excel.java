package Stepimplementions.Learning;

import org.testng.annotations.Test;

import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.ExcelReader;
import Util.TestBase;

public class Test_Excel extends TestBase{
	LoginPage_steps lpobj=new LoginPage_steps();
	Goto go=new Goto();
//	E_Employee_MyDetails_steps mydetailsobj=new E_Employee_MyDetails_steps();
	
	@Test
	public void Testmethod_Excel() throws Exception 
	{
		TestBase.initialization();	
		try {
			lpobj.loginwith_emp1();
			// use excel reader new class methods
			System.out.println("excel start ");
			ExcelReader ex=new ExcelReader("E:\\2 Selenium\\2.1 local github for VP5 BDD\\VP5_Cucumber_TestNG\\TestData\\TestData.xlsx");
			//ex.getRowCount("Login");
			System.out.println("ex.getRowCount() method resut == "+ ex.getRowCount("Login"));
			
			System.out.println("ex.getColumnCount = "+ex.getColumnCount("Login"));
			
			String s=ex.getCellData("Login", 1, 1);
			System.out.println("ex.getCellData= "+ s);
			
			String s1=ex.getCellData("Login", "User name ", 3);
			System.out.println("ex.getCellData= "+ s1);
			
			int i=ex.getCellRowNum("Login", "User name ", "emp1@gmail.com");
					System.out.println("ex.getCellRowNum= "+ i);
					
			//ex.setCellData("Login", "Password", 5, "UserselDATA");	
			
			//ex.setCellData("Login", "Password", 6, "UserSelenium6throwDATA", "www.google.com");
			
//			ex.addSheet("VP_new_sheet");
//			ex.addColumn("VP_new_sheet", "VPNewColumn");
//			ex.addColumn("VP_new_sheet", "VP1");
//			ex.addColumn("VP_new_sheet", "VP2");
//			System.out.println("VP2 column added ");
//			ex.removeColumn("VP_new_sheet", 3);
//			System.out.println(" 3rd coumn VP2 column Removed ");
//					
//					
//					
//			System.out.println("excel End ");
//			
//			
//			
			
			
			
			
		} finally {
			Thread.sleep(1000);
			driver.quit();
		}
		
		
		
		
		
		
		
		
	}
	
	


}
