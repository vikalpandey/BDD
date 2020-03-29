package Stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Stepimplementions.Dashboard;
import Stepimplementions.E_Employee_MyDetails_steps;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.Constant;
import Util.ExcelUtils;
import Util.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class E_Employee_MyDetails extends TestBase {
	
	LoginPage_steps loginpobj=new LoginPage_steps();
	Dashboard dobj=new Dashboard();
	Goto go =new Goto();
	E_Employee_MyDetails_steps mydetailsobj=new E_Employee_MyDetails_steps();
	
	@Given("^Employee login with emp(\\d+) user$")
	public void employee_login_with_emp_user(int arg1) throws Throwable {
		loginpobj.loginwith_emp1();
	
	}

	@Given("^emp(\\d+) go to self > Employee > My Details Page and click on User icon for go to emp demographic page$")
	public void emp_go_to_self_Employee_My_Details_Page_and_click_on_User_icon_for_go_to_emp_demographic_page(int arg1) throws Throwable {
	 go.selftab();
	 go.s_Employee_My_Details();
	 System.out.println("open my details page ");
	 mydetailsobj.Click_Usericon_s_Employee_My_Details();
	
	}

	@Given("^emp(\\d+) click on banking deatails tab then banking details  tab should open$")
	public void emp_click_on_banking_deatails_tab_then_banking_details_tab_should_open(int arg1) throws Throwable {
		mydetailsobj.click_bankingTab();
		
		
	}
	
	@Given("^emp(\\d+) click All checkbox for delete already exiting routingno$")
	public void emp_click_All_checkbox_for_delete_already_exiting_routingno(int arg1) throws Throwable {
	    mydetailsobj.Click_All_checkbox_for_delete_already_exiting_routingno();
	}

	@Then("^Emp(\\d+) click on add button then a bank details open$")
	public void emp_click_on_add_button_then_a_bank_details_open(int arg1) throws Throwable {
		mydetailsobj.click_Add_button_Bank();
	}

	@Then("^emp(\\d+) select Bank Account Type as Saving$")
	public void emp_select_Bank_Account_Type_as_Saving(int arg1) throws Throwable {
		mydetailsobj.Select_Bank_Account_Type_saving();
	   
	}

	@Then("^emp(\\d+) Fill Bank Name as SeleniumBank$")
	public void emp_Fill_Bank_Name_as_SeleniumBank(int arg1) throws Throwable {
		mydetailsobj.Fill_Bank_Name_as_SeleniumBank();
	}

	@Then("^emp(\\d+) Fill Deposit Type as Dollars$")
	public void emp_Fill_Deposit_Type_as_Dollars(int arg1) throws Throwable {
		mydetailsobj.Select_Deposit_Type_Dollars();
	}

	@Then("^emp(\\d+) Fill Rate \\(%\\) / Amount\\(\\$\\)$")
	public void emp_Fill_Rate_Amount_$(int arg1) throws Throwable {
		mydetailsobj.Fill_Amount_as_1000();
	}

	@Then("^emp(\\d+) Fill Bank routing number as (\\d+)$")
	public void emp_Fill_Bank_routing_number_as(int arg1, int arg2) throws Throwable {
		mydetailsobj.Fill_BankRoutingNumber();
	}

	@Then("^emp(\\d+) Fill Bank account no as (\\d+)$")
	public void emp_Fill_Bank_account_no_as(int arg1, int arg2) throws Throwable {
		mydetailsobj.Fill_BankAccountNumber_as_123456789();
	}

	@Then("^emp(\\d+) click on Bank Deatils Submit button$")
	public void emp_click_on_Bank_Deatils_Submit_button(int arg1) throws Throwable {
		mydetailsobj.Click_Submit_Button();
	}
	@Then("^Pick routing no from excel & paste in routing no and validate and update in excel$")
	public void pick_routing_no_from_excel_paste_in_routing_no_and_validate_and_update_in_excel() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "All");
		for (int i = 4; i < 8; i++) {
			System.out.println("inside for loop and i =" +i);
			String celldataroutingno    =ExcelUtils.getCellData(i, 0);
			mydetailsobj.Fill_BankRoutingNumberfromexcel(celldataroutingno);
			WebElement webElement = driver.findElement(By.xpath("//input[@id='BankRoutingNumber' and@type='text']"));
			webElement.sendKeys(Keys.TAB);
			//Thread.sleep(2000);			
			List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[contains(text(), 'Invalid routing number.  Please review the value entered against your deposit slip or bank documentation for this account.')]"));
			if(dynamicElement.size() != 0){
			 //If list size is non-zero, element is present
			 System.out.println("Element present");
			 driver.findElement(By.xpath("//*[@id='popup_ok']")).click();
			 ExcelUtils.setCellData("Fail", i, 1);
			}
			else{
			 //Else if size is 0, then element is not present
				ExcelUtils.setCellData("Pass", i, 1);
			}		
		}
		System.out.println("Outside for loop and ");
		mydetailsobj.Fill_BankAccountNumber_as_123456789();
		
	}
	
	

}
