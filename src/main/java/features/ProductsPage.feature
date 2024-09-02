@products
Feature: Products page

#  Below list of scenarios are for Exclusive prime deals products section
  Scenario: Exclusive prime deals section.
    When user is on products page.
    Then user exclusive prime deals heading should be displayed.
    And all the list of products under prime deals should be displayed.

  Scenario: EPD total products images check.
    When user is on products page.
    Then all the EPD product images should be displayed.

  Scenario: EPD total products titles check.
    When user is on products page.
    Then all the EPD product titles should be displayed.

  Scenario: EPD total products brands check.
    When user is on products page.
    Then all the EPD product brands should be displayed.

  Scenario: EPD total products price check.
    When user is on products page.
    Then all the EPD product prices should be displayed.

#    Below list of scenarios are for All products section
  Scenario: All products section.
    When user is on products page.
    Then all products main heading element should be displayed.
    And all the products under all products section should be displayed.

  Scenario: All products section, all product images check
    When user is on products page.
    Then all product images should be displayed under all products section.

  Scenario: All products section, all product titles check
    When user is on products page.
    Then all product titles should be displayed under all products section.

  Scenario: All products section, all product brands check
    When user is on products page.
    Then all product brands should be displayed under all products section.

  Scenario: All products section, all product prices check
    When user is on products page.
    Then all product prices should be displayed under all products section.

