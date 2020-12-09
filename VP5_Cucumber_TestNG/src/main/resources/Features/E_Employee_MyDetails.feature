Feature: Test the Self> Employee > My Details> emp details page 

Scenario: Test the Employee > My Details> Employee details > Banking Details Page > add ruting no 
	Given Employee login with emp1 user 
	And emp1 go to self > Employee > My Details Page and click on User icon for go to emp demographic page 
	And emp1 click on banking deatails tab then banking details  tab should open 
	And emp1 click All checkbox for delete already exiting routingno 
	Then Emp1 click on add button then a bank details open 
	And emp1 select Bank Account Type as Saving 
	And emp1 Fill Bank Name as SeleniumBank 
	And emp1 Fill Deposit Type as Dollars 
	And emp1 Fill Rate (%) / Amount($)   
	And emp1 Fill Bank routing number as 072414284 
	And emp1 Fill Bank account no as 123456789 
	And emp1 click on Bank Deatils Submit button 
	
	
	#Scenario: Test the Routing no from excel file Employee > My Details> Employee details > Banking Details Page
	#Given Employee login with emp1 user
	#And emp1 go to self > Employee > My Details Page and click on User icon for go to emp demographic page 
	#And emp1 click on banking deatails tab then banking details  tab should open 
	#Then Emp1 click on add button then a bank details open 
	#And emp1 select Bank Account Type as Saving
	#And emp1 Fill Bank Name as SeleniumBank 
	#And Pick routing no from excel & paste in routing no and validate and update in excel 
	
	
	
	
	
	
	
