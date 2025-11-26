Feature: Sign-In

  Background:
    Given User is in Sign-Page.

  Scenario: Verify Sign-in link on Sign-In Page
    When User clicks on Sign-in link on Sign-In Page.
    Then User Sign-In page should be dispalyed.

  Scenario: Verify register link in the top right of the Sign-In.
    When User clicks on "register" link in Sign-In Page.
    Then User should be redirected to register Page.

  Scenario: Verify register! link below username and password field of Sign-In Page.
    When User clicks on "register!" link in Sign-In Page.
    Then User should be redirected to register Page.

  Scenario Outline: Verify valid Login Credentials.
    When User enters "<username>","<password>" and clicks on Login.
    Then "You are logged in" should be displayed.

    Examples:
      | username | password      |
      | Test-229 | Shivagami229. |
      | S        | Wel123Fine    |

  Scenario Outline: Verify invalid Login Credentials
    When User enters "<username>","<password>" and clicks on Login.
    Then "<Expected Message>" should be displayed.

    Examples:
      | username | password      | Expected Message              |
      | Test-229 | 123456789     | Invalid Username and Password |
      | Test-228 | Shivagami229. | Invalid Username and Password |
      | Test$229 | Shivagami229. | Invalid Username and Password |