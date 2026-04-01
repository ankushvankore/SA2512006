Feature: Google Title

  Scenario: To validate title of Google
    Given Launch Google
    When Read the title
    Then Title should be Google
