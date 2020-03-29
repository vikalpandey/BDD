package Stepimplementions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.Common;
import Util.TestBase;
import Util.Utility;

public class E_Employee_MyDetails_steps extends TestBase {
	By s_Employee_MyDetails_usericon_demographic_xpath= By.xpath("//a[@title='View or edit Employee Details']");         
	By Banking_Details_Tab=By.xpath("//span[contains(text(), 'Banking Details')]");
	By Banking_Details_Breadcrumb=By.xpath("//label[contains(text(), 'Banking Details')]");
	By b_addbutton= By.xpath("//input[@id='bttnAdd']");
	By b_addbank_Breadcrumb=By.xpath("//label[contains(text(), 'Add Bank')]");
	By Bank_Account_Type_saving=By.xpath("//*[@id='BankAccountTypeMasterId']");
	By b_Bank_Name= By.xpath("//input[@id='BankName']");
	By b_Deposit_Type=By.xpath("//select[@id='DepositTypeMasterId']");
	By b_Rate= By.xpath("//input[@id='Rate']");
	By b_Amount= By.xpath("//input[@id='Amount']");
	By b_BankRoutingNumber= By.xpath("//input[@id='BankRoutingNumber' and@type='text']");
	By b_lense_icon_RoutingNumber= By.xpath("//a[@id='hrfImagePopup']");
	By b_BankAccountNumber= By.xpath("//input[@id='BankAccountNumber']");
	By b_Search_Bank_Breadcrumb=By.xpath("//span[contains(text(), 'Search Bank')]");
	By b_Search_Bank_CancelButton= By.xpath("//*[@id='btnCancel']");
	By b_Search_Bank_OkButton= By.xpath("//*[@id='btnOK']");
	By b_Submit= By.xpath("//*[@id='btnBankSubmit']");
	By b_Submit_confirmation_pupup_Breadcrumb= By.xpath("//*[@id='BankDetailsPinConfirmationPopup_wnd_title']");
	

	

	

	
	
	
	
	
	
	
	
	public void Click_Usericon_s_Employee_My_Details() throws Exception {
		//Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_usericon_demographic_xpath")));
		Common.waitForElementvisible(driver, s_Employee_MyDetails_usericon_demographic_xpath);
		//-------- getting the attribue value-------------
		WebElement usericon=driver.findElement(s_Employee_MyDetails_usericon_demographic_xpath);
		System.out.println("user icon id usericon= "+ usericon);
		System.out.println("user icon id="+usericon.getAttribute("id"));
		System.out.println("user icon name="+usericon.getAttribute("name"));
		System.out.println("user icon title="+usericon.getAttribute("title"));
		System.out.println("user icon class="+usericon.getAttribute("class"));
		//---------------------
		//driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_usericon_demographic_xpath"))).click();
		Common.click(s_Employee_MyDetails_usericon_demographic_xpath);
		//Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_breadcrumb_xpath")));
		Common.waitForElementvisible(driver, s_Employee_MyDetails_usericon_demographic_xpath);
		System.out.println("method completed  = s_Employee_My_Details_UserIcon_click   ");
		Common.waitForPageLoaded(driver);
	}
	
