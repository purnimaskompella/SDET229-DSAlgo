Feature: Arrays Introduction Page

  Background:
    Given user is signed into Arrays Introduction page

  Scenario Outline: Verify Navigation from Arrays Introduction to subtopic pages
    When user clicks on "<subTopic>" link
    Then user should be redirected to "<expectedpagetitle>" page

    Examples:
      | subTopic                  | expectedpagetitle         |
      | Arrays in Python          | Arrays in Python          |
      | Arrays Using List         | Arrays Using List         |
      | Basic Operations in Lists | Basic Operations in Lists |
      | Applications of Array     | Applications of Array     |

  Scenario Outline: Access text editor from subtopic pages
    Given user is on "<subTopic>" page
    When user clicks on Try Here button
    Then text editor should be displayed

    Examples:
      | subTopic                  |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |

  Scenario Outline: Execute valid Python code in editor
    Given user is on text editor page for corresponding "<subTopic>" page
    When user enters a valid python "<code>" and clicks Run button
    Then console should display output of "<expectedOutput>" statement

    Examples:
      | subTopic                  | code                   | expectedOutput |
      | Arrays in Python          | print('Hello, World!') | Hello, World!  |
      | Arrays Using List         | print('Hello, World!') | Hello, World!  |
      | Basic Operations in Lists | print('Hello, World!') | Hello, World!  |
      | Applications of Array     | print('Hello, World!') | Hello, World!  |

  Scenario Outline: Execute invalid Python code in editor
    Given user is on text editor page for corresponding "<subTopic>" page
    When user enters invalid python "<code>" and clicks Run button
    Then error message "<expectedMessage>" should be displayed in popup window

    Examples:
      | subTopic                  | code               | expectedMessage                  |
      | Arrays in Python          | print(Hello World) | SyntaxError: bad input on line 1 |
      | Arrays Using List         | print(Hello World) | SyntaxError: bad input on line 1 |
      | Basic Operations in Lists | print(Hello World) | SyntaxError: bad input on line 1 |
      | Applications of Array     | print(Hello World) | SyntaxError: bad input on line 1 |

  Scenario: Redirect from Applications of Array page to Practice Question link
    Given user is on Applications of Array page
    When user clicks on Practice Questions link
    Then user should be redirected to Practice Questions page

  Scenario Outline: Navigate to practice question subpages
    Given user is on Practice Questions page
    When user clicks on "<practiceQuestiontopic>" link
    Then user should be navigated to the "<PraQuestiontopic>" page

    Examples:
      | practiceQuestiontopic                   | PraQuestiontopic |
      | Search the array                        | QUESTION         |
      | Max Consecutive Ones                    | QUESTION         |
      | Find Numbers with Even Number of Digits | QUESTION         |
      | Squares of a Sorted Array               | QUESTION         |

  Scenario Outline: Run valid Python code in practice question editor
    Given user is on "<PraQuestiontopic>" page with text editor
    When user enters valid "<code>" and clicks Run button
    Then console should display "<expectedMessage>"

    Examples:
      | practiceQuestiontopic                   | code               | expectedMessage                  |
      | Search the array                        | print(Hello World) | SyntaxError: bad input on line 1 |
      | Max Consecutive Ones                    | print(Hello World) | SyntaxError: bad input on line 1 |
      | Find Numbers with Even Number of Digits | print(Hello World) | SyntaxError: bad input on line 1 |
      | Squares of a Sorted Array               | print(Hello World) | SyntaxError: bad input on line 1 |

  Scenario Outline: Run invalid syntax in practice question editor
    Given user is on "<practiceQuestiontopic>" page with text editor
    When user enters Invalid "<code>" and clicks Run button
    Then user should see "<expectedMessage>" displayed in popup window

    Examples:
      | practiceQuestiontopic                   | code               | expectedMessage                  |
      | Search the array                        | print(Hello World) | SyntaxError: bad input on line 1 |
      | Max Consecutive Ones                    | print(Hello World) | SyntaxError: bad input on line 1 |
      | Find Numbers with Even Number of Digits | print(Hello World) | SyntaxError: bad input on line 1 |
      | Squares of a Sorted Array               | print(Hello World) | SyntaxError: bad input on line 1 |
      
  Scenario Outline: Submit valid Python code in practice question editor
    Given user is on "<practiceQuestiontopic>" page with text editor
    When user enters valid "<code>" and clicks Submit button
    Then user should see "<expectedMessage>" in console

    Examples:
      | practiceQuestiontopic                   | code               | expectedMessage                  |
      | Search the array                        | print(Hello World) | SyntaxError: bad input on line 1 |
      | Max Consecutive Ones                    | print(Hello World) | SyntaxError: bad input on line 1 |
      | Find Numbers with Even Number of Digits | print(Hello World) | SyntaxError: bad input on line 1 |
      | Squares of a Sorted Array               | print(Hello World) | SyntaxError: bad input on line 1 |
      
  Scenario Outline: Submit invalid syntaxn in practice question editor
    Given user is on "<practiceQuestiontopic>" page with text editor
    When user enters invalid "<code>" and clicks Submit button
    Then user should see "<expectedMessage>" in popup window

     Examples:
      | practiceQuestiontopic                   | code               | expectedMessage                  |
      | Search the array                        | print(Hello World) | SyntaxError: bad input on line 1 |
      | Max Consecutive Ones                    | print(Hello World) | SyntaxError: bad input on line 1 |
      | Find Numbers with Even Number of Digits | print(Hello World) | SyntaxError: bad input on line 1 |
      | Squares of a Sorted Array               | print(Hello World) | SyntaxError: bad input on line 1 |