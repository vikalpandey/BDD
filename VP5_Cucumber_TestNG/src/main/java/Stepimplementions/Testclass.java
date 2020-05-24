package Stepimplementions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Stepdefinitions.Hooks;
import Util.Common;
import Util.Constant;
import Util.ExcelUtils;
import Util.TestBase;

public class Testclass extends TestBase {
	LoginPage_steps lpobj=new LoginPage_steps();
	Goto go=new Goto();
	E_Employee_MyDetails_steps mydetailsobj=new E_Employee_MyDetails_steps();
	

	@Test
	public void Testmethod() throws Exception {
		TestBase.initialization();		
		try {
			lpobj.loginwith_ca1();
			log.info("log.info in test class");
			driver.quit();
		//	go.admintab();
		//	go.admin_EmployeeSeparation_NewSeparationForm();
			//fill all fields > click on save > go to history > open saved file > submit > downoad pdf >
			//go history page check status > check mail pdf
			By Clientlabel=By.xpath("//label[contains(text(), 'Client')]");
			By Client=By.xpath("//input[@id='AutoComplete']");
			By Client_autocomplete_list=By.xpath("//ul[@id='AutoComplete_listbox']");
			By completed_by_label=By.xpath("//label[contains(text(), 'Completed By')]");
			By completed_by_textbox=By.xpath("//input[@id='txtCompletedBy' and @name='CompletedBy']");
			By employeename_label=By.xpath("//label[contains(text(), 'Employee Name')]");
			By employeename_textbox=By.xpath("//input[@id='EmployeeAutoComplete' and @name='EmployeeAutoComplete']");
			By employeename_Listbox=By.xpath("//ul[@id='EmployeeAutoComplete_listbox']");
			By employeename_Listbox_li=By.xpath("//ul[@id='EmployeeAutoComplete_listbox']/li");
			By employeename_Listbox_popup=By.xpath("//div[contains(text(), 'This employee already has been initiated or processed for separation.')]"); 
			By PrimaryEmail=By.xpath("//input[@id='txtWorkEmail' and @name='WorkEmail']");
			By Hiredate=By.xpath("//input[@name='OriginalHireDate']");
			By LastDayofwork =By.xpath("//input[@name='ActualLastDayWork' and @data-role='datepicker' ]");
			By LastDayofwork_calander_icon=By.xpath("//*[@id='txtActualLastDayWork']//ancestor::span//span[@class='k-icon k-i-calendar']");
			By SeparationDate=By.xpath("//input[@name='SeparationEffectiveDate' and @data-role='datepicker' ]");
			By SeparationDate_calander_icon=By.xpath("//*[@id='txtEffectiveDate']//ancestor::span//span[@class='k-icon k-i-calendar']");
			By calander_locator_day=By.xpath("//*[@class='k-link']");
			By FinalHoursDue_textbox_id=By.id("txtFinalHoursDue");
			By VacationHoursDue_textbox_id=By.id("txtVacationHoursDue");
			By FinalRateofPay_textbox_id=By.id("txtFinalPayRate");
			By Grossamountofpaycheck_textbox_id=By.id("txtPayCheckAmount");
			By Voluntary_check_id=By.id("Chk_Voluntary");
			By Personalreasons_vcheck_id=By.id("Chk_66");
			By Illness_vcheck_id=By.id("Chk_67");
			By Leavingthearea_vcheck_id=By.id("Chk_68");
			By otheremployment_vcheck_id=By.id("Chk_69");
			By Attendingschool_vcheck_id=By.id("Chk_70");
			By Retirement_vcheck_id=By.id("Chk_72");
			By Explain_vtextbox_xpath=By.name("txtVoluntaryComments");
			
			By InVoluntary_check_id=By.id("Chk_InVoluntary");
			By Absenteeism_invcheck_id=By.id("Chk_53");
			By Tardiness_invcheck_id=By.id("Chk_54");
			By Violationofcompanyrule_invcheck_id=By.id("Chk_55");
			By Dishonesty_invcheck_id=By.id("Chk_56");
			By Negligence_invcheck_id=By.id("Chk_57");
			By Insubordination_invcheck_id=By.id("Chk_58");
			By Inabilityornotqualified_invcheck_id=By.id("Chk_59");
			By Explain2_invtextbox_xpath=By.name("txtInVoluntaryComments");
			
			By savebutton_id=By.id("bttn_Save");
			By submitbutton_id=By.id("bttn_Submit");
			
			By popuptext_saved_successfully=By.xpath("//div[contains(text(), 'Employee separation details has been saved successfully.')]");
			By popup_ok_click=By.xpath("//input[@id='popup_ok']");
			
			
			 By Client_serchbox=By.xpath("//input[@id='AutoComplete']");
			 By Client_autocompletebox_historyPage=By.xpath("//ul[@id='AutoComplete_listbox']");
			 By employee_searchbox=By.xpath("//input[@id='EmployeeAutoComplete']");
			 By search_button=By.xpath("//input[@id='btnSearch']");
			 By eyeicon=By.xpath("//a[@title='View employee separation details']");
			 
			 By edit=By.xpath("//input[@id='btnEdit']");
			 By popup_suretosubmit_text=By.xpath("//div[contains(text(), 'Are you sure you want to submit separation data?')]");
			 By popup_sure_ok=By.xpath("//input[@id='popup_ok']");
			 By popup_sure_cancel=By.xpath("//input[@id='popup_cancel']");
			 
			 By pin=By.xpath("//input[@id='pinFirst']");
			 By pin_submit=By.xpath("//input[@id='btnFinalSubmit']");
			 By popup_confirm_mailsend_text=By.xpath("//div[contains(text(), 'Notification emails regarding the separation have been sent to your HR and Payroll specialists.')]");
			 By popup_OK_button_confirm_mailsend=By.xpath("//input[@id='popup_ok']");
			 
			 
			 

			 
			
			
			
			
			
			
	/*		
		
			Common.waitForElementvisible(driver, Clientlabel);
			Common.waitForElementvisible(driver, Client);
			Common.sendkeys(Client, "am");
			Common.waitForElementvisible(driver, Client_autocomplete_list);
			Common.selectOptionWithText("Vikal`s Boost (AM1)",Client_autocomplete_list);
			Common.waituntilPageLoadComplete(driver, 20L);
			
			Common.waitForElementvisible(driver, completed_by_textbox);
			Common.sendkeys(completed_by_textbox, "VP completed by text box ");
			Common.waituntilPageLoadComplete(driver, 3L);
			
			Common.waitForElementvisible(driver, employeename_textbox);
			Common.sendkeys(employeename_textbox, "am1");
			Common.waituntilPageLoadComplete(driver, 2L);
			Thread.sleep(3000);
			Common.selectOptionWithIndex(2,employeename_Listbox,employeename_Listbox_li );
			Common.waituntilPageLoadComplete(driver, 40L);

			
			Common.waitForElementvisible(driver, PrimaryEmail);
			//WebElement PrimaryEmail=driver.findElement(By.xpath("//input[@id='txtWorkEmail' and @name='WorkEmail']"));
			WebElement PrimaryEmailvar =driver.findElement(PrimaryEmail);
			System.out.println("PrimaryEmailvar_text= "+PrimaryEmailvar.getAttribute("value"));
			
			WebElement hiredate_var=driver.findElement(Hiredate);
			System.out.println("hire date var text = "+ hiredate_var.getAttribute("value"));
			
			// lastdaye of work and separation date
			Common.waitForElementvisible(driver, LastDayofwork);
			Common.sendkeys(LastDayofwork, "4/19/2020");
			Common.click(SeparationDate_calander_icon);
			System.out.println("start HandleKendoDateTimePicker");
			Common.HandleKendoDateTimePicker_Calander("15", calander_locator_day);
			System.out.println("End HandleKendoDateTimePicker");
			
			Common.waitForElementvisible(driver, FinalHoursDue_textbox_id);
			Common.sendkeys(FinalHoursDue_textbox_id, "1");
			Common.waitForElementvisible(driver, VacationHoursDue_textbox_id);
			Common.sendkeys(VacationHoursDue_textbox_id, "2");
			Common.waitForElementvisible(driver, FinalRateofPay_textbox_id);
			Common.sendkeys(FinalRateofPay_textbox_id, "3");
			Common.waitForElementvisible(driver, Grossamountofpaycheck_textbox_id);
			Common.sendkeys(Grossamountofpaycheck_textbox_id, "4");
*/		
			 
//			Common.click(Voluntary_check_id);
//			Common.click(Personalreasons_vcheck_id);
//			Common.click(Illness_vcheck_id);
//			Common.click(Leavingthearea_vcheck_id);
//			Common.click(otheremployment_vcheck_id);
//			Common.click(Attendingschool_vcheck_id);
//			Common.click(Retirement_vcheck_id);
//			Common.sendkeys(Explain_vtextbox_xpath, "explain 1 text box ");
//			
//			Common.click(InVoluntary_check_id);
//			Common.click(Absenteeism_invcheck_id);
//			Common.click(Tardiness_invcheck_id);
//			Common.click(Violationofcompanyrule_invcheck_id);
//			Common.click(Dishonesty_invcheck_id);
//			Common.click(Negligence_invcheck_id);
//			Common.click(Insubordination_invcheck_id);
//			Common.sendkeys(Explain2_invtextbox_xpath, "explain 2");
//			
//			System.out.println("form filled and click on save button");
//			Common.click(savebutton_id);
//			Common.waituntilPageLoadComplete(driver, 30L);
//			Common.waitForElementvisible(driver, popuptext_saved_successfully);
//			Common.click(popup_ok_click);
//			
//			go.admin_EmployeeSeparation_SeparationHistoryReport();
//			Common.waituntilPageLoadComplete(driver, 40L);
//			
//			Common.sendkeys(Client_serchbox, "am1");
//			Common.selectOptionWithText("Vikal`s Boost (AM1)", Client_autocompletebox_historyPage);
//			Common.waituntilPageLoadComplete(driver, 30L);
//			Common.waitForElementvisible(driver, search_button);
//			Common.waitForElementtobeclickable(driver, search_button);
//			Common.click(search_button);
//			
//			Common.waituntilPageLoadComplete(driver, 30L);
//			Common.waitForElementvisible(driver, eyeicon);
//			Common.click(eyeicon);
//			
//			Common.waituntilPageLoadComplete(driver, 30L);
//			Common.waitForElementvisible(driver, edit);
//			
//			Common.click(edit);
//			Common.waituntilPageLoadComplete(driver, 15L);
//			Common.waitForElementvisible(driver, submitbutton_id);
//			
//			Common.click(submitbutton_id);
//			Common.waitForElementvisible(driver, popup_suretosubmit_text);
//			Common.click(popup_sure_ok);
//			
//			Common.waitForElementvisible(driver, pin);
//			Common.sendkeys(pin, "1234");
//			Common.click(pin_submit);
//			
//			Common.waituntilPageLoadComplete(driver, 50L);
//			Common.waitForElementvisible(driver, popup_confirm_mailsend_text);
//			Common.click(popup_OK_button_confirm_mailsend);
//			System.out.println("scenario completed");
		
			
			
			//-- click on each check box using loop Start 
			List<WebElement> checkboxlist=driver.findElements(By.xpath("//input[@type='checkbox']"));		
			for (WebElement webElement : checkboxlist) {
				webElement.click();
				System.out.println("click");
			}
	
			//-- click on each check box using loop End 			
			

			
			
			Thread.sleep(10000);
			System.out.println("end");
		
		} finally {
			Thread.sleep(1000);
			driver.quit();
		}	}
	//.................

	
	public void methoda()
	{
		System.out.println("this is methda");
	}
	
	
	
	
	//.................
	
	
	
}




