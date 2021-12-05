Feature: Automation Practice login page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario: Successful Login
    Given the 'email' is filled with 'automationpractice123@outlook.com'
    And the 'passwd' is filled with 'automationpractice123'
    When the Sign In button is clicked
    Then the 'Welcome to your account. Here you can manage all of your personal information and orders.' account info message is shown
    Then the Sign Out button is clicked

  Scenario Outline: Unsuccessful login
    Given the '<field>' is filled with '<parameter>'
    And the 'passwd' is filled with '<pass>'
    When the Sign In button is clicked
    Then the '<msg>' error message is shown
    Examples:
      | field | parameter         | pass  | msg                        |
      | email |                   |       | An email address required. |
      | email | invalid.email.com |       | Invalid email address.     |
      | email | valid@email.com   |       | Password is required.      |
      | email | valid@email.com   | 12345 | Authentication failed.     |
