Feature: Customer Complains

  @complainStatus
  Scenario: Add capa status review
    Given click on customer complain option
    When select complain status
    And fill in the required complain status information
    Then see the full complain list