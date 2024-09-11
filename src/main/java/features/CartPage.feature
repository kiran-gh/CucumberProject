@cartPage
Feature: Cart Page Functionality

  Background:
    Given User is on the cart page

  Scenario: Cart page URL validation
    Then the cart page URL should match the expected URL

  Scenario Outline: Adding a single product to the cart
    When the user clicks on the "Shop Now" button
    Then the user is redirected to the products page
    And the user searches for a product titled "<title>"
    When the user selects the desired product with a specified quantity
    And the product is added to the cart
    When the user clicks on the cart icon
    Then the total number of products in the cart page should match the cart icon count

    Examples:
      | title                     |
      | Chronograph Black Watch    |

  Scenario: Adding multiple products to the cart
    When the user clicks on the "Shop Now" button
    Then the user is redirected to the products page
    And the user adds multiple items to the cart
    When the user clicks on the cart icon
    Then the total number of products in the cart page should match the cart icon count


  Scenario: Removing a product from the cart
    When the user clicks on the "Shop Now" button
    Then the user is redirected to the products page
    And the user adds multiple items to the cart
    When the user clicks on the cart icon
    Then user deletes a product from the cart