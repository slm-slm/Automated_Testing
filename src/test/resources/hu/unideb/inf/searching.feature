Feature: Automation Practice Search

  Background:
    Given the home page is opened

  Scenario: Successful search
    Given the 'search_query_top' is filled with 'blouse'
    When the Search button is clicked
    Then the '1 result has been found.' search result message is shown

  Scenario Outline: Unsuccessful search
    Given the 'search_query_top' is filled with '<parameter>'
    When the Search button is clicked
    Then the '<msg>' search result message is shown
    And the '<errorMsg>' search error message is shown
    Examples:
      | parameter         | msg                        | errorMsg                                       |
      |                   | 0 results have been found. | Please enter a search keyword                  |
      | nike              | 0 results have been found. | No results were found for your search "nike"   |
