package Stepdefinitions;

import Stepimplementions.Dashboard;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Stepimplementions.Separation_steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Separation {
	LoginPage_steps loginpobj=new LoginPage_steps();
	Separation_steps sepobj=new Separation_steps();
	
	

@Given("^Login with ca(\\d+) user$")
public void login_with_ca_user(int arg1) throws Throwable {
   loginpobj.loginwith_ca1();
}

@Then("^goto separtion form and fill all details and save form$")
public void goto_separtion_form_and_fill_all_details_and_save_form() throws Throwable {
	sepobj.fill_separtionform_save();
    
}

@Then("^go to separtion history page and open form and submit it$")
public void go_to_separtion_history_page_and_open_form_and_submit_it() throws Throwable {
	sepobj.search_edit_submit_form();
   
}

}
