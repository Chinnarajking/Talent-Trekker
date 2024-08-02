Feature: Login Functionality
  
  
  Scenario: User successfully logs in with valid credentials
    Given the user is on the login page
    When the user enters the valid username and password
    And the user clicks the login button
    And the user should be redirected to the dashboard
    Then the user logs out of the portal 