Feature: Purchase a product
  As a logged in user
  I want to add new product to the cart and make a purchase

  @done
  Scenario Outline: Add a new user address
    Given a logged in user is on the home page
    And the user is searching Hummingbird Printed Sweater
    And the user clicks on Hummingbird Printed Sweater
    And the user
    When the user clicks Create new address button
    And the user fills the address form with "<alias>", "<first_name>", "<last_name>", "<address>", "<city>", "<zip_code>", "<country>"
    And the user clicks the Save button
    Then my addresses page should include the new address titled "<alias>"