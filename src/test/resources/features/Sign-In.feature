Feature: Sign-In

  Background: 
  	Given User is in Sign-Page.

  Scenario: Verify Sign-in link on Sign-In Page
    When User clicks on Sign-in link on Sign-In Page.
    Then User Sign-In page should be dispalyed.

  Scenario: Verify register link in the top right of the Sign-In Page.
    When User clicks on "register" link in Sign-In Page.
    Then User should be redirected to register Page.

  Scenario: Verify register! link below username and password field of Sign-In Page.
    When User clicks on "register!" link in Sign-In Page.
    Then User should be redirected to register Page.


  @SiginExcelDataDriven
  Scenario: Verify Login with valid and invalid credentials from Excel.
    When User enters username,password and clicks on Login.
    Then Expected message in excel should be displayed.

  Scenario Outline: Verify Login Credentials.
    When User enters Login Credentials.
    | Test-229 | Shivagami229. |
    Then "You are logged in" message should be displayed on home Page.
    
     
