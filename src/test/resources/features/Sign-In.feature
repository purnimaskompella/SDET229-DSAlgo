Feature: Sign-In


Rule: Verify Sign-in Link

 
  	Background:
			 Given The user opens DSAlgo portal link
    		 When The User clicks on GetStarted
    		 Then User should navigate to Home page
             
             
    Scenario: Verify Sign-in link on Home Page
  
 			
 			When  User clicks on Sign-in link
 			Then  User should be in Sign-in Page
 			
Rule: Verify  register link and Login credentials.

		Background:
			 Given The user opens DSAlgo portal link.
    		 When The User clicks on GetStarted.
    		 
    		 
    		 And  User clicks on Sign-in link.
    		 
    	Scenario: Verify register link on Sign-in Page.
    	     
    	     When User clicks on register link on Sign-in Page.
    	     Then User should be redirected to register Page.
    	     
    	Scenario: Verify register! link on Sign-in Page.
    	
    	     When User clicks on register link on Sign-in Page.
    	     Then User should be redirected to register Page.
    	      
    	 Scenario: Verify leading text for register! link on sign-in Page.
    	     
    	     Then Validate the leading text for register! link. 
    	     
    	     
    	  Scenario Outline: Verify valid Login Credentials.
    		
    		Given User is in Sign-in Page
    		When  User enters valid credentials and clicks on Login
    		Then  "You are logged in" message should be displayed on home Page.
    		
    		Examples:
			  | username | password  |               
		      | Test-229 | Shivagami229.|
		      |Howareyou@gmail.com.HopeYouaredoinggood+andingoodhealth-welcomeTOnumphyNinja_happylearningandGoodLUCK.SeeYouSoon._Nicetoseeyou.ThankYOUforallthe123goo|Welcome123.|
			  |S|Wel123Fine|
			  
	     Scenario: Verify invalid Login Credentials	  
	    
	    	Given User is in Sign-in Page
    		When  User enters invalid credentials and clicks on Login
    		
    			| Test-229 | 123456789  |Invalid Username and Password|
    			| Test-228 | Shivagami229.  |Invalid Username and Password|
    			|Test$229|Shivagami229.|Invalid Username and Password|
    			|||Please fill out this field|
    			
    		Then  Expected Message should be displayed   
    	           	 
    		 
 			 
    	
		      
		      
    		
    			
 			
  