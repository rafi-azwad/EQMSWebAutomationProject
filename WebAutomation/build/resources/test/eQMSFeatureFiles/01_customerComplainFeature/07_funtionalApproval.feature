Feature: Customer Complains

  @functionalApproval
  Scenario: Add functional approval
    Given click on customer complain option
    When select functional approval
    And fill in the required functional approval information
    Then save and submit the information