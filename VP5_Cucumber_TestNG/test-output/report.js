$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/Homepage.feature");
formatter.feature({
  "line": 1,
  "name": "Validate the home page of avitusnet",
  "description": "Validate the home page of avitusnet applicateion",
  "id": "validate-the-home-page-of-avitusnet",
  "keyword": "Feature"
});
formatter.before({
  "duration": 19444096900,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Open avitusenet aplcation \u0026 validate the text boxes",
  "description": "",
  "id": "validate-the-home-page-of-avitusnet;open-avitusenet-aplcation-\u0026-validate-the-text-boxes",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is present on login page of avituent website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User fill username",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User fill password",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User verify the login button is present or not in loginpage",
  "keyword": "Then "
});
formatter.match({
  "location": "Homepage.user_is_present_on_login_page_of_avituent_website()"
});
formatter.result({
  "duration": 575321500,
  "status": "passed"
});
formatter.match({
  "location": "Homepage.User_fill_username()"
});
formatter.result({
  "duration": 606451300,
  "status": "passed"
});
formatter.match({
  "location": "Homepage.User_fill_password()"
});
formatter.result({
  "duration": 173093900,
  "status": "passed"
});
formatter.match({
  "location": "Homepage.user_verify_the_login_button_is_present_or_not_in_loginpage()"
});
formatter.result({
  "duration": 42557000,
  "status": "passed"
});
formatter.after({
  "duration": 1424421100,
  "status": "passed"
});
});