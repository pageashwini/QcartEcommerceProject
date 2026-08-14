Feature: Qcart online e-commerce website verification.

  Background: Launch qkart application
    Given User launch the application

  @scenario1
  Scenario: Validation All the necessary UI Elements are Present and Clickable (Login Button, Register Button, Search Text box)
    When User click on the login button
    Then user should be navigate to the login page
    When User click on the register button
    Then user should be navigate to the register page
    And Verify user is able to see search text field

  @scenario1
  Scenario:Verify the total number of images and link in QKart Home page.
    Then Verify user is able to count the total number of images and link on UI

  @scenario1
    Scenario: Verify the Placeholder in Search is Search for items/categories and page title
      And Verify user is able to  see search text field placeholder
      And Verify page title and URL contains https in URL after launching UI

  @scenario1
  Scenario: Verify user is able to login to the application
    When User click on the login button
    Then Verify user is able to logged in successfully

  @scenario1
  Scenario: Verify user is able to login to the application
    When User click on the register button
    Then User should be able to register themself
    And Verify user is able to logged in successfully with new ID

  @scenario1
  Scenario: Verify user is able to add the product into cart
    When User click on the login button
    Then Verify user is able to logged in successfully
    And Verify user is able to add the product in cart successfully
    And Verify that user is not able to add same product again into cart

  @scenario1
  Scenario: Verify user is able to add the shoe and size into cart
    When User click on the login button
    Then Verify user is able to logged in successfully
