Feature: Automation Practice Cart page

  Background:
    Given the home page is opened

  Scenario: Empty cart
    When the Cart link is clicked
    Then the 'Your shopping cart is empty.' cart warning message is shown
