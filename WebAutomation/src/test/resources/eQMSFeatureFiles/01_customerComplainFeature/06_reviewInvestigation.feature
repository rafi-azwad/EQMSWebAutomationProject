Feature: Customer Complains

  @reviewInvestigation
  Scenario: Add review investigation
    Given click on customer complain option
    When select review investigation
    And fill in the required review investigation information
    Then save and submit the information