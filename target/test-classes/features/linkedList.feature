Feature: LinkedList page navigation
         As user logged into DS Portal
         User want to navigate through LinkedList topics-covered page
         So that user can access explanations and the Try Here editor
  
  Scenario Outline: User on LinkedList introduction page should navigate to  all topics-covered pages 
  		Given user is on LinkedList introduction page
		When  user clicks on the "<topicsPage>" link
		Then  user should navigate to corresponding "<topicsPage>" page
				Examples:
     			 | topicsPage                     |
     			 | Introduction                   |
      			 | Creating Linked List           |
     			 | Types of Linked Lists          |
     			 | Implement Linked List in Python|
     			 | Traversal                      |
     			 | Insertion                      |
     			 | Deletion                       |

  Scenario Outline: Click on  Try here button from LinkedList topics-covered pages
   		 Given user is on the "<topicsPage>" page
    	 When  user clicks on the "Try Here" button
     	 Then  user should see a text editor displayed

    		Examples:
     			 | topicsPage                     |
     			 | Introduction                   |
      			 | Creating Linked List           |
     			 | Types of Linked Lists          |
     			 | Implement Linked List in Python|
     			 | Traversal                      |
     			 | Insertion                      |
     			 | Deletion                       |
      
   Scenario: Execute valid code in the editor
   		  Given user is on the text editor 
    	  When  user enter print statment into the editor and click run button
    	  Then  user should see print statment displayed on the console

  	Scenario: Execute invalid code in the editor
    		Given user is on the text editor page
    		When  user enter invalid syntax into the editor and click run button
    		Then  user should see Error displayed on the popup   