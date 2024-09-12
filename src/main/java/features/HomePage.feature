@homePage
Feature: Home page feature
  Background:
    When user is on home page.

  Scenario: Successful user navigated to home page.
    Then home page heading should be displayed.
    And home page description should be displayed.
    And shopNow button should be displayed.

  Scenario: Successful navigation to products pages from home page.
    And user clicks on products button in the navbar.
    Then user should be able to navigate to products page.

  Scenario: Successful navigation to cart page from home page.
    And user clicks on cart button in the navbar.
    Then user should be able to navigate to cart page.

  Scenario: Successful navigation to login page from home page.
    When user clicks on logout button.
    Then user should be able to navigate to login page.