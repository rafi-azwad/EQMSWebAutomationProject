Feature: Impact Assessment

  @impactAssessment
  Scenario: Add Impact Assessment information
    Given click on change control option
    When select impact assessment
    And fill in the impact assessment information
    Then save and submit impact assessment's the information