Feature: Purchase a product
  As a logged in user
  I want to add new product to the cart and make a purchase

  @done
  Scenario Outline: Add a new user address
    Given a logged in user is on the home page
    And the user types "<product>" and searches it
    And the user checks if product is discounted on "<discountedOn>" and clicks on it
    When the user chooses product values with "<product_count>", "<product_size>"
    And the user clicks AddToCart and ProceedToCheckout Button
    And the user makes payment
    Then the user makes a screenshot of made purchase
    Examples:
      | product                     | discountedOn | product_size | product_count |
      | Hummingbird Printed Sweater | 20%          | M            | 5             |