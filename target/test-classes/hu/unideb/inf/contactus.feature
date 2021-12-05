Feature: Testing the ContactUs page

  Background:
    Given the home page is opened
    And the Contact Us link is clicked

  Scenario Outline:
    Given the email address is filled with "<email_address>"
    And the order reference is filled with "<ref>"
    And the message is filled with "<contactMsg>"
    When the Send button is clicked
    Then a "<msg>" error message is shown
    Examples:
      | email_address                     | ref     | contactMsg | msg                                             |
      |                                   | 4567    | Hello      | Invalid email address.                          |
      | mohammed.salim.987000@gmail.com   |         | Hello      | Please select a subject from the list provided. |
      | mohammed.salim.987000@gmail.com   | 4567    |            | The message cannot be blank.                    |
      | mohammed.salim.987000@gmail.com   | 4567    | Hello      | Please select a subject from the list provided. |
