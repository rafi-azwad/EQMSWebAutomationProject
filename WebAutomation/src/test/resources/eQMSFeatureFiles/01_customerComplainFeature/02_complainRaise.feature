Feature: Customer Complains

  @complainRaise
  Scenario: Add complain raise issue
    Given click on customer complain option
    When select complain raise
    And fill in the required information
    Then save and submit the information

