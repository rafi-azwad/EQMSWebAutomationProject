Feature: Customer Complains

  @investigation
  Scenario: Add investigation
    Given click on customer complain option
    When select investigation
    And fill in the required investigation information
    Then save and submit the information