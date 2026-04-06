Feature: Data driven testing on Orange HRM application

  Scenario Outline: To validate login functionality on OHRM
    Given Launch Orange HRM application
    When Enter user name as "<UserName>"
    When Enter password as "<Password>"
    And User clicks on login button
    Then Dashboard page should display

    Examples: 
      | UserName | Password    |
      | admin    | admin123    |
      | dharmesh | dharmesh123 |
      | admin    | admin123    |
      | meghana  | meghana123  |
