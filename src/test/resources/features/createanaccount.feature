Feature: Create An Account functionality

  Scenario: 1) Verify the navigation after clicking on create an account link
    Given click on the create an account link
    Then verify user is navigated to create new customer account landing page

  Scenario: 2) Verify the account creation and signing in with that account
    Given click on the create an account link
    And enter correct details
    And click on create an account button
    Then verify the registering success message
    And sign out the application
    Given click on sign in link
    And enter correct credentials
    And click on sign in button
    Then verify user is signed in successfully

