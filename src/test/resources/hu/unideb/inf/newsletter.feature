Feature: Automation Practice Newsletter

  Background:
    Given the home page is opened

  Scenario Outline:
    Given the 'newsletter-input' is filled with '<parameter>'
    When the Newsletter button is clicked
    Then the '<msg>' newsletter error message is shown
    Examples:
      | parameter         | msg                                                   |
      |                   | Newsletter : Invalid email address.                   |
      | invalid.email.com | Newsletter : Invalid email address.                   |
      | valid@email.com   | Newsletter : This email address is already registered.|
