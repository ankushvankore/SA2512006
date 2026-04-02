Feature: Search functionality on Google

  Scenario: To validate search functionality on Google
    Given Open Google
    When Enter a keyword to search
    #When Hit Enter key
    And Hit Enter key
    Then A valid search result should display
