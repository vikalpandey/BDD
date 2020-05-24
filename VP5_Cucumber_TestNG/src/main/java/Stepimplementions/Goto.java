package Stepimplementions;


import org.openqa.selenium.By;
import com.cucumber.listener.Reporter;
import Util.Common;
import Util.TestBase;
import Util.Utility;


public class Goto extends TestBase {
	
	
//		WebDriver driver;
//		public Goto(WebDriver driver)                        
//		{ 
//			this.driver = driver; 
//		}
//create a constructor for passing the webdriver object to all methods
// jo bhi is class ka object banayega vo driver pass karega
// passing this driver value to global driver variable

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
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_dashboard_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_dashboard_xpath"))).click();
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
				System.out.println("exception in goto - admin_Employee_W2Form =" + e);
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
		
		public void admin_EmployeeSeparation_NewSeparationForm() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waituntilPageLoadComplete(driver, 20L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_NewSeparationForm_xpath"))));
			Common.waitForLoad(driver);
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_NewSeparationForm_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_EmployeeSeparation_NewSeparationForm   ");
		} catch (Exception e) {
			System.out.println("exception in goto admin_EmployeeSeparation_NewSeparationForm  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}	
		
		public void admin_EmployeeSeparation_SeparationHistoryReport() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_SeparationHistoryReport_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("a_EmployeeSeparation_SeparationHistoryReport_breadcrumb_xpath")));
			System.out.println("goto class method completed  = admin_EmployeeSeparation_SeparationHistoryReport   ");
		} catch (Exception e) {
			System.out.println("exception in goto admin_EmployeeSeparation_SeparationHistoryReport  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}	
		
		
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
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("Preferences_usericon")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("Preferences_usericon"))).click();
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("SignOut_button")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("SignOut_button"))).click();
			Common.waitForPageLoaded(driver);
			System.out.println("goto class method completed  = SignOut   ");
			
			} catch (Exception e) {
				System.out.println("exception in goto SignOut  = "+ e);
			}
		
		}
		
		public void s_Announcements_Announcement_List() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Announcements_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Announcements_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Announcements_AnnouncementList_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Announcements_AnnouncementList_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Announcements_Announcement_List   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_Announcements_Announcement_List  = "+ e);
//			System.out.println("1  print only e= " +e); // o/p =  print only e= java.lang.NullPointerException
//			System.out.println("2 print e.getmessage="+ e.getMessage());  // o/p = 2 print e.getmessage=null
//			System.out.println("3 print e.tostring=" + e.toString());   // o/p = 3 print e.tostring=java.lang.NullPointerException
//			System.out.println("4 belos is e.printstacktrace");
//			e.printStackTrace();

		}			}
		
		
		public void s_Employee_My_Details() throws Exception {
			try {
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath")));
			Common.action(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath"))));
			Thread.sleep(3000);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_xpath")));
			driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_xpath"))).click();
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_MyDetails_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Employee_My_Details   ");
			
			} catch (Exception e) {
				System.out.println("exception in goto s_Employee_My_Details  = "+ e);
				Reporter.addStepLog("exception =" +e);
			}
		}
		
		public void s_Employee_W2form() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_W2form_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_W2form_breadcrumb_xpath")));
			Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_W2form_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = s_Employee_W2form   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_Employee_W2form  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}	
		public void s_Employee_paystub() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_paystub_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Employee_paystub_breadcrumb_xpath")));
			Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Employee_paystub_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = s_Employee_paystub   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_Employee_paystub  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}	
	
		public void s_Settings() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Settings_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Settings_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Settings_Change_PasswordPIN_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Settings_Change_PasswordPIN_breadcrumb_xpath")));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Settings_Change_PasswordPIN_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = s_Settings   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_Settings  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}	
		
		public void s_changerequestdetails() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_ChangeRequest_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_ChangeRequest_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_ChangeRequest_ChangeRequestDetails_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_ChangeRequest_ChangeRequestDetails_breadcrumb_xpath")));
			//Common.flash(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_ChangeRequest_ChangeRequestDetails_breadcrumb_xpath"))));
			System.out.println("goto class method completed  = s_changerequestdetails   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_changerequestdetails  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}	
		
		public void s_pto_ptosummary() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_PTO_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_PTO_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_PTO_ptosummary_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_PTO_ptosummary_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_pto_ptosummary   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_pto_ptosummary  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}
		public void s_pto_ptorequest() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_PTO_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_PTO_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_PTO_ptorequest_xpath"))));
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_PTO_ptorequest_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_pto_ptorequest   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_pto_ptorequest  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}
		public void s_pto_ptorequest_history() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_PTO_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_PTO_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_PTO_ptorequesthistory_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_PTO_ptorequesthistory_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_pto_ptorequest_history   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_pto_ptorequest_history  = "+ e);
			Reporter.addStepLog("exception =" +e);
		}			}
		
		public void s_Trainings_traningsummary() throws Exception {
			try {
		
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Trainings_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Trainings_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Trainings_traningsummary_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Trainings_traningsummary_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Trainings_traningsummary   ");
			} catch (Exception e) {
				System.out.println("exception in goto s_Trainings_traningsummary  = "+ e);
				Reporter.addStepLog("exception = " +e);
			}			}
		
		public void s_Onlinesupport_GenerateTicket() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_GenerateTicket_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_GenerateTicket_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Onlinesupport_GenerateTicket   ");
			} catch (Exception e) {
				System.out.println("exception in goto s_Onlinesupport_GenerateTicket  = "+ e);
				Reporter.addStepLog("exception = " +e);
				Reporter.addScenarioLog("exception  in s_Onlinesupport_GenerateTicket =" +e );
				
				
			}		}
		
		public void s_Onlinesupport_ticktstatus() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_ticktstatus_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_Onlinesupport_ticketstatus_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Onlinesupport_ticktstatus   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_Onlinesupport_ticktstatus  = "+ e);
		}			}
		public void s_Document_mydocument() throws Exception {
			try {
			Common.waitForLoad(driver);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_DocumentFAQs_xpath")));
			Common.actionclick(driver, driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_DocumentFAQs_xpath"))),
					driver.findElement(By.xpath(Utility.fetchlocatorvalue("s_DocumentFAQs_mydocument_xpath"))));
			Common.waituntilPageLoadComplete(driver, 60L);
			Common.waitForElementvisible(driver, By.xpath(Utility.fetchlocatorvalue("s_DocumentFAQs_mydocument_breadcrumb_xpath")));
			System.out.println("goto class method completed  = s_Document_mydocument   ");
		} catch (Exception e) {
			System.out.println("exception in goto s_Document_mydocument  = "+ e);
		}			}
		
		
		
	}

	
	


