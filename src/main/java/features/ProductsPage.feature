@productsPage
Feature: Products page

  Background:
    When user is on products page
#  Below list of scenarios are for Exclusive prime deals products section

  Scenario: Exclusive prime deals section check.
    Then user exclusive prime deals heading should be displayed
    And all products under exclusive prime deals should be displayed.

#  Below list of scenarios are for Category section
  Scenario: Category section check.
    Then category heading should be displayed
    And all categories under category section should be displayed.

#  Below list of scenarios are for Ratings section
  Scenario: Rating check.
    And ratings heading should be displayed
    And all ratings under ratings section should be displayed

#    Below list of scenarios are for All products section
  Scenario: All products section.
    Then all products main heading element should be displayed
    And all products under All products section should be displayed

  Scenario Outline: Search for any specific product using title of the product
    And searches for a specific product with "<title>"
    Then the product with the searched title should be present in the list of items.

  Examples:
    | title |
    | Chronograph black Watch |

  Scenario: Search for a specific rating products.
    And clicks on any specific rating under category list
    Then all the products with specified rating should be displayed.