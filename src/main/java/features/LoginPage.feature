@loginPage
Feature: Login page feature

  Background:
    Given user is on the login page


  Scenario: Login page title
    Then user gets the title of the login page

  Scenario Outline: User enters valid credentials in login page
    When user enter "<userName>" and "<password>"
    And user clicks on Login button
    Then user navigates to home page
    Examples:
      | userName  | password |
      | rahul | rahul@2021 |

  Scenario Outline: User enters invalid credentials in login page
    When user enter "<userName>" and "<password>"
    And user clicks on Login button
    Then error message should be displayed
    Examples:
    | userName | password |
    | rahu  | rahul@2021 |
    | rahul | rahul@2022 |
    | rahu  | rahul@2022 |
    |       |            |