@GoogleLinks
Feature: Google Links

  Background: 
    Given Open google in Chrome

  @SmokeTest
  Scenario: To validate About Link
    When Click on About Link
    Then About page should display

  @StoreTest
  Scenario: To validate Store Link
    When Click on Store Link
    Then Store page should display

  @GmailTest
  Scenario: To validate Gmail Link
    When Click on Gmail Link
    Then Gmail page should open

  @ImagesTest
  Scenario: To validate Images Link
    When Click on Images Link
    Then Images page should open
