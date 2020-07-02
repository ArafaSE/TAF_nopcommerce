Feature: Automated End2End Tests
  Description: Test End to End integration

  Scenario Outline: Customer place an order by purchasing an item from search
    Given user is on Home Page
    When he search for "<productName>"
    And choose to buy two items
    And move to checkout cart and enter personal details on checkout page and place the order
    Then he can view the order and download the invoice

    Examples:
      | productName                 |
      | Apple MacBook Pro 13-inch |
