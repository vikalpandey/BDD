Feature: Validate incedo page and do data driven testing 


#without Example keyword
#Scenario: validate data driven testing and fill many conacts 
#Given open this url "https://www.incedoinc.com/contact/"
#Then user will fill firstname as "test1"
#Then user will fill Lastname as "lastname1"
#Then User will fill officialmailas "1mail@gmail.com"  and jobtitle as "mr1"

#with Example keyword
Scenario Outline: validate data driven testing and fill many conacts 
	Given open this url "https://www.incedoinc.com/contact/" 
	Then user will fill firstname as "<firstname>" 
	Then user will fill Lastname as "<lastname>" 
	Then User will fill officialmailas "<mail>"  and jobtitle as "<jobtitle>" 
	Examples: 
	
		| firstname | lastname | mail | jobtitle |
		| 1 FN      | 1 LN     | 1mail | 1 title |
		| 2 FN      | 2 LN     | 2mail | 2 title |
		| 3 FN      | 3 LN     | 3mail | 3 title |
		
		#Result= browser launch> perform steps > browser quit > again browser launnch and repeet 
		# example keyword is applicable for entire testcase so we use datatables (use for perticulr line )
		# so ques= how to achive data driven testing without using example keyword
		
		
@vikal 
Scenario: validate data driven testing and fill many conacts 
	Given open this url "https://www.incedoinc.com/contact/" 
	Then user will fill firstname and Lastname
		| 1 FN | 1 LN |
	Then User will fill officialmailas and jobtitle 
		| 1 mail | 1 title |
	
	
		# Result > in this datatable case data belongs to only that row 
		
	
		
