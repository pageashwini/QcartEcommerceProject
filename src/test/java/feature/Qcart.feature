Feature: Qcart online e-commerce website verification.

  @run
  Scenario: Verify user is able to login
    Given User launch the application
    When User click on the login button
    Then user should be navigate to the login page
    When User click on the register button
    Then user should be navigate to the register page
    And Verify user is able to see search text field