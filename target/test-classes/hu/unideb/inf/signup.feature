Feature: Automation Practice Sign Up page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario Outline:
    Given the 'email_create' is filled with '<parameter>'
    When the Create an account button is clicked
    Then the '<msg>' sign up error message is shown
    Examples:
      | parameter         | msg                        |
      |                   | Invalid email address.     |
      | invalid.email.com | Invalid email address.     |
      | valid@email.com   | An account using this email address has already been registered. Please enter a valid password or request a new one.|
