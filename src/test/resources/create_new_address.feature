Feature: Adding new addresses
  As a logged in user
  I want to add new addresses to my account
  So that I can use them later

  @done
  Scenario Outline: Add a new user address
    Given a logged in user is on the home page
    And the user clicks on Addresses button from the footer
    When the user clicks Create new address button
    And the user fills the address form with "<alias>", "<first_name>", "<last_name>", "<address>", "<city>", "<zip_code>", "<country>", "<phone>"
    And the user clicks the Save button
    Then my addresses page should include the new address titled "<alias>"
    And the user deletes newly created address with title "<alias>"
    Examples:
      | alias          | first_name | last_name | address | city | zip_code | country        | phone     |
      | Adres pocztowy | Jan        | Kowalsky  | Moja 22 | Moje | 12-345   | United Kingdom | 123456789 |