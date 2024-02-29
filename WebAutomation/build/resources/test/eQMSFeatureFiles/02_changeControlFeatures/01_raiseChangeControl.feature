Feature: Change Control

  @raiseChangeControl
  Scenario: Add raise change control information
    Given click on change control option
    When select raise change control
    And fill in the raise Change Control information
    Then save and submit raise change control's the information
