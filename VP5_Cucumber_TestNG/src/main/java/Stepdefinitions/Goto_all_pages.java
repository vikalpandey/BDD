package Stepdefinitions;

import Stepimplementions.Dashboard;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Goto_all_pages extends TestBase {
	
	LoginPage_steps loginpobj=new LoginPage_steps();
	Dashboard dobj=new Dashboard();
	Goto go =new Goto();


@Given("^Login with empl@gmail\\.com$")
public void login_with_empl_gmail_com() throws Throwable {
   loginpobj.loginwith_emp1();
}

@Then("^Go to self tab dashboard$")
public void go_to_self_tab_dashboard() throws Throwable {
   go.s_dashboard();
}

@Then("^Go to self tab annuncement list page$")
public void go_to_self_tab_annuncement_list_page() throws Throwable {
    go.s_Announcements_Announcement_List();
}

@Then("^Go to self tab employee mydetails page$")
public void go_to_self_tab_employee_mydetails_page() throws Throwable {
  go.s_Employee_My_Details();
}

@Then("^Go to self tab employee w(\\d+) form$")
public void go_to_self_tab_employee_w_form(int arg1) throws Throwable {
  go.s_Employee_W2form();
}

@Then("^Go to self tab employee paystub$")
public void go_to_self_tab_employee_paystub() throws Throwable {
   go.s_Employee_paystub();
}

@Then("^Go to self tab settings$")
public void go_to_self_tab_settings() throws Throwable {
  go.s_Settings();
}

@Then("^Go to self tab chnage request page$")
public void go_to_self_tab_chnage_request_page() throws Throwable {
 go.s_changerequestdetails();
}

@Then("^Go to self tab pto summary$")
public void go_to_self_tab_pto_summary() throws Throwable {
 go.s_pto_ptosummary();
}

@Then("^Go to self tab pto request$")
public void go_to_self_tab_pto_request() throws Throwable {
 go.s_pto_ptorequest();
}

@Then("^Go to self tab pto request history$")
public void go_to_self_tab_pto_request_history() throws Throwable {
go.s_pto_ptorequest_history();
}

@Then("^Go to self tab traning summary$")
public void go_to_self_tab_traning_summary() throws Throwable {
go.s_Trainings_traningsummary();
}

@Then("^Go to self tab online support - genrtae ticket$")
public void go_to_self_tab_online_support_genrtae_ticket() throws Throwable {
go.s_Onlinesupport_GenerateTicket();
}

@Then("^Go to self tab online support - ticket status$")
public void go_to_self_tab_online_support_ticket_status() throws Throwable {
 go.s_Onlinesupport_ticktstatus();
}

@Then("^Go to self tab document - my document$")
public void go_to_self_tab_document_my_document() throws Throwable {
  go.s_Document_mydocument();
}
	
	

}
