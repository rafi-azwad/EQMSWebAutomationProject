Feature: Customer Complains

  @reviewInitialAssessment
  Scenario: Add review initial assessment
    Given click on customer complain option
    When select review initial assessment
    And fill in the required review of initial information
    Then save and submit the information