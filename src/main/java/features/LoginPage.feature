Feature: Login page feature

  Background:
    Given user is on the login page


  Scenario: Login page title
    When user gets the title of the page
    Then page title should be React app

  Scenario: Login with correct credentials
    When user enters username rahul
    And user enters password
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be React app

  Scenario: Login with in-valid username
    When user enters invalid username
    And user enters password
    And user clicks on Login button
    Then user gets the error message
    And error message should be invalid username

  Scenario: Login with in-valid password
    When user enters username rahul
    And user enters invalid password
    And user clicks on Login button
    Then user gets the error message
    And error message should be invalid password

  Scenario: Login with invalid credentials
    When user enters invalid username and password
    And user clicks on Login button
    Then user gets the error message
    And error message should be invalid username

  Scenario: Login with empty credentials
    When user enters empty username and password
    And user clicks on Login button
    Then user gets the error message
    And error message should be *Username or password is invalid