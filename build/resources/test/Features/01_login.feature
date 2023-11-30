Feature: EQMS Login

  @login
  Scenario Outline: Login with valid data
    Given user in the login page
    When user enter '<userName>' and '<password>'
    And click login button
    Then successfully navigate to the dashboard

    Examples:
      | userName | password |
      | Rafi     | 123      |