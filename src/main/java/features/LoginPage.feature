@login
Feature: Login page feature

  Background:
    Given user is on the login page


  Scenario: Login page title
    Then user gets the title of the login page

  Scenario: User enters valid credentials in login page
    When user enters "<userName>" in username input filed and "<password>" in password input field
    | userName  | password |
    | rahul | rahul@2021 |
    And user clicks on Login button
    Then user navigates to home page

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