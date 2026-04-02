Feature: Login functionality on Practice Automation Page

  Background: 
    Given Open Practice Test

  Scenario: To validate login functionality with valid data
    When Enter valid user name
    When Enter valid password
    And Click on Login button
    Then Home page should display

  Scenario: To validate login functionality with invalid data
    When Enter invalid user name
    When Enter invalid password
    And Click on Submit button
    Then Error message should display
