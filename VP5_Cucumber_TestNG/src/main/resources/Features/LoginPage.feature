Feature: Validate the login page functionality of each type of user
@vikal
Scenario: Validate the Login functionality via employee type users 
Given login with employee user 
Then User should be on employee dashboard
#And Validate the username 


#Scenario: Validate the Login functionality via clientadmin type users 
#Given login with clientadmin user 
#Then User should be on clientadmin dashboard
#And Validate the username 
#
#Scenario: Validate the Login functionality via owner type users 
#Given login with owner user 
#Then User should be on owner dashboard
#And Validate the username 
#
#Scenario: Validate the Login functionality via systam admin type users 
#Given login with systemadmin user 
#Then User should be on systemadmin dashboard
#And Validate the username 