	public void click_bankingTab()
	{
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver, Banking_Details_Tab);
		Common.click(Banking_Details_Tab);
		Common.waitForElementvisible(driver, Banking_Details_Breadcrumb);
		Common.waitForPageLoaded(driver);
	}
	public void click_Add_button_Bank() throws Exception
	{
		Common.waitForElementvisible(driver, b_addbutton);
		Common.waitForElementtobeclickable(driver, b_addbutton);
		Common.click(b_addbutton);
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver, b_addbank_Breadcrumb);
	}
	
	public void Select_Bank_Account_Type_saving()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(Bank_Account_Type_saving, "Saving");
	}
	public void Select_Bank_Account_Type_Other_Pay_Card()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(Bank_Account_Type_saving, "Other Pay Card");
	}
	public void Select_Bank_Account_Type_Checking()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(Bank_Account_Type_saving, "Checking");
	}
	public void Select_Bank_Account_Type_Avitus_Pay_Card()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(Bank_Account_Type_saving, "Avitus Pay Card");
	}
	public void Select_Bank_Account_Type_Pay_Card()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(Bank_Account_Type_saving, "Pay Card");
	}
	
	public void Fill_Bank_Name_as_SeleniumBank()
	{
		Common.waitForLoad(driver);
		Common.sendkeys(b_Bank_Name, "SeleniumBank");
	}
	
	public void Select_Deposit_Type_ALL()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(b_Deposit_Type, "ALL");
	}
	public void Select_Deposit_Type_Remainder()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(b_Deposit_Type, "Remainder");
	}
	public void Select_Deposit_Type_Dollars()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(b_Deposit_Type, "Dollars");
	}
	public void Select_Deposit_Type_Percentage()
	{
		Common.waitForLoad(driver);
		Common.Selectbyvisibletext(b_Deposit_Type, "Percentage");
	}
	public void Fill_Rate_as_5()
	{
		Common.waitForLoad(driver);
		Common.sendkeys(b_Rate, "5");
	}
	public void Fill_Amount_as_1000()
	{
		Common.waitForLoad(driver);
		Common.sendkeys(b_Amount, "1000");
	}
	public void Fill_BankRoutingNumber()
	{
		Common.waitForLoad(driver);
		Common.sendkeys(b_BankRoutingNumber, "251082330");
	}
	public void Fill_BankRoutingNumberfromexcel(String routingno)
	{
		//Common.waitForLoad(driver);
		Common.sendkeys(b_BankRoutingNumber, routingno);
	}
	public void Fill_BankAccountNumber_as_123456789()
	{
		Common.waitForLoad(driver);
		Common.sendkeys(b_BankAccountNumber, "123456789");
	}
	public void Click_lense_icon_RoutingNumber()
	{
		Common.waitForLoad(driver);
		Common.click(b_lense_icon_RoutingNumber);
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver, b_Search_Bank_Breadcrumb);
	}
	public void Click_search_bank_popup_CancelButton()
	{
		Common.waitForLoad(driver);
		Common.click(b_Search_Bank_CancelButton);
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver, b_addbank_Breadcrumb);
	}
	public void Click_search_bank_popup_OkButton()
	{
		Common.waitForLoad(driver);
		Common.click(b_Search_Bank_OkButton);
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver, b_addbank_Breadcrumb);
	}
	public void Click_Submit_Button() throws Exception
	{
		Common.waitForLoad(driver);
		Common.click(b_Submit);
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver,b_Submit_confirmation_pupup_Breadcrumb);
		driver.findElement(By.xpath("//*[@id='chkPinAcknowledgmentBank']")).click();
		driver.findElement(By.xpath("//*[@id='pinFirstBank']")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='btnBankDetailsFinalSubmit']")).click();
		Common.waitForPageLoaded(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='popup_ok']")).click();
//		Alert alert = driver.switchTo().alert();
//        alert.accept();
//		Alert simpleAlert = driver.switchTo().alert();
		
		Common.waitForPageLoaded(driver);
		Common.waitForElementvisible(driver,Banking_Details_Breadcrumb );
		
	}
	public void Click_All_checkbox_for_delete_already_exiting_routingno() throws InterruptedException
	{
		List<WebElement> dynamicElements1 = driver.findElements(By.xpath("//input[@class='checkbx']"));
		dynamicElements1.size();
		System.out.println("size of dynmic element ="+dynamicElements1.size());
		for (int i = 0; i < dynamicElements1.size(); i++) {
			System.out.println("Start value of i = "+  i);
			driver.findElement(By.xpath("//input[@class='checkbx']")).click();
			System.out.println("clicked on checkbox for delet the existing routing no ");
			Common.waitForLoad(driver);
			driver.findElement(By.xpath("//*[@id='popup_ok']")).click();
			System.out.println("clicked on confirmation pop up ok button ");
			Common.waitForLoad(driver);
			Thread.sleep(3000);
		}
	
	}
	
	
	

}
