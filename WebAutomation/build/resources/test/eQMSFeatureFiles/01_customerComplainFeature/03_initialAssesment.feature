Feature: Customer Complains

  @initialAssessment
  Scenario: Add initial assessment
    Given click on customer complain option
    When select initial assessment
    And fill in the required initial information
    Then save and submit the information