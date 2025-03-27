Feature: Sign In functionality

  Background:
    Given user launches the website

    Scenario: 1) Verify the navigation after clicking on sign in link
      Given click on sign in link
      Then verify user is navigated to customer login landing page