@login
Feature: Login page feature

  Background:
    Given user is on the login page


  Scenario: Login page title
    Then user gets the title of the login page

  Scenario: Login with correct credentials
    When user enters username
    And user enters password
    And user clicks on Login button
    Then user navigates to home page

  Scenario: Login with in-valid username
    When user enters invalid username
    And user enters password
    And user clicks on Login button
    Then error message should be displayed

  Scenario: Login with in-valid password
    When user enters username
    When user enters invalid password
    And user clicks on Login button
    Then error message should be displayed

  Scenario: Login with invalid credentials
    When user enters invalid username
    When user enters invalid password
    And user clicks on Login button
    Then error message should be displayed

  Scenario: Login with empty credentials
    When user enters empty username
    When user enters empty password
    And user clicks on Login button
    Then error message should be displayed