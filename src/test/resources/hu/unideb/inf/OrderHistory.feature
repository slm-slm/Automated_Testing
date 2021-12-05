Feature: Automation Practice Order History Page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario: Order History with Authentication
    Given the 'email' is filled with 'automationpractice123@outlook.com'
    And the 'passwd' is filled with 'automationpractice123'
    When the Sign In button is clicked
    Then the 'Welcome to your account. Here you can manage all of your personal information and orders.' account info message is shown
    When the Order History button is clicked
    Then the 'You have not placed any orders.' order history warning message is shown
    Then the Sign Out button is clicked
