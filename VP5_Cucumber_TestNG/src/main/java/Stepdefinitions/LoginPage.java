package Stepdefinitions;

import Stepimplementions.Dashboard;
import Stepimplementions.Goto;
import Stepimplementions.LoginPage_steps;
import Util.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPage extends TestBase {
	
	
	LoginPage_steps loginpobj=new LoginPage_steps();
	Dashboard dobj=new Dashboard();
	Goto go =new Goto();
	
	//Shortcut for import all cucumber @given @when use =       ctrl+shift+o
	
@Given("^login with employee user$")
public void login_with_employee_user() throws Throwable {
    loginpobj.loginwith_emp1();
    Util.Common.waitForPageLoaded(driver);
      
}

@Then("^User should be on employee dashboard$")
public void user_should_be_on_employee_dashboard() throws Throwable {
	go.selftab();
	Util.Common.waitForLoad(driver);
	Util.Common.waitForPageLoaded(driver);
	dobj.validate_emp_dashboard_currenturl();
	dobj.validate_emp_Banking_Quicklinktext(); 
}



@Given("^login with clientadmin user$")
public void login_with_clientadmin_user() throws Throwable {
    
}

@Then("^User should be on clientadmin dashboard$")
public void user_should_be_on_clientadmin_dashboard() throws Throwable {
   
}

@Given("^login with owner user$")
public void login_with_owner_user() throws Throwable {
   
}

@Then("^User should be on owner dashboard$")
public void user_should_be_on_owner_dashboard() throws Throwable {
  
}

@Given("^login with systemadmin user$")
public void login_with_systemadmin_user() throws Throwable {
   
}

@Then("^User should be on systemadmin dashboard$")
public void user_should_be_on_systemadmin_dashboard() throws Throwable {
   
}
	
	
	

}
