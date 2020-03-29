package Stepimplementions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.google.common.base.Predicate;
import Util.Common;
import Util.TestBase;
import Util.Utility;


public class Goto extends TestBase {
	
//		WebDriver driver;
//		public Goto(WebDriver driver)
// create a constructor for passing the webdriver object to all methods
//		{ // jo bhi is class ka object banayega vo driver pass karega
//			this.driver = driver; // passing this driver value to global driver
//									// variable
//		}

		public void admintab() throws Exception {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("admintab_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("admintab_xpath"))).click();
			System.out.println("goto class method completed = clicked on admin tab ");
		}

		public void selftab() throws Exception {
			Thread.sleep(8000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("selftab_xpath")));
			//Common.waitForElementtobeclickable(driver,By.xpath(Utility.fetchlocatorvalue("selftab_xpath")) );
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("selftab_xpath"))).click();
			System.out.println("goto class method completed = clicked on self tab ");
		}
		public void s_dashboard() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s__dashboard_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("s__dashboard_xpath"))).click();
			System.out.println("goto class method completed = clicked on self dashboard ");
		}
		

		public void admin_dashboard() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_dashbard_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_dashbard_xpath"))).click();
			System.out.println("goto class method completed = admin_dashboard ");
		}

		public void admin_Announcements_Add_Announcement() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_announ_xpath")));
			Thread.sleep(4000);
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_announ_xpath"))));
			Thread.sleep(4000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_announ_addann_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_announ_addann_xpath"))).click();

			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_announ_addann_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_Announcements_Add_Announcement   ");
		}

		public void admin_Announcements_Announcement_List() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_announ_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_announ_xpath"))));

			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_announ_annlist_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_announ_annlist_xpath"))).click();

			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_announ_annlist_breadcrumb_xpath")));
			System.out.println("goto class method completed = admin_Announcements_Announcement_List ");
		}

		public void admin_Client_Client_List() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))));
			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_list_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_list_xpath"))).click();

			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_list_breadcrumb_xpath")));
			System.out.println("goto class method completed = admin_Client_Client_List ");
		}

		public void admin_Client_Add_Client() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))));
			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_list_add_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_list_add_xpath"))).click();

			Common.waitForElementvisible(driver,
					By.xpath(Utility.fetchlocatorvalue("a_clients_list_add_breadcrumb_xpath")));
			System.out.println("goto class method completed = admin_Client_Add_Client    ");
		}

		public void admin_Client_Division_List() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))));
			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_divlist_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_divlist_xpath"))).click();

			Common.waitForElementvisible(driver, By.xpath("//*[contains(text(), ' Client > Division List')]"));
			System.out.println("goto class method completed = admin_Client_Division_List    ");
		}

		public void admin_Client_Add_Division() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))));
			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_adddiv_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_adddiv_xpath"))).click();

			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_adddiv_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_Client_Add_Division   ");
		}
	//using by methods
		public void admin_Client_dep_list() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_deplist_xpath"))).click();
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_deplist_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_Client_dep_list   ");
		}

		public void admin_Client_Add_dep() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_adddep_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_adddep_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_Client_Add_dep   ");
		}

		public void admin_Client_ClientProfile() throws Exception {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_clients_ClientProfile_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_clients_ClientProfile_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_Client_ClientProfile   ");
		}
		public void admin_Employee_EmployeeList() throws Exception {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_Employee_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_EmpList_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_Employee_EmpList_breadcrumb_xpath")));
			Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_EmpList_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = admin_Employee_EmployeeList   ");
		}
		public void admin_Employee_W2Form() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_Employee_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_W2Form_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_Employee_W2Form_breadcrumb_xpath")));
			Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_W2Form_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = admin_Employee_W2Form   ");
			
			} catch (Exception e) {
				System.out.println("exception =" + e);
				System.out.println("some exception occour in go to class - admin_Employee_W2Form");
			}
			
		}
		public void admin_Employee_PayStub() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_Employee_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_Paystub_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_Employee_Paystub_breadcrumb_xpath")));
			Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_Employee_Paystub_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = admin_Employee_PayStub   ");
		} catch (Exception e) {
			System.out.println("exception ="+ e);
			System.out.println("some exception occour in go to class - admin_Employee_PayStub");
		}
			
		}	
		
		
		
		public void Preferences_page() throws Exception {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("Preferences_usericon")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("Preferences_usericon"))).click();
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("Preferences_button")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("Preferences_button"))).click();
			Common.waitForPageLoaded(driver);
			System.out.println("goto class method completed  = Preferences_page   ");
		}	
		
		public void SignOut() throws Exception {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("Preferences_usericon")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("Preferences_usericon"))).click();
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("SignOut_button")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("SignOut_button"))).click();
			Common.waitForPageLoaded(driver);
			System.out.println("goto class method completed  = SignOut   ");
		
		}
		
		public void s_Employee_My_Details() throws Exception {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath"))));
			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_xpath"))).click();

			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Employee_My_Details   ");
		}

		
		
	}

	
	


