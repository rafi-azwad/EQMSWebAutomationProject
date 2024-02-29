Feature: Customer Complains

  @qualityApproval
  Scenario: Add functional approval
    Given click on customer complain option
    When select quality approval
    And fill in the required quality approval information
    Then save and submit the information